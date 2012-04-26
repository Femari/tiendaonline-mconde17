package webactions;

import model.ShoppingCart;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerServlet implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ShoppingCart cart = new ShoppingCart();
        session.setAttribute("shoppingCart", cart);
        boolean authentication = false;
        session.setAttribute("authentication", authentication);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
