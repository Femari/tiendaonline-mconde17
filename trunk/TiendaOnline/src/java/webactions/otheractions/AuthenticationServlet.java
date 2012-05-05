package webactions.otheractions;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import persistence.PersistenceDAO;
import persistence.UserDAO;
import webactions.MyCoolServlet;

public class AuthenticationServlet extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserDAO persistenceManagerUser = PersistenceDAO.getUserDAO(persistenceMechanism);
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPass = request.getParameter("userPassword");
        String type = request.getParameter("type");
        User user = persistenceManagerUser.getUser(userEmail);
        HttpSession session = request.getSession();
        switch (type) {
            case "user":
                if (persistenceManagerUser.userAuthentication(userEmail, userPass)) {
                    session.setAttribute("authentication", true);
                    session.setAttribute("user", user);
                    session.setAttribute("admin", false);
                    goToURL(successForm, request, response);
                } else {
                    session.setAttribute("authentication", false);
                    goToURL(errorForm, request, response);
                }
                break;
            case "admin":
                String userAdmin = "electronixstoreadmin";
                String userAdminPass = "electronixstorelpi";
                if (userName.equals(userAdmin) && userPass.equals(userAdminPass)) {
                    session.setAttribute("authentication", true);
                    session.setAttribute("admin", true);
                    goToURL(successForm, request, response);
                } else {
                    session.setAttribute("authentication", false);
                    goToURL(errorForm, request, response);
                }
                break;
        }
    }
}
