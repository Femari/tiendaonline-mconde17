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
	
                $('form.readProduct').validate({
                    rules: {
                        parameter: {
                            required: true
                        },
                        condition: {
                            required: true
                        }
                    },
                    messages: {
                        parameter: {
                            required: "Es necesario un nombre para el producto"
                        },
                        condition: {
                            required: "El producto debe tener un precio"
                        }
                    }
                });
            });
        </script>
        <script type="text/javascript" charset="UTF-8">
            $(document).ready(function(){
	
                $('form.readSale').validate({
                    rules: {
                        parameter: {
                            required: true
                        },
                        condition: {
                            required: true
                        }
                    },
                    messages: {
                        productShortDescription: {
                            required: "Es necesario un nombre para el producto"
                        },
                        productPrice: {
                            required: "El producto debe tener un precio"
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
                    Navegación: <span class="current">Buscar Producto (Admin)</span>
                </div>        

                <%@include file="/WEB-INF/view/leftpage.jsp" %>

                <div class="center_content">
                    <div class="center_title_bar">Buscar Producto:</div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            

                            <div class="contact_form">
                                <form action="/TiendaOnline/FrontController" method="post" class="readProduct">
                                    <input name="form" type="hidden" value="readServlet"></input>
                                    <input name="type" type="hidden" value="product"></input>  

                                    <div class="form_row">
                                        <li class="currencies">Campo a Buscar:
                                            <select name="parameter">
                                                <option value="productID">ID</option>
                                                <option value="productPrice">Precio</option>
                                                <option value="productShortDescription">Descripción Corta</option>
                                                <option value="productLongDescription">Descripción Larga</option>
                                                <option value="productStock">Stock</option>
                                            </select>
                                        </li>
                                    </div>

                                    <div class="form_row">
                                        <label class="contact"><strong>Contenido:</strong></label>
                                        <input name="condition" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <button>¡¡¡Buscar!!!</button>
                                    </div>      
                                </form>
                            </div> 

                        </div>
                        <div class="bottom_prod_box_big"></div>                                
                    </div>

                    <div class="prod_box_big">
                        <div class="top_prod_box_big"></div>
                        <div class="center_prod_box_big">            

                            <div class="contact_form">
                                <form action="/TiendaOnline/FrontController" method="post" class="readSale">
                                    <input name="form" type="hidden" value="readServlet"></input>
                                    <input name="type" type="hidden" value="sale"></input>  

                                    <div class="form_row">
                                        <li class="currencies">Campo a Buscar:
                                            <select name="parameter">
                                                <option value="saleID">ID</option>
                                                <option value="salePaymentMethod">Método de Pago</option>
                                                <option value="saleAdress">Dirección de Destino</option>
                                                <option value="saleDate">Fecha</option>
                                                <option value="saleClient">Email del Cliente</option>
                                            </select>
                                        </li>
                                    </div>

                                    <div class="form_row">
                                        <label class="contact"><strong>Contenido:</strong></label>
                                        <input name="condition" type="text" class="contact_input" />
                                    </div>

                                    <div class="form_row">
                                        <button>¡¡¡Buscar!!!</button>
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