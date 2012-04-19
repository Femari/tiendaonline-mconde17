package Persistence;

import Model.Comment;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommentDAOJDBC implements CommentDAO {

    private final Object lock = new Object();
    private Connection connection = null;
    private static CommentDAOJDBC implementationType = null;
    private static final Logger log = Logger.getLogger(CommentDAOJDBC.class.getName());

    public CommentDAOJDBC() {
    }

    public static CommentDAO getImplementation() {
        if (implementationType == null) {
            implementationType = new CommentDAOJDBC();
        }
        return implementationType;
    }

    @Override
    public boolean newComment(Comment comment) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO \"COMMENTS\" VALUES(?,?,?,?,?)";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, comment.getCommentID());
            statement.setString(2, comment.getCommentDate());
            statement.setString(3, comment.getCommentProductID());
            statement.setString(4, comment.getCommentUserEmail());
            statement.setString(5, comment.getCommentContent());
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
    public boolean deleteComment(Comment comment) {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM \"COMMENTS\" WHERE commentID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, comment.getCommentID());
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
    public boolean updateComment(Comment oldComment, Comment newComment) {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE \"COMMENTS\" SET commentID = ?, commentDate = ?, "
                    + "productID = ?, userEmail = ?, commentContent = ?"
                    + "WHERE commentID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, newComment.getCommentID());
            statement.setString(2, newComment.getCommentDate());
            statement.setString(3, newComment.getCommentProductID());
            statement.setString(4, newComment.getCommentUserEmail());
            statement.setString(5, newComment.getCommentContent());
            statement.setString(6, oldComment.getCommentID());
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
    public Comment getComment(String commentID) {
        PreparedStatement statement = null;
        ResultSet result = null;
        Comment c = null;
        try {
            String query = "SELECT * FROM \"COMMENTS\" WHERE commentID = ?";
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, commentID);
            result = statement.executeQuery();
            if (result.next()) {
                c = new Comment(result.getString("commentID"), result.getString("commentDate"),
                        result.getString("productID"), result.getString("userEmail"),
                        result.getString("commentContent"));
            }
        } catch (SQLException ex) {
            log.log(Level.WARNING, "Fallo al realizar SELECT contra la Base de Datos", ex);
            c = null;
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
        return c;
    }

    @Override
    public Map<String, Comment> getCommentMap() {
        String query = "SELECT * FROM \"COMMENTS\"";
        PreparedStatement statement = null;
        ResultSet result = null;
        Comment c;
        Map<String, Comment> map = new HashMap<>();
        try {
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            result = statement.executeQuery();
            while (result.next()) {
                c = new Comment(result.getString("commentID"), result.getString("commentDate"),
                        result.getString("productID"), result.getString("userEmail"),
                        result.getString("commentContent"));
                map.put(c.getCommentID(), c);
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
    public Map<String, Comment> getCommentMap(String parameter, String condition) {
        String query = "SELECT * FROM \"COMMENTS\" WHERE ? = ?";
        PreparedStatement statement = null;
        ResultSet result = null;
        Comment c;
        Map<String, Comment> map = new HashMap<>();
        try {
            synchronized (lock) {
                statement = connection.prepareStatement(query);
            }
            statement.setString(1, parameter);
            statement.setString(2, condition);
            result = statement.executeQuery();
            while (result.next()) {
                c = new Comment(result.getString("commentID"), result.getString("commentDate"),
                        result.getString("productID"), result.getString("userEmail"),
                        result.getString("commentContent"));
                map.put(c.getCommentID(), c);
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
