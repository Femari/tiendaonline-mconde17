<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    Navegación: <span class="current">Administrador</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">
                    <div class="center_title_bar">Acciones de Administrador</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            

                            <div class="contact_form">
                                <br><a href="/TiendaOnline/webactionsadmin/createform.jsp">Añadir Producto</a>   
                                <br><a href="/TiendaOnline/webactionsadmin/deleteform.jsp">Borrar Producto</a>
                                <br><a href="/TiendaOnline/webactionsadmin/updateform.jsp">Modificar Producto</a>
                                <br><a href="/TiendaOnline/webactionsadmin/readform.jsp">Buscar Producto</a>
                                <br><br><a href="/TiendaOnline/webactionsadmin/readform.jsp">Buscar Venta</a>
                                <br><a href="/TiendaOnline/FrontController?form=readServlet&parameter=all">Mostrar todas las ventas</a>
                            </div> 

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