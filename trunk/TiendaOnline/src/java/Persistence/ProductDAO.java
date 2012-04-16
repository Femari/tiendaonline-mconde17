package Persistence;

import Model.Product;

public interface ProductDAO {
    
    public boolean newProduct(Product product);
    
    public boolean deleteProduct(Product product);
    
}
