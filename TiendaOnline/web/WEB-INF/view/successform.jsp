<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ShoppingCart" %>
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
                    Navegación: <span class="current">Principal</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>
                <div class="center_content">
                    <div class="center_title_bar">Operación Realizada con Éxito</div>
                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big"> 
                            <% Boolean admin = (Boolean) session.getAttribute("admin");%>
                            <% if (admin!= null && admin) {%>
                            <br>Ir al menú de administración<br>
                            <a href="/TiendaOnline/webactionsadmin/admin.jsp">Acceso al menú</a>
                            <%} else {%>
                            <br>La operación realizada ha concluido con éxito<br>
                            <br>
                            <br>Puede continuar comprando y visitando nuestra web<br>
                            <%}%>
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