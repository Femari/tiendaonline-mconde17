package webactions.crud;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Comment;
import model.Product;
import model.Sale;
import model.User;
import persistence.*;
import webactions.MyCoolServlet;

public class CreateServlet extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDAO persistenceManagerUser = PersistenceDAO.getUserDAO(persistenceMechanism);
        SaleDAO persistenceManagerSale = PersistenceDAO.getSaleDAO(persistenceMechanism);
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(persistenceMechanism);
        CommentDAO persistenceManagerComment = PersistenceDAO.getCommentDAO(persistenceMechanism);
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
                        goToURL(successForm, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE,
                                "Fallo al Crear el Nuevo Usuario");
                        goToURL(errorForm, request, response);
                    }
                    break;
                case "sale":
                    Sale sale = generateSaleFromRequest(request);
                    if (sale != null && persistenceManagerSale.newSale(sale)) {
                        session.setAttribute("sale", sale);
                        goToURL("/WEB-INF/view/confirmationsale.jsp", request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE,
                                "Fallo al Crear la Nueva Venta");
                        goToURL(errorForm, request, response);
                    }
                    break;
                case "product":
                    Product product = generateProductFromRequest(request);
                    if (product != null && persistenceManagerProduct.newProduct(product)) {
                        session.setAttribute("product", product);
                        HashMap<String, Product> productList = new HashMap<>();
                        if (session.getAttribute("productList") == null) {
                            session.setAttribute("productList", productList);
                        }
                        productList = (HashMap<String, Product>) session.getAttribute("productList");
                        productList.put(product.getProductID(), product);
                        session.setAttribute("productList", productList);
                        request.setAttribute("message", "Producto creado con éxito");
                        goToURL(successForm, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE,
                                "Fallo al Crear el Nuevo Producto");
                        goToURL(errorForm, request, response);
                    }
                    break;
                case "comment":
                    Comment comment = generateCommentFromRequest(request);
                    if (comment != null && persistenceManagerComment.newComment(comment)) {
                        session.setAttribute("comment", comment);
                        session.setAttribute("message", "Comentario añadido con éxito");
                        goToURL(successForm, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE,
                                "Fallo al Crear el Nuevo Comentario");
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
        boolean validate = validateUser(user);
        if (!validate) {
            return null;
        }
        return user;
    }

    Sale generateSaleFromRequest(HttpServletRequest request) {
        Sale sale = new Sale();
        String salePaymentMethod = request.getParameter("salePaymentMethod");
        String saleAdress = request.getParameter("saleAdress");
        boolean validate = validateSale(sale);
        if (!validate) {
            return null;
        }
        sale.setSaleID(sale.generateSaleID());
        sale.setSalePaymentMethod(salePaymentMethod);
        sale.setSaleAdress(saleAdress);
        return sale;
    }

    Product generateProductFromRequest(HttpServletRequest request) {
        Product product;
        String productID = "";
        String productPrice = request.getParameter("productPrice");
        String productShortDescription = request.getParameter("productShortDescription");
        String productLongDescription = request.getParameter("productLongDescription");
        String productStock = request.getParameter("productStock");
        String productImageURL = request.getParameter("productImageURL");
        product = new Product(productID, Double.parseDouble(productPrice), productShortDescription,
                productLongDescription, Integer.parseInt(productStock), productImageURL);
        product.setProductID(product.generateProductID());
        boolean validate = validateProduct(product);
        if (!validate) {
            return null;
        }
        return product;
    }

    Comment generateCommentFromRequest(HttpServletRequest request) {
        Comment comment;
        String commentID = "";
        String commentDate = request.getParameter("commentDate");
        String commentProductID = request.getParameter("commentProductID");
        String commentUserEmail = request.getParameter("commentUserEmail");
        String commentContent = request.getParameter("commentContent");
        comment = new Comment(commentID, commentDate, commentProductID, commentUserEmail, commentContent);
        comment.setCommentID(comment.generateCommentID());
        boolean validate = validateComment(comment);
        if (!validate) {
            return null;
        }
        return comment;
    }

    //Falta por hacer las validaciones:
    private boolean validateUser(User user) {
        return true;
    }

    private boolean validateSale(Sale sale) {
        return true;
    }

    private boolean validateProduct(Product product) {
        return true;
    }

    private boolean validateComment(Comment comment) {
        return true;
    }
}
