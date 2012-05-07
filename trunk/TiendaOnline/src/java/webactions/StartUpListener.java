package webactions;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import persistence.*;

public class StartUpListener implements ServletContextListener {

    private ProductDAO productDAO;
    private SaleDAO saleDAO;
    private UserDAO userDAO;
    private CommentDAO commentDAO;
    private static ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String destiny, driver, user, password, persistenceMechanism;
        context = sce.getServletContext();
        destiny = context.getInitParameter("databaseURL");
        driver = context.getInitParameter("databaseDriver");
        user = context.getInitParameter("databaseUser");
        password = context.getInitParameter("databasePassword");
        persistenceMechanism = context.getInitParameter("persistenceMechanism");
        productDAO = PersistenceDAO.getProductDAO(persistenceMechanism);
        saleDAO = PersistenceDAO.getSaleDAO(persistenceMechanism);
        userDAO = PersistenceDAO.getUserDAO(persistenceMechanism);
        commentDAO = PersistenceDAO.getCommentDAO(persistenceMechanism);
        context.setAttribute("productList", productDAO.getProductMap());
        context.setAttribute("saleList", saleDAO.getSaleMap());
        context.setAttribute("userList", userDAO.getUserMap());
        context.setAttribute("commentList", commentDAO.getCommentMap());
        boolean ok = productDAO.connection(user, password, destiny, driver)
                && saleDAO.connection(user, password, destiny, driver)
                && userDAO.connection(user, password, destiny, driver)
                && commentDAO.connection(user, password, destiny, driver);
        if (!ok) {
            context.setAttribute("persistenceMechanism", "none");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        boolean ok = productDAO.disconnect()
                && saleDAO.disconnect()
                && userDAO.disconnect()
                && commentDAO.disconnect();
        if (!ok) {
            Logger.getLogger(StartUpListener.class.getName()).log(Level.SEVERE,
                    "No se pudo realizar correctamente la desconexión");
        }
    }

    public static ServletContext getContext() {
        return context;
    }
}
