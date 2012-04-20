package WebActions;

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
            goToRequestDispatcher(request, response, errorPage, false);
        } else {
            switch (form) {
                case "principalPage":
                    goToRequestDispatcher(request, response, principalPage, true);
                    break;
                case "errorPage":
                    goToRequestDispatcher(request, response, errorPage, true);
                    break;
                case "sucessPage":
                    goToRequestDispatcher(request, response, sucessPage, true);
                    break;
                case "authenticationServlet":
                    goToRequestDispatcher(request, response, authenticationServlet, true);
                    break;
                case "addToShoppingCartServlet":
                    goToRequestDispatcher(request, response, addToShoppingCartServlet, true);
                    break;
                case "sendEmailServlet":
                    goToRequestDispatcher(request, response, sendEmailServlet, true);
                    break;
                case "createServlet":
                    goToRequestDispatcher(request, response, createServlet, true);
                    break;
                case "deleteServlet":
                    goToRequestDispatcher(request, response, deleteServlet, true);
                    break;
                case "readServlet":
                    goToRequestDispatcher(request, response, readServlet, true);
                    break;
                case "updateServlet":
                    goToRequestDispatcher(request, response, updateServlet, true);
                    break;
                case "saleServlet":
                    goToRequestDispatcher(request, response, saleServlet, true);
                    break;
                default:
                    goToRequestDispatcher(request, response, errorPage, false);
                    break;
            }
        }
    }
}
