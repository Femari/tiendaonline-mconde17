package Persistence;

import Model.Sale;
import Model.ShoppingCart;
import Model.User;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleDAOJDBC implements SaleDAO {

    private final Object lock = new Object();
    private Connection connection = null;
    private static SaleDAOJDBC implementationType = null;
    private static final Logger log = Logger.getLogger(SaleDAOJDBC.class.getName());

    public SaleDAOJDBC() {
    }

    public static SaleDAO getImplementation() {
        if (implementationType == null) {
            implementationType = new SaleDAOJDBC();
        }
        return implementationType;
    }

    @Override
    public boolean newSale(Sale sale) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO \"SALES\" VALUES(?,?,?,?,?)";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, sale.getSaleID());
            statement.setObject(2, sale.getSaleClient());
            statement.setObject(3, sale.getSaleShoppingCart());
            statement.setString(4, sale.getSalePaymentMethod());
            statement.setString(5, sale.getSaleDate());
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
    public boolean deleteSale(Sale sale) {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM \"SALES\" WHERE saleID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, sale.getSaleID());
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
    public boolean updateSale(Sale oldSale, Sale newSale) {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE \"SALES\" SET saleID = ?, saleClient = ?, "
                    + "saleCart = ?, salePaymentMethod = ?, saleDate = ?"
                    + "WHERE saleID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, newSale.getSaleID());
            statement.setObject(2, newSale.getSaleClient());
            statement.setObject(3, newSale.getSaleShoppingCart());
            statement.setString(4, newSale.getSalePaymentMethod());
            statement.setString(5, newSale.getSaleDate());
            statement.setString(6, oldSale.getSaleID());
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
                s = new Sale(result.getString("saleID"), (User) result.getObject("saleClient"),
                        (ShoppingCart) result.getObject("saleCart"), result.getString("salePaymentMethod"),
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
                s = new Sale(result.getString("saleID"), (User) result.getObject("saleClient"),
                        (ShoppingCart) result.getObject("saleCart"), result.getString("salePaymentMethod"),
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
                s = new Sale(result.getString("saleID"), (User) result.getObject("saleClient"),
                        (ShoppingCart) result.getObject("saleCart"), result.getString("salePaymentMethod"),
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
}
