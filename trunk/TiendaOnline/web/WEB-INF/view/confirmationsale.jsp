<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<!-- Formulario de Compra para usuarios regitrados o que ya han introducido sus datos anteriormente -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Electronix Store</title>
        <link href="/TiendaOnline/images/favicon.ico" type="image/x-icon" rel="shortcut icon" />
        <link rel="stylesheet" type="text/css" href="/TiendaOnline/css/style.css" />
        <script type="text/javascript" src="/TiendaOnline/javascripts/boxOver.js"></script>
        <script type="text/javascript" src="/TiendaOnline/javascripts/jquery-1.7.2.js"></script>
        <script type="text/javascript" src="/TiendaOnline/javascripts/jquery.validate.js"></script>
        <script type="text/javascript" src="/TiendaOnline/javascripts/additional-methods.js"></script>
        <script type="text/javascript" charset="UTF-8">
            $(document).ready(function(){
                $('form.confirmationSale').validate({
                    rules: {
                        saleAdress: {
                            required: false
                        },
                        salePaymentMethod: {
                            required: true
                        }
                    },
                    messages: {
                        salePaymentMethod: {
                            required:"El método de Pago es obligatorio"
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
                    Navegación: <span class="current">Finalizar Compra</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">
                    <div class="center_title_bar">Finalizar la compra</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">
                            <% Boolean authentication = (Boolean) session.getAttribute("authentication");%>
                            <% Boolean admin = (Boolean) session.getAttribute("admin");%>
                            <%if (admin != null && admin) {%>
                            <br>Eres administrador... No puedes comprar<br>
                            <a href="/TiendaOnline/webactionsadmin/admin.jsp">Acceso al menú de Administración</a>
                            <%} else if (authentication != null && authentication) {%>
                            <% User user = (User) session.getAttribute("user");%>
                            <center>
                                <br> Hola <strong><%= user.getUserName() + " " + user.getUserSurnames()%></strong>, 
                                Para finalizar la compra rellena los siguientes datos:<br>
                                <div class="contact_form">
                                    <form action="/TiendaOnline/FrontController" method="post" class="confirmationSale">
                                        <input name="form" type="hidden" value="saleServlet"></input>
                                        <div class="form_row">
                                            <label class="contact"><strong>Dirección de Envío*:</strong></label>
                                            <input name="saleAdress" type="text" class="contact_input" />
                                        </div>
                                        <br>*Si no introduces Dirección de Envío se usará la que introducistes cuando te registrastes<br>
                                        <li class="currencies">Forma de Pago**:
                                            <select name="salePaymentMethod">
                                                <option value="Tarjeta">Tarjeta</option>
                                                <option value="Transferencia Bancaria">Transferencia Bancaria</option>
                                                <option value="Contrareembolso">Contrareembolso</option>
                                            </select>
                                        </li>
                                        <button>¡¡¡Comprar!!!</button>
                                    </form>
                                </div> 
                            </center>
                            **Campo obligatorio
                            <%} else {%>
                            <br> Necesitas una cuenta para poder realizar la comprar...<br>
                            <br><a href="/TiendaOnline/webactionsuser/usercreate.jsp">Pulsa aquí para crearla</a>
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