package WebActions.CRUD;

import Model.Product;
import Persistence.PersistenceDAO;
import Persistence.ProductDAO;
import WebActions.AbstractServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends AbstractServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(mechanismOfPersistence);
        String name = request.getParameter("name");
        Product product = persistenceManagerProduct.getProduct(name);
        if(product!= null && persistenceManagerProduct.deleteProduct(product)){
            request.setAttribute("product", product);
            request.setAttribute("message", "Borrado con éxito");
            goToURL(sucessPage, request, response);
        }else{
            goToURL(sucessPage, request, response);
        }
    }
}
