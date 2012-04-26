package persistence2;

import model2.User;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOJDBC implements UserDAO {

    private final Object lock = new Object();
    private Connection connection = null;
    private static UserDAOJDBC mechanismOfPersistence = null;
    private static final Logger log = Logger.getLogger(UserDAOJDBC.class.getName());

    public UserDAOJDBC() {
    }

    public static UserDAO getImplementation() {
        if (mechanismOfPersistence == null) {
            mechanismOfPersistence = new UserDAOJDBC();
        }
        return mechanismOfPersistence;
    }

    @Override
    public boolean newUser(User user) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO \"USERS\" VALUES(?,?,?,?,?,?)";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserSurnames());
            statement.setString(3, user.getUserAdress());
            statement.setString(4, user.getUserEmail());
            statement.setString(5, user.getUserPassword());
            statement.setBoolean(6, user.getUserPrivileged());
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
    public boolean deleteUser(User user) {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM \"USERS\" WHERE userEmail = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, user.getUserEmail());
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
    public boolean updateUser(User oldUser, User newUser) {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE \"USERS\" SET userName = ?, userSurnames = ?, "
                    + "userAdress = ?, userEmail = ?, userPassword = ?, userPrivileged = ?"
                    + "WHERE userEmail = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, newUser.getUserName());
            statement.setObject(2, newUser.getUserSurnames());
            statement.setObject(3, newUser.getUserAdress());
            statement.setString(4, newUser.getUserEmail());
            statement.setString(5, newUser.getUserPassword());
            statement.setBoolean(6, newUser.getUserPrivileged());
            statement.setString(7, oldUser.getUserEmail());
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
    public String userAuthentication(String userEmail, String userPass) {
        PreparedStatement statement = null;
        ResultSet result = null;
        User u;
        String response = null;
        if (userEmail != null && userPass != null) {
            try {
                String query = "SELECT * FROM \"USERS\" WHERE userEmail = ?";
                synchronized (lock) {
                    statement = connection.prepareStatement(query);
                }
                statement.setString(1, userEmail);
                result = statement.executeQuery();
                if (result.next()) {
                    u = new User(result.getString("userName"), result.getString("userSurnames"),
                            result.getString("userAdress"), result.getString("userEmail"),
                            result.getString("userPassword"), result.getBoolean("userPrivileged"));
                    if (u.getUserPrivileged()) {
                        response = "true";
                    } else {
                        response = "false";
                    }
                }
            } catch (SQLException ex) {
                log.log(Level.WARNING, "Fallo al realizar SELECT contra la Base de Datos", ex);
                response = null;
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
        }
        return response;
    }

    @Override
    public User getUser(String userEmail) {
        PreparedStatement statement = null;
        ResultSet result = null;
        User u = null;
        try {
            String query = "SELECT * FROM \"USERS\" WHERE userEmail = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, userEmail);
            result = statement.executeQuery();
            if (result.next()) {
                u = new User(result.getString("userName"), result.getString("userSurnames"),
                        result.getString("userAdress"), result.getString("userEmail"),
                        result.getString("userPassword"), result.getBoolean("userPrivileged"));
            }
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar SELECT contra la Base de Datos", ex);
            u = null;
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
        return u;
    }

    @Override
    public Map<String, User> getUserMap() {
        String query = "SELECT * FROM \"USERS\"";
        PreparedStatement statement = null;
        ResultSet result = null;
        User u;
        Map<String, User> map = new HashMap<>();
        try {
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            result = statement.executeQuery();
            while (result.next()) {
                u = new User(result.getString("userName"), result.getString("userSurnames"),
                        result.getString("userAdress"), result.getString("userEmail"),
                        result.getString("userPassword"), result.getBoolean("userPrivileged"));
                map.put(u.getUserEmail(), u);
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
    public Map<String, User> getUserMap(String parameter, String condition) {
        String query = "SELECT * FROM \"USERS\" WHERE ? = ?";
        PreparedStatement statement = null;
        ResultSet result = null;
        User u;
        Map<String, User> map = new HashMap<>();
        try {
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, parameter);
            statement.setString(2, condition);
            result = statement.executeQuery();
            while (result.next()) {
                u = new User(result.getString("userName"), result.getString("userSurnames"),
                        result.getString("userAdress"), result.getString("userEmail"),
                        result.getString("userPassword"), result.getBoolean("userPrivileged"));
                map.put(u.getUserEmail(), u);
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
