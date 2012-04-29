package webactions;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import persistence.PersistenceDAO;
import persistence.ProductDAO;
import persistence.SaleDAO;

public class StartUpListener implements ServletContextListener {

    private ProductDAO productDAO;
    private SaleDAO saleDAO;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String destiny, driver, user, password, persistenceMechanism;
        ServletContext context = sce.getServletContext();
        destiny = context.getInitParameter("databaseURL");
        driver = context.getInitParameter("databaseDriver");
        user = context.getInitParameter("databaseUser");
        password = context.getInitParameter("databasePassword");
        persistenceMechanism = context.getInitParameter("persistenceMechanism");
        productDAO = PersistenceDAO.getProductDAO(persistenceMechanism);
        saleDAO = PersistenceDAO.getSaleDAO(persistenceMechanism);
        context.setAttribute("productList", productDAO.getProductMap());
        context.setAttribute("saleList", saleDAO.getSaleMap());
        boolean ok = productDAO.connection(user, password, destiny, driver) && saleDAO.connection(user, password, destiny, driver);
        if (!ok) {
            context.setAttribute("persistenceMechanism", "none");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        boolean ok = productDAO.disconnect();
        if (!ok) {
            Logger.getLogger(StartUpListener.class.getName()).log(Level.SEVERE,
                    "No se encontró el driver de la base de datos");
        }
    }
}
