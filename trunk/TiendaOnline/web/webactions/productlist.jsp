<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Product"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Electronix Store</title>
        <link href="/TiendaOnline/images/favicon.ico" type="image/x-icon" rel="shortcut icon" />
        <link rel="stylesheet" type="text/css" href="/TiendaOnline/css/style.css" />
        <script type="text/javascript" src="/TiendaOnline/javascripts/boxOver.js"></script>
    </head>
    <body>

        <div id="main_container">

            <%@include file="/WEB-INF/view/headerpage.jsp" %>

            <div id="main_content"> 

                <%@include file="/WEB-INF/view/titlepage.jsp" %>

                <div class="crumb_navigation">
                    Navegación: <span class="current">Lista de Productos</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">

                    <div class="center_title_bar">Productos</div>
                    <% Map<String, Product> productList = (Map<String, Product>) application.getAttribute("productList");
                        Product p;
                        Iterator it = productList.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry e = (Map.Entry) it.next();
                            p = (Product) e.getValue();
                    %>
                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="/TiendaOnline/FrontController?form=readServlet&type=product&parameter=true&condition=<%= p.getProductID()%>"><%= p.getProductShortDescription()%></a></div>
                            <div class="product_img"><a href="/TiendaOnline/FrontController?form=readServlet&type=product&parameter=true&condition=<%= p.getProductID()%>">
                                    <img src="/TiendaOnline/images/<%= p.getProductImageURL()%>" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="price"><%= p.getProductPrice()%> €</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="/TiendaOnline/FrontController?form=addToShoppingCartServlet&productName=<%= p.getProductID()%>&productAmount=1" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="/WEB-INF/view/errors/error404.jsp" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="/WEB-INF/view/errors/error404.jsp" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="/TiendaOnline/FrontController?form=readServlet&type=product&parameter=true&condition=<%= p.getProductID()%>" class="prod_details">Detalles</a>            
                        </div>                     
                    </div>
                    <%
                        }
                    %>

                </div><!-- end of center content -->

                <%@include file="/WEB-INF/view/rightpage.jsp" %> 

            </div><!-- end of main content -->

            <%@include file="/WEB-INF/view/footerpage.jsp" %>

        </div><!-- end of main_container -->
    </body>
</html>