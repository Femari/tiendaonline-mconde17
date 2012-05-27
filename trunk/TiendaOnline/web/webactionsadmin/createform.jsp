<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Electronix Store</title>
        <link href="/TiendaOnline/images/favicon.ico" type="image/x-icon" rel="shortcut icon" />
        <link rel="stylesheet" type="text/css" href="/TiendaOnline/css/style.css" />
        <script type="text/javascript" src="/TiendaOnline/javascripts/boxOver.js"></script>
        <script type="text/javascript" charset="UTF-8">
            $(document).ready(function(){
                
                $('form.createproduct').validate({
                    rules: {
                        productShortDescription: {
                            required: true
                        },
                        productPrice: {
                            required: true,
                            number: true,
                            minlength: 1
                        },
                        productStock: {
                            required: true,
                            number: true,
                            minlength: 1
                        },
                        productLongDescription: {
                            required: true
                        },
                        productImageURL: {
                            required: true
                        }
                    },
                    messages: {
                        productShortDescription: {
                            required: "Es necesario un nombre para el producto"
                        },
                        productPrice: {
                            required: "El producto debe tener un precio",
                            number: "El precio no puede contener letras, sólo números",
                            minlength: "Al menos debe tener 1 número"
                        },
                        productStock: {
                            required: "El producto debe tener un stock",
                            number: "El stock no puede contener letras, sólo números",
                            minlength: "Al menos debe tener 1 número"
                        },
                        productLongDescription: {
                            required: "La descripción del producto es obligatoria"
                        },
                        productImageURL: {
                            required: "El producto debe tener una imagen. Si no existe pon: imagenotavailable.jpg"
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
                    Navegación: <span class="current">Añadir Producto (Admin)</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">
                    <div class="center_title_bar">Añadir un Producto:</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            
                            <div class="contact_form">
                                <form action="/TiendaOnline/FrontController" method="post" class="createproduct">
                                    <input name="form" type="hidden" value="createServlet"></input>
                                    <input name="type" type="hidden" value="product"></input>  
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
                                        <label class="contact"><strong>Descripción:</strong></label>
                                        <input name="productLongDescription" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <label class="contact"><strong>URL de la Imagen:</strong></label>
                                        <input name="productImageURL" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <button>Crear Producto</button>
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