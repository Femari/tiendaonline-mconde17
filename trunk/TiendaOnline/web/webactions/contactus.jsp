<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	
                $('form.contactUs').validate({
                    rules: {
                        contactUsName: {
                            required: true
                        },
                        contactUsEmail: {
                            required: true
                        },
                        contactUsTitle: {
                            required: true
                        },
                        contactUsMessage: {
                            required: true
                        }
                    },
                    messages: {
                        contactUsName: {
                            required: "Necesitamos su nombre para darle una respuesta"
                        },
                        contactUsEmail: {
                            required: "Necesitamos una forma de comunicarnos con usted"
                        },
                        contactUsTitle: {
                            required: "El título o asunto sobre el contacto es obligatorio"
                        },
                        contactUsMessage: {
                            required: "Sin mensaje no hacemos nada..."
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
                    Navegación: <span class="current">Contacto</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">
                    <div class="center_title_bar">Contacta con Nosotros:</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            

                            <div class="contact_form">
                                <form action="/TiendaOnline/FrontController" method="post" class="contactUs">
                                    <input name="form" type="hidden" value="errorForm"></input> 
                                    <div class="form_row">
                                        <label class="contact"><strong>Nombre*:</strong></label>
                                        <input name="contactUsName" type="text" class="contact_input" />
                                    </div>  

                                    <div class="form_row">
                                        <label class="contact"><strong>Email*:</strong></label>
                                        <input name="contactUsEmail" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <label class="contact"><strong>Título*:</strong></label>
                                        <input name ="contactUsTitle" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <label class="contact"><strong>Mensaje*:</strong></label>
                                        <textarea name="contactUsMessage" class="contact_textarea" ></textarea>
                                    </div>

                                    <div class="form_row">
                                        <button><strong>Enviar</strong></button>
                                    </div>      
                                </form>
                            </div> 
                            *Campos Obligatorios
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