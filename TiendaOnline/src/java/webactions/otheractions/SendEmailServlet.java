package webactions.otheractions;

import model.Product;
import model.Sale;
import model.ShoppingCart;
import webactions.AbstractServlet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendEmailServlet extends AbstractServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        request.setAttribute("email", "send");
        HttpSession session = request.getSession();
        Sale sale = (Sale) request.getAttribute("sale");
        ShoppingCart cart = sale.getSaleShoppingCart();
        //Ajustar los Stock de productos:
        ArrayList<Product> productList = cart.getShoppingCart();
        Iterator it = productList.iterator();
        while (it.hasNext()) {
            Product p = (Product) it.next();
            p.setProductStock(p.getProductStock() - 1);
        }
        //Ajustar propiedades del email:
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.startttls.enable", "true");
        properties.setProperty("mail.smtp.port", "25");
        properties.setProperty("mail.smtp.user", "electronixstorelpi@gmail.com");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.localhost", "localhost");
        Session sessionEmail = Session.getDefaultInstance(properties);
        sessionEmail.setDebug(true);
        MimeMessage message = new MimeMessage(sessionEmail);
        //Ajustar campos del email:
        try {
            message.setText("Su pedido ha sido tramitado con éxito."
                    + "\nEn breve escucharás el timbre y podrás disfrutar de tu compra ;)"
                    + "\n\nEstos son los productos que has comprado: "
                    + cart.listShoppingCart()
                    + "\n\nGracias por confiar en Electronix. Esperamos que quede satisfecho");
            message.setSentDate(new java.util.Date());
            message.addHeader("Content-Type", "text/html");
            message.setSubject("ELECTRONIX - Factura Nº:" + sale.getSaleID());
            message.setFrom(new InternetAddress("electronixstorelpi@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(sale.getSaleClient().getUserEmail()));
        } catch (javax.mail.MessagingException ex) {
            Logger.getLogger(SendEmailServlet.class.getName()).log(Level.SEVERE,
                    "Fallo al crear el cuerpo del Email", ex);
        }
        Transport transport = null;
        //Enviar el email:
        try {
            transport = sessionEmail.getTransport("smtp");
            transport.connect("electronixstorelpi@gmail.com", "electronixstorelpi");
            transport.sendMessage(message, message.getAllRecipients());
            if (transport != null) {
                session.removeAttribute("sale");
                session.setAttribute("confirmation", true);
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
    }
}
