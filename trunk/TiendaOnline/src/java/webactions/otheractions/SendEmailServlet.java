package webactions.otheractions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.Sale;
import model.ShoppingCart;
import persistence.PersistenceFactory;
import persistence.SaleDAO;
import webactions.MyCoolServlet;
import webactions.StartUpListener;

public class SendEmailServlet extends MyCoolServlet {

    private String HOST = "smtp.gmail.com";
    private String USER = "electronixstorelpi@gmail.com";
    private String PASS = "electronixstorelpi";
    private String PORT = "465";
    private static String STARTTLS = "true";
    private static String AUTH = "true";
    private static String DEBUG = "true";
    private static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setAttribute("email", "send");
        HttpSession session = request.getSession();
        Sale sale = (Sale) request.getAttribute("sale");
        ServletContext context = StartUpListener.getContext();
        HashMap<String, Product> catalog = (HashMap<String, Product>) context.getAttribute("productList");
        ShoppingCart cart = sale.getSaleShoppingCart();
        Boolean synchronizedCorrect = false;
        ArrayList<Product> undoUpdateCatalog = new ArrayList<>();
        synchronized (catalog) {
            //Ajustar los Stock de productos:
            ArrayList<Product> productList = cart.getShoppingCart();
            Iterator it = productList.iterator();
            while (it.hasNext()) {
                Product p = (Product) it.next();
                if (p.getProductStock() > 0) {
                    undoUpdateCatalog.add(p);
                    p.setProductStock(p.getProductStock() - 1);
                    catalog.remove(p.getProductID());
                    catalog.put(p.getProductID(), p);
                    synchronizedCorrect = true;
                } else {
                    synchronizedCorrect = false;
                    break;
                }
            }
        }
        if (synchronizedCorrect) {
            //Ajustar propiedades del email:
            Properties properties = new Properties();
            properties.put("mail.smtp.host", HOST);
            properties.put("mail.smtp.port", PORT);
            properties.put("mail.smtp.user", USER);

            properties.put("mail.smtp.auth", AUTH);
            properties.put("mail.smtp.starttls.enable", STARTTLS);
            properties.put("mail.smtp.debug", DEBUG);

            properties.put("mail.smtp.socketFactory.port", PORT);
            properties.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
            properties.put("mail.smtp.socketFactory.fallback", "false");

            Session sessionEmail = Session.getDefaultInstance(properties);
            sessionEmail.setDebug(true);

            MimeMessage message = new MimeMessage(sessionEmail);
            //Ajustar campos del email:
            try {
                message.setText("Su pedido ha sido tramitado con éxito."
                        + "\nEn breve escucharás el timbre y podrás disfrutar de tu compra ;)"
                        + "\n\nEstos son los productos que has comprado: \n"
                        + cart.listShoppingCart()
                        + "\n\n Total de la compra: " + cart.getPriceOfShoppingCart()
                        + "\n Tipo de Pago: " + sale.getSalePaymentMethod()
                        + "\n\nGracias por confiar en Electronix. Esperamos que quede satisfecho");
                message.setSubject("ELECTRONIX - Factura Nº:" + sale.getSaleID());
                message.setFrom(new InternetAddress(USER));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(sale.getSaleClient().getUserEmail()));
                message.saveChanges();
            } catch (javax.mail.MessagingException ex) {
                Logger.getLogger(SendEmailServlet.class.getName()).log(Level.SEVERE,
                        "Fallo al crear el cuerpo del Email", ex);
            }
            Transport transport = null;
            //Enviar el email:
            try {
                transport = sessionEmail.getTransport("smtps");
                transport.connect(HOST, USER, PASS);
                transport.sendMessage(message, message.getAllRecipients());
                if (transport != null) {
                    HashMap<String, Sale> saleList = (HashMap<String, Sale>) context.getAttribute("saleList");
                    saleList.put(sale.getSaleID(), sale);
                    context.setAttribute("saleList", saleList);
                    SaleDAO sales = PersistenceFactory.getSaleDAO(persistenceMechanism);
                    sales.newSale(sale);
                    session.removeAttribute("sale");
                    session.removeAttribute("shoppingCart");
                    session.setAttribute("authentication", false);
                    session.setAttribute("confirmation", true);
                    context.setAttribute("productList", catalog);
                    goToURL(successForm, request, response);
                } else {
                    goToURL(errorForm, request, response);
                }
            } catch (javax.mail.MessagingException ex) {
                Logger.getLogger(SendEmailServlet.class.getName()).log(Level.SEVERE,
                        "Fallo al crear la conexión para enviar el Email", ex);
            } finally {
                try {
                    transport.close();
                } catch (javax.mail.MessagingException ex) {
                    Logger.getLogger(SendEmailServlet.class.getName()).log(Level.SEVERE,
                            "Fallo al cerrar la conexión para enviar el Email", ex);
                }
            }
        } else {
            synchronized (catalog) {
                Product pFirst = null;
                Product pActual;
                Iterator it = undoUpdateCatalog.iterator();
                while (it.hasNext()) {
                    pActual = (Product) it.next();
                    if (!pFirst.equals(pActual)) {
                        pFirst = pActual;
                        catalog.remove(pFirst.getProductID());
                        catalog.put(pFirst.getProductID(), pFirst);
                    }
                }
                session.setAttribute("productList", catalog);
            }
        }
    }
}
