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
            $(document).ready(function(){
	
                $('form.adminlogin').validate({
                    rules: {
                        userName: {
                            required: true
                        },
                        userPassword: {
                            required: true
                        }
                    },
                    messages: {
                        userName: {
                            required:"Tu nombre es obligatorio..."
                        },
                        userPassword: {
                            required: "La contraseña es obligatoria..."
                        }
                    }
                });
            });
        </script>
    </head>
    <body>

        <div id="main_container">

            <%@include file="/WEB-INF/view/headerpage.jsp" %>

            <div id="main_content"> 

                <%@include file="/WEB-INF/view/titlepage.jsp" %>

                <div class="crumb_navigation">
                    Navegación: <span class="current">Admin Login</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">
                    <div class="center_title_bar">Acceso a Administrador:</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            
                            <% Boolean admin = (Boolean) session.getAttribute("admin");%>
                            <% Boolean authentication = (Boolean) session.getAttribute("authentication");%>
                            <% if (admin != null && admin) {%>
                            <br>Ir al menú de administración<br>
                            <a href="/TiendaOnline/webactionsadmin/admin.jsp">Acceso al menú</a>
                            <%} else if (authentication != null && authentication) {%>
                            <br>Ya te has registrado y no eres administrador<br>
                            <a href="/TiendaOnline/index.jsp">Vuelve a la página principal</a>
                            <%} else {%>
                            <div class="contact_form">
                                <form action="/TiendaOnline/FrontController" method="post" class="adminlogin">
                                    <input name="form" type="hidden" value="authenticationServlet"></input>
                                    <input name="type" type="hidden" value="admin"></input>   
                                    <div class="form_row">
                                        <label class="contact"><strong>Usuario:</strong></label>
                                        <input name="userName" type="text" class="contact_input" />
                                    </div>  

                                    <div class="form_row">
                                        <label class="contact"><strong>Contraseña:</strong></label>
                                        <input name="userPassword" type="password" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <button>Acceder</button>
                                    </div>      
                                </form>
                            </div> 
                            <%}
                            %>

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
