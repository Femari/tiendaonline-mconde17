package webactions.crud2;

import model2.Product;
import model2.Sale;
import model2.User;
import persistence2.PersistenceDAO;
import persistence2.ProductDAO;
import persistence2.SaleDAO;
import persistence2.UserDAO;
import webactions2.AbstractServlet;
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
