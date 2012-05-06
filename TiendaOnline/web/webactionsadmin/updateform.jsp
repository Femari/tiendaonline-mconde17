<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Electronix Store</title>
        <link rel="stylesheet" type="text/css" href="/TiendaOnline/css/style.css" />
        <script type="text/javascript" src="/TiendaOnline/javascripts/boxOver.js"></script>
    </head>
    <body>

        <div id="main_container">

            <%@include file="/WEB-INF/view/headerpage.jsp" %>

            <div id="main_content"> 

                <%@include file="/WEB-INF/view/titlepage.jsp" %>

                <div class="crumb_navigation">
                    Navegación: <span class="current">Actualizar Producto (Admin)</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">
                    <div class="center_title_bar">Actualizar Producto:</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            

                            <div class="contact_form">
                                <form action="/TiendaOnline/FrontController" method="post" class="updateProduct">
                                    <input name="form" type="hidden" value="updateServlet"></input>
                                    <input name="type" type="hidden" value="product"></input>
                                    
                                    <div class="form_row">
                                        <label class="contact"><strong>ID:</strong></label>
                                        <input name="oldProductID" type="text" class="contact_input" />
                                    </div>
                                    
                                    <div class="form_row">
                                        <label class="contact"><strong>Nombre:</strong></label>
                                        <input name="productShortDescription" type="text" class="contact_input" />
                                    </div>
                                    
                                    <div class="form_row">
                                        <label class="contact"><strong>Precio:</strong></label>
                                        <input name="productPrice" type="text" class="contact_input" />
                                    </div>
                                    
                                    <div class="form_row">
                                        <label class="contact"><strong>Stock:</strong></label>
                                        <input name="productStock" type="text" class="contact_input" />
                                    </div>
                                    
                                    <div class="form_row">
                                        <label class="contact"><strong>Descripción Larga:</strong></label>
                                        <input name="productLongDescription" type="text" class="contact_input" />
                                    </div>
                                    
                                    <div class="form_row">
                                        <label class="contact"><strong>URL de la Imagen:</strong></label>
                                        <input name="productImageURL" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <button>Actualizar</button>
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