<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="shoppingCart" class="model.ShoppingCart" scope="session"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <div class="right_content">
            <div class="shopping_cart">
                <div class="cart_title">Carrito de la Compra</div>

                <div class="cart_details">
                <%= shoppingCart.getNumberOfProducts()%> Productos<br />
                <span class="border_cart"></span>
                Total: <span class="price"> 
                    <%= shoppingCart.getPriceOfShoppingCart()%> €
                </span>
            </div>

            <div class="cart_icon"><a href="#" title="header=[Visualizar] body=[&nbsp;] fade=[on]">
                    <img src="/TiendaOnline/images/shoppingcart.png" alt="" title="" width="48" height="48" border="0" /></a></div>

        </div>

        <div class="title_box">Novedades</div>  
        <div class="border_box">
            <div class="product_title"><a href="/TiendaOnline/webactions/productdetails.jsp">Motorola 156 MX-VL</a></div>
            <div class="product_img"><a href="/TiendaOnline/webactions/productdetails.jsp">
                    <img src="/TiendaOnline/images/p2.gif" alt="" title="" border="0" /></a></div>
            <div class="prod_price"><span class="reduce">350$</span> 
                <span class="price">270$</span></div>
        </div>  

        <div class="title_box">Marcas</div>

        <ul class="left_menu">
            <li class="odd"><a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">Sony</a></li>
            <li class="even"><a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">Samsung</a></li>
            <li class="odd"><a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">Daewoo</a></li>
            <li class="even"><a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">LG</a></li>
            <li class="odd"><a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">Fujitsu Siemens</a></li>
            <li class="even"><a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">Motorola</a></li>
            <li class="odd"><a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">Phillips</a></li>
        </ul>      

        <div class="banner_adds">
            <a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp"><img src="/TiendaOnline/images/banner.jpg" alt="" title="" border="0" /></a>
        </div>        

    </div><!-- end of right content -->   
</html>
