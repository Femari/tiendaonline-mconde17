package Persistence;

import Model.Sale;
import java.util.List;

public class SaleDAOJDBC implements SaleDAO {

    @Override
    public boolean newSale(Sale sale) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteSale(Sale sale) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateSale(Sale oldSale, Sale newSale) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Sale> getSaleList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Sale> getSaleList(Object parameter, String condition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Sale getSale(String saleID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static SaleDAO getImplementation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
