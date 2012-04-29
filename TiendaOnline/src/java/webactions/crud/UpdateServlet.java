package webactions.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import persistence.PersistenceDAO;
import persistence.ProductDAO;

public class UpdateServlet extends CreateServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(persistenceMechanism);
        String newName = request.getParameter("newName");
        Product oldProduct = persistenceManagerProduct.getProduct(newName);
        Product newProduct = super.generateProductFromRequest(request);
        if (persistenceManagerProduct.updateProduct(oldProduct, newProduct)) {
            request.setAttribute("product", newProduct);
            request.setAttribute("message", "Modificado con éxito");
            goToURL(successForm, request, response);
        } else {
            goToURL(errorForm, request, response);
        }
    }
}
