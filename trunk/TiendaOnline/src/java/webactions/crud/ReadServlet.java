package webactions.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Sale;
import model.User;
import persistence.PersistenceDAO;
import persistence.ProductDAO;
import persistence.SaleDAO;
import persistence.UserDAO;
import webactions.MyCoolServlet;

public class ReadServlet extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(persistenceMechanism);
        SaleDAO persistenceManagerSale = PersistenceDAO.getSaleDAO(persistenceMechanism);
        UserDAO persistenceManagerUser = PersistenceDAO.getUserDAO(persistenceMechanism);
        String name = request.getParameter("name");
        Product product = persistenceManagerProduct.getProduct(name);
        Sale sale = persistenceManagerSale.getSale(name);
        User user = persistenceManagerUser.getUser(name);
        if (product != null) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("product", product);
            goToURL(displayForm, request, response);
        } else if (sale != null) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("sale", sale);
            goToURL(displayForm, request, response);
        } else if (user != null) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("user", user);
            goToURL(displayForm, request, response);
        } else {
            goToURL(errorForm, request, response);
        }
    }
}
