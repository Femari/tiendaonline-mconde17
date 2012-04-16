package Persistence;

import Model.Product;
import java.util.List;

public class ProductDAOFile implements ProductDAO {

    @Override
    public boolean newProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateProduct(Product oldProduct, Product newProduct) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProduct(String productName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Product> getProductList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Product> getProductList(Object parameter, String condition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static ProductDAO getImplementation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
