package webactions.crud;

import java.io.IOException;
import java.util.HashMap;
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

public class ReadServlet extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean admin = (Boolean) session.getAttribute("admin");
        ProductDAO persistenceManagerProduct = PersistenceDAO.getProductDAO(persistenceMechanism);
        SaleDAO persistenceManagerSale = PersistenceDAO.getSaleDAO(persistenceMechanism);
        UserDAO persistenceManagerUser = PersistenceDAO.getUserDAO(persistenceMechanism);
        CommentDAO persistenceManagerComment = PersistenceDAO.getCommentDAO(persistenceMechanism);
        String parameter = request.getParameter("parameter");
        String condition = request.getParameter("condition");
        Product product;
        HashMap<String, Product> productResult;
        Sale sale;
        HashMap<String, Sale> saleResult;
        if (parameter == null) {
            product = persistenceManagerProduct.getProduct(condition);
            productResult = null;
        } else {
            productResult = (HashMap<String, Product>) persistenceManagerProduct.getProductMap(parameter, condition);
            product = null;
        }

        if (parameter == null) {
            sale = persistenceManagerSale.getSale(condition);
            saleResult = null;
        } else {
            if (parameter.equals("all")) {
                saleResult = (HashMap<String, Sale>) persistenceManagerSale.getSaleMap();
            } else {
                saleResult = (HashMap<String, Sale>) persistenceManagerSale.getSaleMap(parameter, condition);
            }
            sale = null;
        }
        User user = persistenceManagerUser.getUser(condition);
        Comment comment = persistenceManagerComment.getComment(condition);
        if (product != null) {
            HashMap<String, Comment> commentList = (HashMap<String, Comment>) persistenceManagerComment.getCommentMap("productID", product.getProductID());
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("product", product);
            request.setAttribute("commentList", commentList);
            goToURL(productDetails, request, response);
        } else if (product == null && productResult != null && admin != null && admin) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("productAdminList", productResult);
            goToURL(productOrSaleList, request, response);
        } else if (sale != null) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("sale", sale);
            goToURL(successForm, request, response);
        } else if (sale == null && saleResult != null && admin != null && admin) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("saleAdminList", saleResult);
            goToURL(productOrSaleList, request, response);
        } else if (user != null) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("user", user);
            goToURL(successForm, request, response);
        } else if (comment != null) {
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("comment", comment);
            goToURL(successForm, request, response);
        } else {
            goToURL(errorForm, request, response);
        }
    }
}
