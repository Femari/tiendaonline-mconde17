package persistence;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class ProductDAOJDBC implements ProductDAO {

    private final Object lock = new Object();
    private Connection connection = null;
    private static ProductDAOJDBC mechanismOfPersistence = null;
    private static final Logger log = Logger.getLogger(ProductDAOJDBC.class.getName());

    public ProductDAOJDBC() {
    }

    public static ProductDAO getImplementation() {
        if (mechanismOfPersistence == null) {
            mechanismOfPersistence = new ProductDAOJDBC();
        }
        return mechanismOfPersistence;
    }

    @Override
    public boolean newProduct(Product product) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO \"PRODUCTS\" VALUES(?,?,?,?,?,?)";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, product.getProductID());
            statement.setFloat(2, product.getProductPrice());
            statement.setString(3, product.getProductShortDescription());
            statement.setString(4, product.getProductLongDescription());
            statement.setInt(5, product.getProductStock());
            statement.setString(6, product.getProductImageURL());
            return statement.execute();
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar INSERT contra la Base de Datos", ex);
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex2) {
                    log.log(Level.INFO, "No se pudo cerrar el Statemet del INSERT", ex2);
                }
            }
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM \"PRODUCTS\" WHERE productID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, product.getProductID());
            return statement.execute();
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar DELETE contra la Base de Datos", ex);
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex2) {
                    log.log(Level.INFO, "No se pudo cerrar el Statemet del DELETE", ex2);
                }
            }
        }
    }

    @Override
    public boolean updateProduct(Product oldProduct, Product newProduct) {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE \"PRODUCTS\" SET productID = ?, productPrice = ?, "
                    + "productShortDescription = ?, productLongDescription = ?, productStock = ?, "
                    + "productImageURL = ? WHERE productID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, newProduct.getProductID());
            statement.setFloat(2, newProduct.getProductPrice());
            statement.setString(3, newProduct.getProductShortDescription());
            statement.setString(4, newProduct.getProductLongDescription());
            statement.setInt(5, newProduct.getProductStock());
            statement.setString(6, newProduct.getProductImageURL());
            statement.setString(7, oldProduct.getProductID());
            return statement.execute();
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar UPDATE contra la Base de Datos", ex);
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex2) {
                    log.log(Level.INFO, "No se pudo cerrar el Statemet del UPDATE", ex2);
                }
            }
        }
    }

    @Override
    public Product getProduct(String productName) {
        PreparedStatement statement = null;
        ResultSet result = null;
        Product p = null;
        try {
            String query = "SELECT * FROM \"PRODUCTS\" WHERE productID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, productName);
            result = statement.executeQuery();
            if (result.next()) {
                p = new Product(result.getString("productID"), result.getFloat("productPrice"),
                        result.getString("productShortDescription"), result.getString("productLongDescription"),
                        result.getInt("productStock"), result.getString("productImageURL"));
            }
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar SELECT contra la Base de Datos", ex);
            p = null;
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex2) {
                    log.log(Level.INFO, "No se pudo cerrar el ResultSet del SELECT", ex2);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex3) {
                    log.log(Level.INFO, "No se pudo cerrar el Statemet del SELECT", ex3);
                }
            }
        }
        return p;
    }

    @Override
    public Map<String, Product> getProductMap() {
        String query = "SELECT * FROM \"PRODUCTS\"";
        PreparedStatement statement = null;
        ResultSet result = null;
        Product p;
        Map<String, Product> map = new HashMap<>();
        try {
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            result = statement.executeQuery();
            while (result.next()) {
                p = new Product(result.getString("productID"), result.getFloat("productPrice"),
                        result.getString("productShortDescription"), result.getString("productLongDescription"),
                        result.getInt("productStock"), result.getString("productImageURL"));
                map.put(p.getProductID(), p);
            }
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar SELECT contra la Base de Datos", ex);
            map = null;
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex2) {
                    log.log(Level.INFO, "No se pudo cerrar el ResultSet del SELECT", ex2);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex3) {
                    log.log(Level.INFO, "No se pudo cerrar el Statemet del SELECT", ex3);
                }
            }

        }
        return map;
    }

    @Override
    public Map<String, Product> getProductMap(String parameter, String condition) {
        String query = "SELECT * FROM \"PRODUCTS\" WHERE ? = ?";
        PreparedStatement statement = null;
        ResultSet result = null;
        Product p;
        Map<String, Product> map = new HashMap<>();
        try {
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, parameter);
            statement.setString(2, condition);
            result = statement.executeQuery();
            while (result.next()) {
                p = new Product(result.getString("productID"), result.getFloat("productPrice"),
                        result.getString("productShortDescription"), result.getString("productLongDescription"),
                        result.getInt("productStock"), result.getString("productImageURL"));
                map.put(p.getProductID(), p);
            }
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar SELECT contra la Base de Datos", ex);
            map = null;
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex2) {
                    log.log(Level.INFO, "No se pudo cerrar el ResultSet del SELECT", ex2);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex3) {
                    log.log(Level.INFO, "No se pudo cerrar el Statemet del SELECT", ex3);
                }
            }
        }
        return map;
    }

    @Override
    public boolean connection(String user, String pass, String destiny, String driver) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(user, pass, destiny);
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            log.log(Level.WARNING, "No se ha podido crear la conexión con la Base de Datos", ex);
            return false;
        }
    }

    @Override
    public boolean disconnect() {
        try {
            connection.close();
            return true;
        } catch (SQLException ex) {
            log.log(Level.WARNING, "No se ha podido cerrar la conexión con la Base de Datos", ex);
            return false;
        }
    }
}
