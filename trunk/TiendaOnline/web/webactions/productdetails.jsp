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
                    Navegación: <span class="current">Lista de Productos < NombredelProducto</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">
                    <div class="center_title_bar">Motorola 156 MX-VL</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            

                            <div class="product_img_big">
                                <a href="javascript:popImage('/images/big_pic.jpg','Some Title')" title="header=[Zoom] body=[&nbsp;] fade=[on]"><img src="/TiendaOnline/images/laptop.gif" alt="" title="" border="0" /></a>
                                <div class="thumbs">
                                    <a href="#" title="header=[Thumb1] body=[&nbsp;] fade=[on]"><img src="/TiendaOnline/images/thumb1.gif" alt="" title="" border="0" /></a>
                                    <a href="#" title="header=[Thumb2] body=[&nbsp;] fade=[on]"><img src="/TiendaOnline/images/thumb1.gif" alt="" title="" border="0" /></a>
                                    <a href="#" title="header=[Thumb3] body=[&nbsp;] fade=[on]"><img src="/TiendaOnline/images/thumb1.gif" alt="" title="" border="0" /></a>
                                </div>
                            </div>
                            <div class="details_big_box">
                                <div class="product_title_big">My Cinema-U3000/DVBT, USB 2.0 TV BOX External, White</div>
                                <div class="specifications">
                                    Disponibilidad: <span class="blue">En Stock</span><br />

                                    Garantía: <span class="blue">24 Meses</span><br />

                                    Tipo de Transporte: <span class="blue">Envío a Domicilio</span><br />

                                    Impuestos Incluidos: <span class="blue">IVA(18%)</span><br />
                                </div>
                                <div class="prod_price_big"><span class="reduce">350$</span> <span class="price">270$</span></div>

                                <a href="#" class="addtocart">Al Carrito!!!</a>
                                <a href="#" class="compare">Compara</a>
                            </div>                        
                        </div>
                        <div class="bottom_prod_box_big"></div>                                
                    </div>
                    
                    <div class="center_title_bar">Descripción del Producto</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            
                            <br>El producto es bla bla bla bla bla bla<br>
                            <br><br>miau miau miau miau miau miau<br>
                            <br>Gatitooooooooooo!!!<br>
                        </div>
                        <div class="bottom_prod_box_big"></div>                                
                    </div>

                </div><!-- end of center content -->

                <%@include file="/WEB-INF/view/rightpage.jsp" %> 

            </div><!-- end of main content -->

            <%@include file="/WEB-INF/view/footerpage.jsp" %>

        </div><!-- end of main_container -->
    </body>
</html>