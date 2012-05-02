package persistence;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class ProductDAOFile implements ProductDAO {

    private Map<String, Product> productMap = new HashMap<>();
    private String productFile;
    private static ProductDAOFile mechanismOfPersistence = null;
    private static final Logger log = Logger.getLogger(ProductDAOFile.class.getName());

    public ProductDAOFile() {
    }

    public static ProductDAO getImplementation() {
        if (mechanismOfPersistence == null) {
            mechanismOfPersistence = new ProductDAOFile();
        }
        return mechanismOfPersistence;
    }

    @Override
    public synchronized boolean newProduct(Product product) {
        if (getProductMap().containsKey(product.getProductID())) {
            return false;
        } else {
            getProductMap().put(product.getProductID(), product);
            return true;
        }
    }

    @Override
    public synchronized boolean deleteProduct(Product product) {
        if (getProductMap().containsKey(product.getProductID())) {
            getProductMap().remove(product.getProductID());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized boolean updateProduct(Product oldProduct, Product newProduct) {
        if (getProductMap().containsKey(oldProduct.getProductID())) {
            getProductMap().put(oldProduct.getProductID(), newProduct);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized Product getProduct(String productName) {
        return getProductMap().get(productName);
    }

    @Override
    public Map<String, Product> getProductMap() {
        return productMap;
    }

    @Override
    public Map<String, Product> getProductMap(String parameter, String condition) {
        Map<String, Product> resultMap = new HashMap<>();
        Iterator it = getProductMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            Product p = (Product) e.getValue();
            if (p.isEquals(parameter, condition)) {
                resultMap.put(p.getProductID(), p);
            }
        }
        return resultMap;
    }

    @Override
    public boolean connection(String user, String pass, String destiny, String driver) {
        this.productFile = destiny;
        File f = new File(this.productFile);
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            if (f.exists() && f.isFile() && f.length()>0) {
                is = new FileInputStream(f);
                ois = new ObjectInputStream(is);
                int numberOfProducts = (Integer) ois.readObject();
                for (int i = 0; i < numberOfProducts; i++) {
                    Product p = (Product) ois.readObject();
                    getProductMap().put(p.getProductID(), p);
                }
            } else {
                if(f.createNewFile()){
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
        File f = new File(this.productFile);
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            if (f.exists() && f.isFile()) {
                os = new FileOutputStream(f);
                oos = new ObjectOutputStream(os);
                int mapSize = getProductMap().size();
                oos.writeObject(mapSize);
                Iterator it = getProductMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry e = (Map.Entry) it.next();
                    Product p = (Product) e.getValue();
                    oos.writeObject(p);
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
