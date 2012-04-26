package webactions2.crud;

import model.Product;
import persistence.PersistenceDAO;
import persistence.ProductDAO;
import webactions2.AbstractServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends AbstractServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(mechanismOfPersistence);
        String name = request.getParameter("name");
        Product product = persistenceManagerProduct.getProduct(name);
        if (product != null && persistenceManagerProduct.deleteProduct(product)) {
            request.setAttribute("product", product);
            request.setAttribute("message", "Borrado con éxito");
            goToURL(successPage, request, response);
        } else {
            goToURL(successPage, request, response);
        }
    }
}
