package Persistence;

import Model.Sale;
import java.util.List;

public interface SaleDAO {

    public boolean newSale(Sale sale);

    public boolean deleteSale(Sale sale);

    public boolean updateSale(Sale oldSale, Sale newSale);

    public Sale getSale(String saleID);

    public List<Sale> getSaleList();

    public List<Sale> getSaleList(Object parameter, String condition);

}
