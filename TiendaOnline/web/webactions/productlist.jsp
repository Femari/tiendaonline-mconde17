<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    Navegación: <span class="current">Lista de Productos</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">

                    <div class="center_title_bar">Productos</div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="/TiendaOnline/webactions/productdetails.jsp">Motorola 156 MX-VL</a></div>
                            <div class="product_img"><a href="/TiendaOnline/webactions/productdetails.jsp">
                                    <img src="/TiendaOnline/images/laptop.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span>
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="/WEB-INF/view/errors/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="/WEB-INF/view/errors/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="/TiendaOnline/webactions/productdetails.jsp" class="prod_details">Detalles</a>            
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="/TiendaOnline/webactions/productDetails.jsp">Iphone Apple</a></div>
                            <div class="product_img"><a href="/TiendaOnline/webactions/productDetails.jsp">
                                    <img src="/TiendaOnline/images/p4.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="/WEB-INF/view/errors/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="/WEB-INF/view/errors/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="/TiendaOnline/webactions/productdetails.jsp" class="prod_details">Detalles</a>             
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="/TiendaOnline/webactions/productdetails.jsp">Samsung Webcam</a></div>
                            <div class="product_img"><a href="/TiendaOnline/webactions/productdetails.jsp">
                                    <img src="/TiendaOnline/images/p5.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span> 
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="/WEB-INF/view/errors/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="/WEB-INF/view/errors/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="/TiendaOnline/images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="/TiendaOnline/webactions/productDetails.jsp" class="prod_details">Detalles</a>            
                        </div>                     
                    </div> 

                </div><!-- end of center content -->

                <%@include file="/WEB-INF/view/rightpage.jsp" %> 

            </div><!-- end of main content -->

            <%@include file="/WEB-INF/view/footerpage.jsp" %>

        </div><!-- end of main_container -->
    </body>
</html>