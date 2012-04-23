package WebActions.CRUD;

import Model.Product;
import Model.Sale;
import Model.User;
import Persistence.PersistenceDAO;
import Persistence.ProductDAO;
import Persistence.SaleDAO;
import Persistence.UserDAO;
import WebActions.AbstractServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadServlet extends AbstractServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(mechanismOfPersistence);
        SaleDAO persistenceManagerSale = PersistenceDAO.getSaleDAO(mechanismOfPersistence);
        UserDAO persistenceManagerUser = PersistenceDAO.getUserDAO(mechanismOfPersistence);
        String name = request.getParameter("name");
        Product product = persistenceManagerProduct.getProduct(name);
        Sale sale = persistenceManagerSale.getSale(name);
        User user = persistenceManagerUser.getUser(name);
        if (product != null) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("product", product);
            goToURL(displayPage, request, response);
        } else if (sale != null) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("sale", sale);
            goToURL(displayPage, request, response);
        } else if (user != null) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("user", user);
            goToURL(displayPage, request, response);
        } else {
            goToURL(errorPage, request, response);
        }
    }
}