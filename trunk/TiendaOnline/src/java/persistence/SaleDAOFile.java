package persistence;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sale;

public class SaleDAOFile implements SaleDAO {

    private Map<String, Sale> saleMap = new HashMap<>();
    private String saleFile;
    private static SaleDAOFile mechanismOfPersistence = null;
    private static final Logger log = Logger.getLogger(SaleDAOFile.class.getName());

    public SaleDAOFile() {
    }

    public static SaleDAO getInstance() {
        if (mechanismOfPersistence == null) {
            mechanismOfPersistence = new SaleDAOFile();
        }
        return mechanismOfPersistence;
    }

    @Override
    public synchronized boolean newSale(Sale sale) {
        if (getSaleMap().containsKey(sale.getSaleID())) {
            return false;
        } else {
            getSaleMap().put(sale.getSaleID(), sale);
            return true;
        }
    }

    @Override
    public synchronized boolean deleteSale(Sale sale) {
        if (getSaleMap().containsKey(sale.getSaleID())) {
            getSaleMap().remove(sale.getSaleID());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized boolean updateSale(Sale oldSale, Sale newSale) {
        if (getSaleMap().containsKey(oldSale.getSaleID())) {
            getSaleMap().put(oldSale.getSaleID(), newSale);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized Sale getSale(String saleID) {
        return getSaleMap().get(saleID);
    }

    @Override
    public Map<String, Sale> getSaleMap() {
        return saleMap;
    }

    @Override
    public Map<String, Sale> getSaleMap(String parameter, String condition) {
        Map<String, Sale> resultMap = new HashMap<>(getSaleMap());
        Iterator it = getSaleMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            Sale s = (Sale) e.getValue();
            if (s.isEquals(parameter, condition)) {
                resultMap.put(s.getSaleID(), s);
            }
        }
        return resultMap;
    }

    @Override
    public boolean connection(String user, String pass, String destiny, String driver) {
        this.saleFile = destiny + "sales";
        File f = new File(this.saleFile);
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            if (f.exists() && f.isFile() && f.length() > 0) {
                is = new FileInputStream(f);
                ois = new ObjectInputStream(is);
                int numberOfSales = (Integer) ois.readObject();
                for (int i = 0; i < numberOfSales; i++) {
                    Sale s = (Sale) ois.readObject();
                    getSaleMap().put(s.getSaleID(), s);
                }
            } else {
                if (f.createNewFile()) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | IOException ex) {
            log.log(Level.WARNING, "No se pudo crear la Conexion correctamente", ex);
            return false;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex2);
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex3) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex3);
            }
        }
        return true;
    }

    @Override
    public boolean disconnect() {
        File f = new File(this.saleFile);
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            if (f.exists() && f.isFile()) {
                os = new FileOutputStream(f);
                oos = new ObjectOutputStream(os);
                int mapSize = getSaleMap().size();
                oos.writeObject(mapSize);
                Iterator it = getSaleMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry e = (Map.Entry) it.next();
                    Sale s = (Sale) e.getValue();
                    oos.writeObject(s);
                }
            }
        } catch (IOException ex) {
            log.log(Level.WARNING, "No se pudo realizar la Desconexión de forma correcta", ex);
            return false;
        } finally {
            try {
                oos.close();
            } catch (IOException ex2) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex2);
            }
            try {
                os.close();
            } catch (IOException ex3) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex3);
            }
        }
        return true;
    }
}
