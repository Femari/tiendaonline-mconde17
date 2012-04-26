<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Electronix Store</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
        <script>
            PositionX = 100;
            PositionY = 100;


            defaultWidth  = 500;
            defaultHeight = 500;
            var AutoClose = true;

            if (parseInt(navigator.appVersion.charAt(0))>=4){
                var isNN=(navigator.appName=="Netscape")?1:0;
                var isIE=(navigator.appName.indexOf("Microsoft")!=-1)?1:0;}
            var optNN='scrollbars=no,width='+defaultWidth+',height='+defaultHeight+',left='+PositionX+',top='+PositionY;
            var optIE='scrollbars=no,width=150,height=100,left='+PositionX+',top='+PositionY;
            function popImage(imageURL,imageTitle){
                if (isNN){imgWin=window.open('about:blank','',optNN);}
                if (isIE){imgWin=window.open('about:blank','',optIE);}
                with (imgWin.document){
                    writeln('<html><head><title>Loading...</title><style>body{margin:0px;}</style>');writeln('<sc'+'ript>');
                    writeln('var isNN,isIE;');writeln('if (parseInt(navigator.appVersion.charAt(0))>=4){');
                    writeln('isNN=(navigator.appName=="Netscape")?1:0;');writeln('isIE=(navigator.appName.indexOf("Microsoft")!=-1)?1:0;}');
                    writeln('function reSizeToImage(){');writeln('if (isIE){');writeln('window.resizeTo(300,300);');
                    writeln('width=300-(document.body.clientWidth-document.../Images[0].width);');
                    writeln('height=300-(document.body.clientHeight-document.../Images[0].height);');
                    writeln('window.resizeTo(width,height);}');writeln('if (isNN){');       
                    writeln('window.innerWidth=document.../Images["George"].width;');writeln('window.innerHeight=document.../Images["George"].height;}}');
                    writeln('function doTitle(){document.title="'+imageTitle+'";}');writeln('</sc'+'ript>');
                    if (!AutoClose) writeln('</head><body bgcolor=ffffff scroll="no" onload="reSizeToImage();doTitle();self.focus()">')
                    else writeln('</head><body bgcolor=ffffff scroll="no" onload="reSizeToImage();doTitle();self.focus()" onblur="self.close()">');
                    writeln('<img name="George" src='+imageURL+' style="display:block"></body></html>');
                    close();		
                }}

        </script>
        <script type="text/javascript" src="../javascripts/boxOver.js"></script>
    </head>
    <body>

        <div id="main_container">
            <div class="top_bar">
                <div class="top_search">
                    <div class="search_text"><a href="#">Búsqueda Avanzada</a></div>
                    <input type="text" class="search_input" name="search" />
                    <input type="image" src="../images/search.gif" class="search_bt"/>
                </div>

                <div class="languages">
                    <div class="lang_text">Idiomas:</div>
                    <a href="#" class="lang"><img src="../images/es.gif" alt="" title="" border="0" /></a>      
                </div>

            </div>
            <div id="header">

                <div id="logo">
                    <a href="../index.jsp"><img src="../images/logo.png" alt="" title="" 
                                                border="0" width="237" height="140" /></a>
                </div>

                <div class="oferte_content">
                    <div class="top_divider"><img src="../images/header_divider.png" 
                                                  alt="" title="" width="1" height="164" /></div>
                    <div class="oferta">

                        <div class="oferta_content">
                            <img src="../images/laptop.png" width="94" height="92" border="0" class="oferta_img" />

                            <div class="oferta_details">
                                <div class="oferta_title">Ordenador en Oferta</div>
                                <div class="oferta_text">
                                    Esto parece que de momento funciona de forma decente xD
                                </div>
                                <a href="webactions/productDetails.jsp" class="details">Detalles</a>
                            </div>
                        </div>
                        <div class="oferta_pagination">

                            <span class="current">1</span>
                            <a href="../errors/error501.html">2</a>
                            <a href="../errors/error501.html">3</a>
                            <a href="../errors/error501.html">4</a>
                            <a href="../errors/error501.html">5</a>  

                        </div>        

                    </div>
                    <div class="top_divider"><img src="../images/header_divider.png" 
                                                  alt="" title="" width="1" height="164" /></div>
                </div> <!-- end of oferte_content-->

            </div>

            <div id="main_content"> 

                <div id="menu_tab">
                    <div class="left_menu_corner"></div>
                    <ul class="menu">
                        <li><a href="../index.jsp" class="nav1">Inicio</a></li>
                        <li class="divider"></li>
                        <li><a href="../errors/error501.html" class="nav2">Productos</a></li>
                        <li class="divider"></li>
                        <li><a href="../errors/error501.html" class="nav3">Especiales</a></li>
                        <li class="divider"></li>
                        <li><a href="../errors/error501.html" class="nav4">Mi Cuenta</a></li>
                        <li class="divider"></li>
                        <li><a href="../errors/error501.html" class="nav4">Registrar</a></li>
                        <li class="divider"></li>                         
                        <li><a href="../errors/error501.html" class="nav5">Envío</a></li>
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
                        <li class="odd"><a href="../errors/error501.html">Procesadores</a></li>
                        <li class="even"><a href="../errors/error501.html">Placas Base</a></li>
                        <li class="odd"><a href="../errors/error501.html">Sobremesa</a></li>
                        <li class="even"><a href="../errors/error501.html">Portátiles</a></li>
                    </ul> 

                    <div class="title_box">Productos Especiales</div>  
                    <div class="border_box">
                        <div class="product_title"><a href="webactions/productdetails.jsp">
                                Motorola 156 MX-VL</a></div>
                        <div class="product_img"><a href="webactions/productdetails.jsp">
                                <img src="../images/laptop.png" alt="" title="" border="0" /></a></div>
                        <div class="prod_price"><span class="reduce">350$</span> 
                            <span class="price">270$</span></div>
                    </div>  

                    <div class="title_box">Noticias</div>  
                    <div class="border_box">
                        <input type="text" name="Noticias" class="newsletter_input" value="Introduce tu e-mail"/>
                        <a href="#" class="join">Únete</a>
                    </div>  

                    <div class="banner_adds">

                        <a href="#"><img src="../images/banner.jpg" alt="" title="" border="0" /></a>
                    </div>    

                </div><!-- end of left content -->

                <div class="center_content">
                    <div class="center_title_bar">Motorola 156 MX-VL</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            

                            <div class="product_img_big">
                                <a href="javascript:popImage('../images/big_pic.jpg','Some Title')" title="header=[Zoom] body=[&nbsp;] fade=[on]"><img src="../images/laptop.gif" alt="" title="" border="0" /></a>
                                <div class="thumbs">
                                    <a href="#" title="header=[Thumb1] body=[&nbsp;] fade=[on]"><img src="../images/thumb1.gif" alt="" title="" border="0" /></a>
                                    <a href="#" title="header=[Thumb2] body=[&nbsp;] fade=[on]"><img src="../images/thumb1.gif" alt="" title="" border="0" /></a>
                                    <a href="#" title="header=[Thumb3] body=[&nbsp;] fade=[on]"><img src="../images/thumb1.gif" alt="" title="" border="0" /></a>
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

                    <div class="center_title_bar">Productos Similares</div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Motorola 156 MX-VL</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="../images/laptop.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span>
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="../images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="../errors/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="../images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="../errors/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="../images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>            
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productDetails.jsp">Iphone Apple</a></div>
                            <div class="product_img"><a href="webactions/productDetails.jsp">
                                    <img src="../images/p4.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="../images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="../errors/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="../images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="../errors/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="../images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productdetails.jsp" class="prod_details">Detalles</a>             
                        </div>                     
                    </div>

                    <div class="prod_box">
                        <div class="top_prod_box"></div>
                        <div class="center_prod_box">            
                            <div class="product_title"><a href="webactions/productdetails.jsp">Samsung Webcam</a></div>
                            <div class="product_img"><a href="webactions/productdetails.jsp">
                                    <img src="../images/p5.gif" alt="" title="" border="0" /></a></div>
                            <div class="prod_price"><span class="reduce">350$</span> 
                                <span class="price">270$</span></div>                        
                        </div>
                        <div class="bottom_prod_box"></div>             
                        <div class="prod_details_tab">
                            <a href="#" title="header=[Añadir al Carrito] body=[&nbsp;] fade=[on]">
                                <img src="../images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="../errors/error501.html" title="header=[Especiales] body=[&nbsp;] fade=[on]">
                                <img src="../images/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                            <a href="../errors/error501.html" title="header=[Premios] body=[&nbsp;] fade=[on]">
                                <img src="../images/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>           
                            <a href="webactions/productDetails.jsp" class="prod_details">Detalles</a>            
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
                                <img src="../images/shoppingcart.png" alt="" title="" width="48" height="48" border="0" /></a></div>

                    </div>

                    <div class="title_box">Novedades</div>  
                    <div class="border_box">
                        <div class="product_title"><a href="webactions/productdetails.jsp">Motorola 156 MX-VL</a></div>
                        <div class="product_img"><a href="webactions/productdetails.jsp">
                                <img src="../images/p2.gif" alt="" title="" border="0" /></a></div>
                        <div class="prod_price"><span class="reduce">350$</span> 
                            <span class="price">270$</span></div>
                    </div>  

                    <div class="title_box">Marcas</div>

                    <ul class="left_menu">
                        <li class="odd"><a href="../errors/error501.html">Sony</a></li>
                        <li class="even"><a href="../errors/error501.html">Samsung</a></li>
                        <li class="odd"><a href="../errors/error501.html">Daewoo</a></li>
                        <li class="even"><a href="../errors/error501.html">LG</a></li>
                        <li class="odd"><a href="../errors/error501.html">Fujitsu Siemens</a></li>
                        <li class="even"><a href="../errors/error501.html">Motorola</a></li>
                        <li class="odd"><a href="../errors/error501.html">Phillips</a></li>
                    </ul>      

                    <div class="banner_adds">
                        <a href="#"><img src="../images/banner.jpg" alt="" title="" border="0" /></a>
                    </div>        

                </div><!-- end of right content -->   

            </div><!-- end of main content -->

            <div class="footer">

                <div class="left_footer">
                    <img src="../images/footer_logo.png" alt="" title="" width="170" height="49"/>
                </div>

                <div class="center_footer">Manuel Conde &#169 2012<br/>
                    <a href="http://twitter.com/#!/mconde17" title="twitter">
                        <img src="../images/twitter.jpg" alt="twitter" title="twitter" border="0" /></a><br />
                    <img src="../images/payment.gif" alt="" title="" />
                </div>

                <div class="right_footer">
                    <a href="../index.jsp">Inicio</a>
                    <a href="webactions/aboutus.jsp">Sobre Nosotros</a>
                    <a href="webactions/contactus.jsp">Contacta</a>
                    <a href="../index.jsp">Admin</a>
                </div>   

            </div>               

        </div>
        <!-- end of main_container -->
    </body>
</html>