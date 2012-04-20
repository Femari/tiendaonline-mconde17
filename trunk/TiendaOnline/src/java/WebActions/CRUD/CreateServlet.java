package WebActions.CRUD;

import Model.Comment;
import Model.Product;
import Model.Sale;
import Model.User;
import Persistence.*;
import WebActions.AbstractServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateServlet extends AbstractServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        UserDAO persistenceManagerUser = PersistenceDAO.getUserDAO(mechanismOfPersistence);
        SaleDAO persistenceManagerSale = PersistenceDAO.getSaleDAO(mechanismOfPersistence);
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(mechanismOfPersistence);
        CommentDAO persistenceManagerComment = PersistenceDAO.getCommentDAO(mechanismOfPersistence);

        String type = request.getParameter("type");

        if (type == null) {
            goToRequestDispatcher(request, response, errorPage, false);
        } else {
            switch (type) {
                case "user":
                    User user = generateUserFromRequest(request);
                    if (user != null && persistenceManagerUser.newUser(user)) {
                    } else {
                    }
                    break;
                case "sale":
                    Sale sale = generateSaleFromRequest(request);
                    if (sale != null && persistenceManagerSale.newSale(sale)) {
                    } else {
                    }
                    break;
                case "product":
                    Product product = generateProductFromRequest(request);
                    if (product != null && persistenceManagerProduct.newProduct(product)) {
                    } else {
                    }
                    break;
                case "comment":
                    Comment comment = generateCommentFromRequest(request);
                    if (comment != null && persistenceManagerComment.newComment(comment)) {
                    } else {
                    }
                    break;
                default:
                    goToRequestDispatcher(request, response, errorPage, false);
                    break;
            }
        }
    }

    User generateUserFromRequest(HttpServletRequest request) {
        return null;
    }

    Sale generateSaleFromRequest(HttpServletRequest request) {
        return null;
    }

    Product generateProductFromRequest(HttpServletRequest request) {
        return null;
    }

    Comment generateCommentFromRequest(HttpServletRequest request) {
        return null;
    }
}
