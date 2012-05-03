package persistence;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.Sale;
import model.ShoppingCart;
import model.User;

public class SaleDAOJDBC implements SaleDAO {

    private final Object lock = new Object();
    private Connection connection = null;
    private static SaleDAOJDBC mechanismOfPersistence = null;
    private static final Logger log = Logger.getLogger(SaleDAOJDBC.class.getName());

    public SaleDAOJDBC() {
    }

    public static SaleDAO getImplementation() {
        if (mechanismOfPersistence == null) {
            mechanismOfPersistence = new SaleDAOJDBC();
        }
        return mechanismOfPersistence;
    }

    @Override
    public boolean newSale(Sale sale) {
        boolean statementResult = false;
        boolean addShoppingCartResult;
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO \"SALES\" VALUES(?,?,?,?,?)";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, sale.getSaleID());
            statement.setString(2, sale.getSaleClient().getUserEmail());
            statement.setString(3, sale.getSalePaymentMethod());
            statement.setString(4, sale.getSaleAdress());
            statement.setString(5, sale.getSaleDate());
            statementResult = statement.execute();
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
        addShoppingCartResult = addShoppingCart(sale.getSaleID(), sale.getSaleShoppingCart());
        if (statementResult && addShoppingCartResult) {
            statementResult = true;
        }
        return statementResult;
    }

    @Override
    public boolean deleteSale(Sale sale) {
        boolean statementResult = false;
        boolean deleteShoppingCartResult;
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM \"SALES\" WHERE saleID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, sale.getSaleID());
            statementResult = statement.execute();
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
        deleteShoppingCartResult = deleteShoppingCart(sale.getSaleID());
        if (statementResult && deleteShoppingCartResult) {
            statementResult = true;
        }
        return statementResult;
    }

    @Override
    public boolean updateSale(Sale oldSale, Sale newSale) {
        PreparedStatement statement = null;
        boolean statementResult = false;
        boolean deleteShoppingCartResult;
        boolean addShoppingCartResult;
        try {
            String query = "UPDATE \"SALES\" SET saleID = ?, saleClient = ?, "
                    + "saleCart = ?, salePaymentMethod = ?, saleAdress = ?, saleDate = ?"
                    + "WHERE saleID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, newSale.getSaleID());
            statement.setObject(2, newSale.getSaleClient());
            statement.setObject(3, newSale.getSaleShoppingCart());
            statement.setString(4, newSale.getSalePaymentMethod());
            statement.setString(5, newSale.getSaleAdress());
            statement.setString(6, newSale.getSaleDate());
            statement.setString(7, oldSale.getSaleID());
            statementResult = statement.execute();
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
        deleteShoppingCartResult = deleteShoppingCart(oldSale.getSaleID());
        addShoppingCartResult = addShoppingCart(newSale.getSaleID(), newSale.getSaleShoppingCart());
        if (statementResult && deleteShoppingCartResult && addShoppingCartResult) {
            statementResult = true;
        }
        return statementResult;
    }

    @Override
    public Sale getSale(String saleID) {
        PreparedStatement statement = null;
        ResultSet result = null;
        Sale s = null;
        try {
            String query = "SELECT * FROM \"SALES\" WHERE saleID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, saleID);
            result = statement.executeQuery();
            if (result.next()) {
                String userEmail = result.getString("userEmail");
                User u = UserDAOJDBC.getImplementation().getUser(userEmail);
                ShoppingCart cart = getShoppingCart(saleID);
                s = new Sale(result.getString("saleID"), u,
                        cart, result.getString("salePaymentMethod"),
                        result.getString("saleAdress"),
                        result.getString("saleDate"));
            }
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar SELECT contra la Base de Datos", ex);
            s = null;
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
        return s;
    }

    @Override
    public Map<String, Sale> getSaleMap() {
        String query = "SELECT * FROM \"SALES\"";
        PreparedStatement statement = null;
        ResultSet result = null;
        Sale s;
        Map<String, Sale> map = new HashMap<>();
        try {
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            result = statement.executeQuery();
            while (result.next()) {
                String userEmail = result.getString("userEmail");
                String saleID = result.getString("saleID");
                User u = UserDAOJDBC.getImplementation().getUser(userEmail);
                ShoppingCart cart = getShoppingCart(saleID);
                s = new Sale(result.getString("saleID"), u,
                        cart, result.getString("salePaymentMethod"),
                        result.getString("saleAdress"),
                        result.getString("saleDate"));
                map.put(s.getSaleID(), s);
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
    public Map<String, Sale> getSaleMap(String parameter, String condition) {
        String query = "SELECT * FROM \"SALES\" WHERE ? = ?";
        PreparedStatement statement = null;
        ResultSet result = null;
        Sale s;
        Map<String, Sale> map = new HashMap<>();
        try {
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, parameter);
            statement.setString(2, condition);
            result = statement.executeQuery();
            while (result.next()) {
                String userEmail = result.getString("userEmail");
                String saleID = result.getString("saleID");
                User u = UserDAOJDBC.getImplementation().getUser(userEmail);
                ShoppingCart cart = getShoppingCart(saleID);
                s = new Sale(result.getString("saleID"), u,
                        cart, result.getString("salePaymentMethod"),
                        result.getString("saleAdress"),
                        result.getString("saleDate"));
                map.put(s.getSaleID(), s);
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

    public boolean addShoppingCart(String saleID, ShoppingCart c) {
        PreparedStatement statement = null;
        boolean statementResult = false;
        try {
            String query = "SELECT * FROM \"SHOPPINGCARTS\" WHERE saleID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            Iterator it = c.getShoppingCart().iterator();
            while (it.hasNext()) {
                Product p = (Product) it.next();
                statement.setString(1, saleID);
                statement.setString(2, p.getProductID());
                statementResult = statement.execute();
                if (!statementResult) {
                    return statementResult;
                }
            }
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
        return statementResult;
    }

    public boolean deleteShoppingCart(String saleID) {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM \"SHOPPINGCARTS\" WHERE saleID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, saleID);
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

    public ShoppingCart getShoppingCart(String saleID) {
        PreparedStatement statement = null;
        ResultSet result = null;
        ShoppingCart cart = null;
        try {
            String query = "SELECT * FROM \"PRODUCTS\" p, \"SHOPPINGCARTS\"s WHERE "
                    + "s.productID = p.productID "
                    + "AND s.saleID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            Product p;
            statement.setString(1, saleID);
            result = statement.executeQuery();
            while (result.next()) {
                p = new Product(result.getString("productID"), result.getFloat("productPrice"),
                        result.getString("productShortDescription"), result.getString("productLongDescription"),
                        result.getInt("productStock"), result.getString("productImageURL"));
                cart.addProduct(p);
            }
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar SELECT contra la Base de Datos", ex);
            return null;
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
                } catch (SQLException ex2) {
                    log.log(Level.INFO, "No se pudo cerrar el Statemet del SELECT", ex2);
                }
            }
        }
        return cart;
    }
}
