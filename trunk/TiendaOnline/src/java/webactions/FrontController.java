package webactions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE,
                    "No se pudo establecer el encoding", ex);
        }
        String form = request.getParameter("form");
        if (form == null || (persistenceMechanism != null && persistenceMechanism.equals("none"))) {
            goToURL(errorForm, request, response);
        } else {
            switch (form) {
                case "displayForm":
                    goToNamedResource(displayForm, request, response);
                    break;
                case "errorForm":
                    goToNamedResource(errorForm, request, response);
                    break;
                case "sucessForm":
                    goToNamedResource(successForm, request, response);
                    break;
                case "authenticationServlet":
                    goToNamedResource(authenticationServlet, request, response);
                    break;
                case "addToShoppingCartServlet":
                    goToNamedResource(addToShoppingCartServlet, request, response);
                    break;
                case "sendEmailServlet":
                    goToNamedResource(sendEmailServlet, request, response);
                    break;
                case "createServlet":
                    goToNamedResource(createServlet, request, response);
                    break;
                case "deleteServlet":
                    goToNamedResource(deleteServlet, request, response);
                    break;
                case "readServlet":
                    goToNamedResource(readServlet, request, response);
                    break;
                case "updateServlet":
                    goToNamedResource(updateServlet, request, response);
                    break;
                case "saleServlet":
                    goToNamedResource(saleServlet, request, response);
                    break;
                default:
                    Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE,
                            "No se pudo establecer el encoding");
                    goToURL(errorForm, request, response);
                    break;
            }
        }
    }
}
