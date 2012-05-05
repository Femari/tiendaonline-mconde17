package webactions.otheractions;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Sale;
import model.ShoppingCart;
import model.User;
import webactions.MyCoolServlet;

public class SaleServlet extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean authentication = (boolean) session.getAttribute("authentication");
        User user = (User) session.getAttribute("user");
        Sale sale = new Sale();
        if (authentication) {
            sale.setSaleID(sale.generateSaleID());
            sale.setSaleAdress((String)request.getAttribute("saleAdress"));
            sale.setSaleClient(user);
            sale.setSaleShoppingCart((ShoppingCart)session.getAttribute("shoppingCart"));
            sale.setSalePaymentMethod((String)request.getAttribute("salePaymentMethod"));
            Date date = new Date();
            sale.setSaleDate(date.toString());
            request.setAttribute("sale", sale);
            goToNamedResource(sendEmailServlet, request, response);
        } else {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, "Usuario No Registrado", authentication);
            goToURL("/TiendaOnline/webactionsuser/usercreate.jsp", request, response);
        }
    }
}
