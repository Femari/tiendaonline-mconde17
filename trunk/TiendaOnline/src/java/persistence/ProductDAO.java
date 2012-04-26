package persistence;

import model.Product;
import java.util.Map;

public interface ProductDAO {

    public boolean newProduct(Product product);

    public boolean deleteProduct(Product product);

    public boolean updateProduct(Product oldProduct, Product newProduct);

    public Product getProduct(String productName);

    public Map<String, Product> getProductMap();

    public Map<String, Product> getProductMap(String parameter, String condition);

    public boolean connection(String user, String pass, String destiny, String driver);

    public boolean disconnect();
}
