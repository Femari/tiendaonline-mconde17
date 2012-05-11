package persistence;

import java.util.Map;
import model.Comment;
import model.Product;
import model.Sale;
import model.User;

public interface PersistenceManager {

    //Common:
    public boolean connection(String user, String pass, String destiny, String driver);

    public boolean disconnect();

    //Product:
    public boolean newProduct(Product product);

    public boolean deleteProduct(Product product);

    public boolean updateProduct(Product oldProduct, Product newProduct);

    public Product getProduct(String productName);

    public Map<String, Product> getProductMap();

    public Map<String, Product> getProductMap(String parameter, String condition);

    //Comment:
    public boolean newComment(Comment comment);

    public boolean deleteComment(Comment comment);

    public boolean updateComment(Comment oldComment, Comment newComment);

    public Comment getComment(String commentID);

    public Map<String, Comment> getCommentMap();

    public Map<String, Comment> getCommentMap(String parameter, String condition);

    //Sale:
    public boolean newSale(Sale sale);

    public boolean deleteSale(Sale sale);

    public boolean updateSale(Sale oldSale, Sale newSale);

    public Sale getSale(String saleID);

    public Map<String, Sale> getSaleMap();

    public Map<String, Sale> getSaleMap(String parameter, String condition);

    //User:
    public boolean newUser(User user);

    public boolean deleteUser(User user);

    public boolean updateUser(User oldUser, User newUser);

    public boolean userAuthentication(String userEmail, String userPass);

    public User getUser(String userEmail);

    public Map<String, User> getUserMap();

    public Map<String, User> getUserMap(String parameter, String condition);
}
