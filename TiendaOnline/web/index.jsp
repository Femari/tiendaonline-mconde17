<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Electronix Store</title>
        <link rel="stylesheet" type="text/css" href="css2/style.css" />
        <script type="text/javascript" src="javascripts2/boxOver.js"></script>
    </head>
    <body>

        <div id="main_container">
            <div class="top_bar">
                <div class="top_search">
                    <div class="search_text"><a href="#">Buscar Producto:</a></div>
                    <input type="text" class="search_input" name="search" />
                    <input type="image" src="images/search.gif" class="search_bt"/>
                </div>

                <div class="languages">
                    <div class="lang_text">Idiomas:</div>
                    <a href="#" class="lang"><img src="images/es.gif" alt="" title="" border="0" /></a>      
                </div>

            </div>
            <div id="header">

                <div id="logo">
                    <a href="index.jsp"><img src="images/logo.png" alt="" title="" 
                                             border="0" width="237" height="140" /></a>
                </div>

                <div class="oferte_content">
                    <div class="top_divider"><img src="images/header_divider.png" 
                                                  alt="" title="" width="1" height="164" /></div>
                    <div class="oferta">

                        <div class="oferta_content">
                            <img src="images/laptop.png" width="94" height="92" border="0" class="oferta_img" />

                            <div class="oferta_details">
                                <div class="oferta_title">Ordenador en Oferta</div>
                                <div class="oferta_text">
                                    Esto parece que de momento funciona de forma decente xD
                                </div>
                                <a href="webactions/productdetails.jsp" class="details">Detalles</a>
                            </div>
                        </div>
                        <div class="oferta_pagination">

                            <span class="current">1</span>
                            <a href="errors2/error501.html">2</a>
                            <a href="errors2/error501.html">3</a>
                            <a href="errors2/error501.html">4</a>
                            <a href="errors2/error501.html">5</a>  

                        </div>        

                    </div>
                    <div class="top_divider"><img src="images/header_divider.png" 
                                                  alt="" title="" width="1" height="164" /></div>
                </div> <!-- end of oferte_content-->

            </div>

            <div id="main_content"> 

                <div id="menu_tab">
                    <div class="left_menu_corner"></div>
                    <ul class="menu">
                        <li><a href="index.jsp" class="nav1">Inicio</a></li>
                        <li class="divider"></li>
                        <li><a href="errors2/error501.html" class="nav2">Productos</a></li>
                        <li class="divider"></li>
                        <li><a href="errors2/error501.html" class="nav3">Especiales</a></li>
                        <li class="divider"></li>
                        <li><a href="errors2/error501.html" class="nav4">Mi Cuenta</a></li>
                        <li class="divider"></li>
                        <li><a href="errors2/error501.html" class="nav4">Registrar</a></li>
                        <li class="divider"></li>                         
                        <li><a href="errors2/error501.html" class="nav5">Envío</a></li>
                        <li class="divider"></li>
                        <li><a href="webactions/contactus.jsp" class="nav6">Contacta</a></li>
                        <li class="divider"></li>
                        <li class="currencies">Moneda:
                            <select>
                                <option>Euro</option>
                            </select>
                        </li>
                    </ul>

                    <div class="right_menu_corner"></div>
                </div><!-- end of menu tab -->

                <div class="crumb_navigation">
                    Navegación: <span class="current">Principal</span>
                </div>        

                <div class="left_content">
                    <div class="title_box">Categorías</div>

                    <ul class="left_menu">
                        <li class="odd"><a href="errors2/error501.html">Procesadores</a></li>
                        <li class="even"><a href="errors2/error501.html">Placas Base</a></li>
                        <li class="odd"><a href="errors2/error501.html">Sobremesa</a></li>
                        <li class="even"><a href="errors2/error501.html">Portátiles</a></li>
                    </ul> 

                    <div class="title_box">Productos Especiales</div>  
                    <div class="border_box">
                        <div class="product_title"><a href="webactions/productdetails.jsp">
                                Motorola 156 MX-VL</a></div>
                        <div class="product_img"><a href="webactions/productdetails.jsp">
                                <img src="images/laptop.png" alt="" title="" border="0" /></a></div>
                        <div class="prod_price"><span class="reduce">350$</span> 
                            <span class="price">270$</span></div>
                    </div>  

                    <div class="title_box">Noticias</div>  
                    <div class="border_box">
                        <input type="text" name="Noticias" class="newsletter_input" value="Introduce tu e-mail"/>
                        <a href="#" class="join">Únete</a>
                    </div>  

                    <div class="banner_adds">

                        <a href="#"><img src="images/banner.jpg" alt="" title="" border="0" /></a>
                    </div>    

                </div><!-- end of left content -->

                <div class="center_content">
                    <div class="center_title_bar">Últimos Productos</div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">
                                    Motorola 156 MX-VL</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="images/laptop.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span> 
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>            
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Iphone Apple</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="images/p4.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>             
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Samsung Webcam</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="images/p5.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span> 
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>            
                        </div>                     
                    </div> 

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Motorola 156 MX-VL</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="images/laptop.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span>
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>            
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Iphone Apple</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="images/p4.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>             
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Samsung Webcam</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="images/p5.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span> 
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>            
                        </div>                     
                    </div> 

                    <div class="center_title_bar">Productos Recomendados</div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Motorola 156 MX-VL</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="images/laptop.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span> 
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>            
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Iphone Apple</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="images/p4.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>             
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Samsung Webcam</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="images/p5.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span> 
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="errors2/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>            
                        </div>                     
                    </div> 

                </div><!-- end of center content -->

                <div class="right_content">
                    <div class="shopping_cart">
                        <div class="cart_title">Carrito de la Compra</div>

                        <div class="cart_details">
                            3 items <br />
                            <span class="border_cart"></span>
                            Total: <span class="price">350$</span>
                        </div>

                        <div class="cart_icon"><a href="#" title="header=[Visualizar] body=[&nbsp;] fade=[on]">
                                <img src="images/shoppingcart.png" alt="" title="" width="48" height="48" border="0" /></a></div>

                    </div>

                    <div class="title_box">Novedades</div>  
                    <div class="border_box">
                        <div class="product_title"><a href="webactions/productdetails.jsp">Motorola 156 MX-VL</a></div>
                        <div class="product_img"><a href="webactions/productdetails.jsp">
                                <img src="images/p2.gif" alt="" title="" border="0" /></a></div>
                        <div class="prod_price"><span class="reduce">350$</span> 
                            <span class="price">270$</span></div>
                    </div>  

                    <div class="title_box">Marcas</div>

                    <ul class="left_menu">
                        <li class="odd"><a href="errors2/error501.html">Sony</a></li>
                        <li class="even"><a href="errors2/error501.html">Samsung</a></li>
                        <li class="odd"><a href="errors2/error501.html">Daewoo</a></li>
                        <li class="even"><a href="errors2/error501.html">LG</a></li>
                        <li class="odd"><a href="errors2/error501.html">Fujitsu Siemens</a></li>
                        <li class="even"><a href="errors2/error501.html">Motorola</a></li>
                        <li class="odd"><a href="errors2/error501.html">Phillips</a></li>
                    </ul>      

                    <div class="banner_adds">
                        <a href="#"><img src="images/banner.jpg" alt="" title="" border="0" /></a>
                    </div>        

                </div><!-- end of right content -->   

            </div><!-- end of main content -->

            <div class="footer">

                <div class="left_footer">
                    <img src="images/footer_logo.png" alt="" title="" width="170" height="49"/>
                </div>

                <div class="center_footer">Manuel Conde &#169 2012<br/>
                    <a href="http://twitter.com/#!/mconde17" title="twitter">
                        <img src="images/twitter.jpg" alt="twitter" title="twitter" border="0" /></a><br />
                    <img src="images/payment.gif" alt="" title="" />
                </div>

                <div class="right_footer">
                    <a href="index.jsp">Inicio</a>
                    <a href="webactions/aboutus.jsp">Sobre Nosotros</a>
                    <a href="webactions/contactus.jsp">Contacta</a>
                    <a href="index.jsp">Admin</a>
                </div>   

            </div> 
        </div>
        <!-- end of main_container -->
    </body>
</html>