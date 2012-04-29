package webactions.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import persistence.PersistenceDAO;
import persistence.ProductDAO;
import webactions.MyCoolServlet;

public class DeleteServlet extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(persistenceMechanism);
        String name = request.getParameter("name");
        Product product = persistenceManagerProduct.getProduct(name);
        if (product != null && persistenceManagerProduct.deleteProduct(product)) {
            request.setAttribute("product", product);
            request.setAttribute("message", "Borrado con éxito");
            goToURL(successForm, request, response);
        } else {
            goToURL(successForm, request, response);
        }
    }
}
