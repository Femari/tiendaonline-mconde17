package WebActions;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractServlet extends HttpServlet {

    protected String implementationType = null;
    protected String principalPage = null;
    protected String errorPage = null;
    protected String sucessPage = null;
    protected String authenticationServlet = null;
    protected String sendEmailServlet = null;
    protected String createServlet = null;
    protected String deleteServlet = null;
    protected String readServlet = null;
    protected String updateServlet = null;
    
    protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response);

    protected void processRequestDispatcher(HttpServletRequest request, HttpServletResponse response,
            String servletDestiny, boolean isRequest) {
        RequestDispatcher dispatcher;
        if (isRequest) {
            dispatcher = getServletContext().getRequestDispatcher(servletDestiny);
        } else {
            dispatcher = getServletContext().getNamedDispatcher(servletDestiny);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AbstractServlet.class.getName()).log(Level.SEVERE,
                    "Error al ejecutar el Dispatcher", ex);
            processRequestDispatcher(request, response, errorPage, isRequest);
        }
    }

    @Override
    public void init() {
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        implementationType = context.getInitParameter("implementationType");
        principalPage = context.getInitParameter("principalPage");
        errorPage = context.getInitParameter("errorPage");
        sucessPage = context.getInitParameter("succesPage");
        authenticationServlet = context.getInitParameter("authenticationServlet");
        sendEmailServlet = context.getInitParameter("sendEmailServlet");
        createServlet = context.getInitParameter("createServlet");
        deleteServlet = context.getInitParameter("deleteServlet");
        readServlet = context.getInitParameter("readServlet");
        updateServlet = context.getInitParameter("updateServlet");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
