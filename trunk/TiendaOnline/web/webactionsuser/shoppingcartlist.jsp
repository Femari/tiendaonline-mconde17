<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ShoppingCart"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<% ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingCart");%>
<% ArrayList<Product> cartProducts = cart.getShoppingCart();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Electronix Store</title>
        <link rel="stylesheet" type="text/css" href="/TiendaOnline/css/style.css" />
        <script type="text/javascript" src="/TiendaOnline/javascripts/boxOver.js"></script>
    </head>
    <body>

        <div id="main_container">

            <%@include file="/WEB-INF/view/headerpage.jsp" %>

            <div id="main_content"> 

                <%@include file="/WEB-INF/view/titlepage.jsp" %>

                <div class="crumb_navigation">
                    Navegación: <span class="current">Carrito de la Compra</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">

                    <div class="center_title_bar">Productos del carrito:</div>
                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">
                            <% Iterator it = cartProducts.iterator();
                                while (it.hasNext()) {
                                    Product p = (Product) it.next();%>
                            <br>
                            <br><strong>Producto:</strong> <%= p.getProductShortDescription()%>
                            <strong>Precio:</strong>    <%= p.getProductPrice()%>           
                            <%
                                }%>
                            <% if(cart.getPriceOfShoppingCart()>0 && cart.getNumberOfProducts()>0){%>
                                <br><br><strong>Precio del carrito:</strong> <%= cart.getPriceOfShoppingCart()%> € <br>
                            <form action="/TiendaOnline/FrontController">
                                <input name="form" value="saleServlet" type="hidden"/>
                                <button>Realizar la Compra</button>
                            </form>
                            <%}%>
                        </div>
                        <div class="bottom_prod_box_big"></div>                                
                    </div>
                </div>
            </div><!-- end of center content -->

            <%@include file="/WEB-INF/view/rightpage.jsp" %> 

        </div><!-- end of main content -->

        <%@include file="/WEB-INF/view/footerpage.jsp" %>

    </div><!-- end of main_container -->
</body>
</html>
