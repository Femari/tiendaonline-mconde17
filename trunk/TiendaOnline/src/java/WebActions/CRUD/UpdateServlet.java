package WebActions.CRUD;

import Model.Product;
import Persistence.PersistenceDAO;
import Persistence.ProductDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends CreateServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(mechanismOfPersistence);
        String newName = request.getParameter("newName");
        Product oldProduct = persistenceManagerProduct.getProduct(newName);
        Product newProduct = super.generateProductFromRequest(request);
        if (persistenceManagerProduct.updateProduct(oldProduct, newProduct)) {
            request.setAttribute("product", newProduct);
            request.setAttribute("message", "Modificado con éxito");
            goToURL(successPage, request, response);
        } else {
            goToURL(errorForm, request, response);
        }
    }
}
