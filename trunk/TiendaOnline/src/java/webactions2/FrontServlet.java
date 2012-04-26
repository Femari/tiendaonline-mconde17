package webactions2;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontServlet extends AbstractServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE,
                    "No se pudo establecer el encoding", ex);
        }
        String form = request.getParameter("form");
        if (form == null || (mechanismOfPersistence != null && mechanismOfPersistence.equals("none"))) {
            goToURL(errorForm, request, response);
        } else {
            switch (form) {
                case "principalPage":
                    goToNamedResource("principalPage", request, response);
                    break;
                case "errorPage":
                    goToNamedResource("errorPage", request, response);
                    break;
                case "sucessPage":
                    goToNamedResource("sucessPage", request, response);
                    break;
                case "authenticationServlet":
                    goToNamedResource("authenticationServlet", request, response);
                    break;
                case "addToShoppingCartServlet":
                    goToNamedResource("addToShoppingCartServlet", request, response);
                    break;
                case "sendEmailServlet":
                    goToNamedResource("sendEmailServlet", request, response);
                    break;
                case "createServlet":
                    goToNamedResource("createServlet", request, response);
                    break;
                case "deleteServlet":
                    goToNamedResource("deleteServlet", request, response);
                    break;
                case "readServlet":
                    goToNamedResource("readServlet", request, response);
                    break;
                case "updateServlet":
                    goToNamedResource("principalPage", request, response);
                    break;
                case "saleServlet":
                    goToNamedResource("saleServlet", request, response);
                    break;
                default:
                    goToURL(errorForm, request, response);
                    break;
            }
        }
    }
}
