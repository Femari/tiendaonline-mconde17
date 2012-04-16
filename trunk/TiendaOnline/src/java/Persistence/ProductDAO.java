package Persistence;

import Model.Product;
import java.util.List;

public interface ProductDAO {

    public boolean newProduct(Product product);

    public boolean deleteProduct(Product product);

    public boolean updateProduct(Product oldProduct, Product newProduct);

    public Product getProduct(String productName);

    public List<Product> getProductList();

    public List<Product> getProductList(Object parameter, String condition);
   
}
