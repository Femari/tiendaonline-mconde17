package webactions.crud;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
        ProductDAO persistenceManagerProduct = PersistenceFactory.getProductDAO(persistenceMechanism);
        SaleDAO persistenceManagerSale = PersistenceFactory.getSaleDAO(persistenceMechanism);
        UserDAO persistenceManagerUser = PersistenceFactory.getUserDAO(persistenceMechanism);
        CommentDAO persistenceManagerComment = PersistenceFactory.getCommentDAO(persistenceMechanism);
        String parameter = request.getParameter("parameter");
        String condition = request.getParameter("condition");
        String lightSearch = request.getParameter("lightsearch");
        String type = request.getParameter("type");
        Product product;
        HashMap<String, Product> productResult;
        Sale sale;
        HashMap<String, Sale> saleResult;
        if (lightSearch != null && type.equals("product")) {
            HashMap<String, Product> productList = (HashMap<String, Product>) persistenceManagerProduct.getProductMap(parameter, condition);
            Iterator it = productList.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                product = (Product) e.getValue();
            } else {
                product = null;
            }
            productResult = null;
        } else if (parameter.equals("true") && type != null && type.equals("product")) {
            HashMap<String, Product> productList = (HashMap<String, Product>) persistenceManagerProduct.getProductMap("productID", condition);
            product = productList.get(condition);
            productResult = null;
        } else if (type != null && type.equals("product")) {
            productResult = (HashMap<String, Product>) persistenceManagerProduct.getProductMap(parameter, condition);
            product = null;
        } else {
            product = null;
            productResult = null;
        }

        if (parameter == null && type != null && type.equals("sale")) {
            sale = persistenceManagerSale.getSale(condition);
            saleResult = new HashMap<>();
            saleResult.put(sale.getSaleID(), sale);
        } else if (type != null && type.equals("sale")) {
            if (parameter.equals("all")) {
                saleResult = (HashMap<String, Sale>) persistenceManagerSale.getSaleMap();
            } else {
                saleResult = (HashMap<String, Sale>) persistenceManagerSale.getSaleMap(parameter, condition);
            }
            sale = null;
        } else {
            sale = null;
            saleResult = null;
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
            request.setAttribute("message", "Tiene la siguiente información almacenada: ");
            request.setAttribute("saleAdminList", saleResult);
            goToURL(productOrSaleList, request, response);
        } else if (saleResult != null && admin != null && admin) {
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
