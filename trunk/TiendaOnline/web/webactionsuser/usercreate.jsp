<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Electronix Store</title>
        <link rel="stylesheet" type="text/css" href="/TiendaOnline/css/style.css" />
        <script type="text/javascript" src="/TiendaOnline/javascripts/boxOver.js"></script>
        <script type="text/javascript" src="/TiendaOnline/javascripts/jquery-1.7.2.js"></script>
        <script type="text/javascript" src="/TiendaOnline/javascripts/jquery.validate.js"></script>
        <script type="text/javascript" src="/TiendaOnline/javascripts/additional-methods.js"></script>
        <script type="text/javascript" charset="UTF-8">
            
        </script>
    </head>
    <body>

        <div id="main_container">

            <%@include file="/WEB-INF/view/headerpage.jsp" %>

            <div id="main_content"> 

                <%@include file="/WEB-INF/view/titlepage.jsp" %>

                <div class="crumb_navigation">
                    Navegación: <span class="current">Nuevo Usuario</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">
                    <div class="center_title_bar">Créate una cuenta:</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            

                            <div class="contact_form">
                                <form action="/TiendaOnline/FrontController">
                                    <input name="form" type="hidden" value="createServlet"></input>
                                    <input name="type" type="hidden" value="user"></input>                           
                                    <div class="form_row">
                                        <label class="contact"><strong>Nombre:</strong></label>
                                        <input name="userName" type="text" class="contact_input" />
                                    </div>  

                                    <div class="form_row">
                                        <label class="contact"><strong>Apellidos:</strong></label>
                                        <input name="userSurnames" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <label class="contact"><strong>Dirección:</strong></label>
                                        <input name="userAdress" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <label class="contact"><strong>Email:</strong></label>
                                        <input name="userEmail" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <label class="contact"><strong>Contraseña:</strong></label>
                                        <input name="userPassword" type="password" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <label class="contact"><strong>Repite Contraseña:</strong></label>
                                        <input type="password" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <button>¡¡¡Crear Usuario!!!</button>
                                    </div>      
                                </form>
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
