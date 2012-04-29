package webactions.otheractions;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.ShoppingCart;
import webactions.MyCoolServlet;

public class AddToShoppingCartServlet extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String productName = request.getParameter("productName");
        String productAmount = request.getParameter("productAmount");
        int amount = Integer.parseInt(productAmount);
        ServletContext context = request.getServletContext();
        Map<String, Product> productList = (Map<String, Product>) context.getAttribute("productList");
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        Boolean authentication = (Boolean) session.getAttribute("authentication");
        if (authentication == null) {
            session.setAttribute("authentication", false);
            Logger.getLogger(AddToShoppingCartServlet.class.getName()).log(Level.SEVERE,
                    "El usuario no se ha registrado", authentication);
        }
        for (int i = 0; i < amount; i++) {
            cart.addProduct(productList.get(productName));
        }
        goToURL(successForm, request, response);
    }
}
