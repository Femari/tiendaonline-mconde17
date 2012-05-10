package persistence;

import java.util.Map;
import model.Sale;

public interface SaleDAO extends PersistenceManager {

    @Override
    public boolean newSale(Sale sale);

    @Override
    public boolean deleteSale(Sale sale);

    @Override
    public boolean updateSale(Sale oldSale, Sale newSale);

    @Override
    public Sale getSale(String saleID);

    @Override
    public Map<String, Sale> getSaleMap();

    @Override
    public Map<String, Sale> getSaleMap(String parameter, String condition);

    @Override
    public boolean connection(String user, String pass, String destiny, String driver);

    @Override
    public boolean disconnect();
}
