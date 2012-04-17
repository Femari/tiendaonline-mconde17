package Persistence;

import Model.Sale;
import java.util.Map;

public interface SaleDAO {

    public boolean newSale(Sale sale);

    public boolean deleteSale(Sale sale);

    public boolean updateSale(Sale oldSale, Sale newSale);

    public Sale getSale(String saleID);

    public Map<String, Sale> getSaleMap();

    public Map<String, Sale> getSaleMap(String parameter, String condition);

    public boolean connection(String user, String pass, String destiny, String driver);

    public boolean disconnect();
}
