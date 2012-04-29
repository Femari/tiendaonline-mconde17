package webactions;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyCoolServlet extends HttpServlet {

    protected String persistenceMechanism = null;
    protected String displayForm = null;
    protected String errorForm = null;
    protected String successForm = null;
    protected String authenticationServlet = null;
    protected String addToShoppingCartServlet = null;
    protected String sendEmailServlet = null;
    protected String createServlet = null; // C
    protected String readServlet = null; //   R
    protected String updateServlet = null; // U
    protected String deleteServlet = null; // D
    protected String saleServlet = null;

    protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected void goToURL(String adress, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = getServletContext().getRequestDispatcher(adress);
        dispatcher.forward(request, response);
    }

    protected void goToNamedResource(String address, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = getServletContext().getNamedDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    public void init() {
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        persistenceMechanism = context.getInitParameter("persistenceMechanism");
        displayForm = context.getInitParameter("displayForm");
        errorForm = context.getInitParameter("errorForm");
        successForm = context.getInitParameter("succesForm");
        authenticationServlet = context.getInitParameter("authenticationServlet");
        addToShoppingCartServlet = context.getInitParameter("addToShoppingCargServlet");
        sendEmailServlet = context.getInitParameter("sendEmailServlet");
        createServlet = context.getInitParameter("createServlet");
        deleteServlet = context.getInitParameter("deleteServlet");
        readServlet = context.getInitParameter("readServlet");
        updateServlet = context.getInitParameter("updateServlet");
        saleServlet = context.getInitParameter("saleServlet");
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