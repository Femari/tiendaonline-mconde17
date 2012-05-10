package webactions.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import persistence.PersistenceFactory;
import persistence.ProductDAO;

public class UpdateServlet extends CreateServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO persistenceManagerProduct = PersistenceFactory.getProductDAO(persistenceMechanism);
        String oldProductID = request.getParameter("oldProductID");
        Product oldProduct = persistenceManagerProduct.getProduct(oldProductID);
        Product newProduct = super.generateProductFromRequest(request);
        newProduct.setProductID(oldProduct.getProductID());
        if (persistenceManagerProduct.updateProduct(oldProduct, newProduct)) {
            request.setAttribute("product", newProduct);
            request.setAttribute("message", "Modificado con éxito");
            goToURL(successForm, request, response);
        } else {
            goToURL(errorForm, request, response);
        }
    }
}
