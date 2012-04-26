package webactions.crud;

import persistence.UserDAO;
import persistence.ProductDAO;
import persistence.SaleDAO;
import persistence.PersistenceDAO;
import persistence.CommentDAO;
import model.Comment;
import model.Product;
import model.Sale;
import model.User;
import webactions.AbstractServlet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateServlet extends AbstractServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        UserDAO persistenceManagerUser = PersistenceDAO.getUserDAO(mechanismOfPersistence);
        SaleDAO persistenceManagerSale = PersistenceDAO.getSaleDAO(mechanismOfPersistence);
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(mechanismOfPersistence);
        CommentDAO persistenceManagerComment = PersistenceDAO.getCommentDAO(mechanismOfPersistence);
        HttpSession session = request.getSession();
        String type = request.getParameter("type");

        if (type == null) {
            goToURL(errorForm, request, response);
        } else {
            switch (type) {
                case "user":
                    User user = generateUserFromRequest(request);
                    if (user != null && persistenceManagerUser.newUser(user)) {
                        session.setAttribute("admin", false);
                        request.setAttribute("user", user);
                        request.setAttribute("message", "Usuario creado con éxito");
                        goToNamedResource(successPage, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, "Fallo al Crear el Nuevo Usuario");
                        goToURL(errorForm, request, response);
                    }
                    break;
                case "sale":
                    Sale sale = generateSaleFromRequest(request);
                    if (sale != null && persistenceManagerSale.newSale(sale)) {
                        session.setAttribute("sale", sale);
                        //Aquí hay que redirigir a la página de confirmación de la venta
                        goToNamedResource(successPage, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, "Fallo al Crear la Nueva Venta");
                        goToURL(errorForm, request, response);
                    }
                    break;
                case "product":
                    Product product = generateProductFromRequest(request);
                    if (product != null && persistenceManagerProduct.newProduct(product)) {
                        session.setAttribute("product", product);
                        request.setAttribute("message", "Producto creado con éxito");
                        goToNamedResource(successPage, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, "Fallo al Crear el Nuevo Producto");
                        goToURL(errorForm, request, response);
                    }
                    break;
                case "comment":
                    Comment comment = generateCommentFromRequest(request);
                    if (comment != null && persistenceManagerComment.newComment(comment)) {
                        session.setAttribute("comment", comment);
                        session.setAttribute("message", "Comentario añadido con éxito");
                        goToNamedResource(successPage, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, "Fallo al Crear el Nuevo Comentario");
                        goToURL(errorForm, request, response);
                    }
                    break;
                default:
                    goToURL(errorForm, request, response);
                    break;
            }
        }
    }

    User generateUserFromRequest(HttpServletRequest request) {
        User user;
        String userName = request.getParameter("userName");
        String userSurnames = request.getParameter("userSurnames");
        String userAdress = request.getParameter("userAdress");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        user = new User(userName, userSurnames, userAdress, userEmail, userPassword);
        boolean validate = validateUser();
        if (!validate) {
            return null;
        }
        return user;
    }

    Sale generateSaleFromRequest(HttpServletRequest request) {
        Sale sale = null;
        //Faltan el resto de parámetros por insertar en la Venta
        String salePaymentMethod = request.getParameter("salePaymentMethod");
        boolean validate = validateSale();
        if (!validate) {
            return null;
        }
        sale.setSalePaymentMethod(salePaymentMethod);
        return sale;
    }

    Product generateProductFromRequest(HttpServletRequest request) {
        Product product;
        String productID = request.getParameter("productID");
        String productPrice = request.getParameter("productPrice");
        String productShortDescription = request.getParameter("productShortDescription");
        String productLongDescription = request.getParameter("productLongDescription");
        String productStock = request.getParameter("productStock");
        boolean validate = validateProduct();
        if (!validate) {
            return null;
        }
        product = new Product(productID, Float.parseFloat(productPrice), productShortDescription,
                productLongDescription, Integer.parseInt(productStock), null);
        return product;
    }

    Comment generateCommentFromRequest(HttpServletRequest request) {
        Comment comment;
        String commentID = request.getParameter("commentID");
        String commentDate = request.getParameter("commentDate");
        String commentProductID = request.getParameter("commentProductID");
        String commentUserEmail = request.getParameter("commentUserEmail");
        String commentContent = request.getParameter("commentContent");
        boolean validate = validateComment();
        if (!validate) {
            return null;
        }
        comment = new Comment(commentID, commentDate, commentProductID, commentUserEmail, commentContent);
        return comment;
    }

    //Falta por hacer las validaciones:
    private boolean validateUser() {
        return false;
    }

    private boolean validateSale() {
        return false;
    }

    private boolean validateProduct() {
        return false;
    }

    private boolean validateComment() {
        return false;
    }
}
