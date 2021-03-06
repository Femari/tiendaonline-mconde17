package webactions.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comment;
import model.Product;
import persistence.CommentDAO;
import persistence.PersistenceFactory;
import persistence.ProductDAO;
import webactions.MyCoolServlet;

public class DeleteServlet extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO persistenceManagerProduct = PersistenceFactory.getProductDAO(persistenceMechanism);
        CommentDAO persistenceManagerComment = PersistenceFactory.getCommentDAO(persistenceMechanism);
        String name = request.getParameter("name");
        Product product = persistenceManagerProduct.getProduct(name);
        Comment comment = persistenceManagerComment.getComment(name);
        if (product != null && persistenceManagerProduct.deleteProduct(product)) {
            request.setAttribute("product", product);
            request.setAttribute("message", "Borrado con éxito");
            goToURL(successForm, request, response);
        } else if (comment != null && persistenceManagerComment.deleteComment(comment)) {
            request.setAttribute("comment", comment);
            request.setAttribute("message", "Borrado con éxito");
            goToURL(successForm, request, response);
        } else {
            goToURL(errorForm, request, response);
        }
    }
}
