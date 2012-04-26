package webactions.otheractions2;

import model2.Sale;
import model2.ShoppingCart;
import model2.User;
import webactions2.AbstractServlet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaleServlet extends AbstractServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        boolean authentication = (boolean) session.getAttribute("authentication");
        User user = (User) session.getAttribute("user");
        if (authentication) {
            //Falta por generar el ID de la Venta, la forma de Pago y la fecha
            Sale sale = new Sale("", user, new ShoppingCart(), "", "");
            request.setAttribute("sale", sale);
            //Falta por construir la página de confirmación
            goToURL("PAGINADECONFIRMACION", request, response);
        } else {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, "autenticado es {0}", authentication);
            //Falta por construir la página el formulario de Venta
            goToURL("FORMULARIODEVENTA", request, response);
        }
    }
}
