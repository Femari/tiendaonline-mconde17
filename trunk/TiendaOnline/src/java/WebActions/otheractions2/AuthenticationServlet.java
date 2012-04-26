package webactions.otheractions2;

import model2.User;
import persistence2.PersistenceDAO;
import persistence2.UserDAO;
import webactions2.AbstractServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationServlet extends AbstractServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        UserDAO persistenceManagerUser = PersistenceDAO.getUserDAO(mechanismOfPersistence);
        String userEmail = request.getParameter("userEmail");
        String userPass = request.getParameter("userPassword");
        String type = request.getParameter("type");
        User user = persistenceManagerUser.getUser(userEmail);
        HttpSession session = request.getSession();
        if (type.equals("user")) {
            if (persistenceManagerUser.userAuthentication(userEmail, userPass).equals("true")) {
                session.setAttribute("authentication", true);
                session.setAttribute("user", user);
                session.setAttribute("admin", user.getUserPrivileged());
                goToURL(successPage, request, response);
            } else {
                session.setAttribute("authentication", false);
                goToURL(errorForm, request, response);
            }
        }
    }
}
