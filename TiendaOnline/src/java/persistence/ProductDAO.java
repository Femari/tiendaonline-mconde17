package persistence;

import java.util.Map;
import model.Product;

public interface ProductDAO extends PersistenceManager {

    @Override
    public boolean newProduct(Product product);

    @Override
    public boolean deleteProduct(Product product);

    @Override
    public boolean updateProduct(Product oldProduct, Product newProduct);

    @Override
    public Product getProduct(String productName);

    @Override
    public Map<String, Product> getProductMap();

    @Override
    public Map<String, Product> getProductMap(String parameter, String condition);

    @Override
    public boolean connection(String user, String pass, String destiny, String driver);

    @Override
    public boolean disconnect();
}
