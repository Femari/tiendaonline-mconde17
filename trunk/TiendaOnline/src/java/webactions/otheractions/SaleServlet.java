package webactions.otheractions;

import java.io.IOException;
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
