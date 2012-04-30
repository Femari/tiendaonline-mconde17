<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Electronix Store</title>
        <link rel="stylesheet" type="text/css" href="/TiendaOnline/css/style.css" />
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
        <script type="text/javascript" src="/TiendaOnline/javascripts/boxOver.js"></script>
    </head>
    <body>

        <div id="main_container">

            <%@include file="/WEB-INF/view/headerpage.jsp" %>

            <div id="main_content"> 

                <%@include file="/WEB-INF/view/titlepage.jsp" %>

                <div class="crumb_navigation">
                    Navegación: <span class="current">NombreDelProducto</span>
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

                    <div class="center_title_bar">Productos Similares</div>

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