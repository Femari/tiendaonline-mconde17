package persistence;

public class PersistenceDAO {

    public static ProductDAO getProductDAO(String mechanismOfPersistence) {
        switch (mechanismOfPersistence) {
            case "file":
                return ProductDAOFile.getImplementation();
            case "jdbc":
                return ProductDAOJDBC.getImplementation();
            default:
                return null;
        }
    }

    public static SaleDAO getSaleDAO(String mechanismOfPersistence) {
        switch (mechanismOfPersistence) {
            case "file":
                return SaleDAOFile.getImplementation();
            case "jdbc":
                return SaleDAOJDBC.getImplementation();
            default:
                return null;
        }
    }

    public static UserDAO getUserDAO(String mechanismOfPersistence) {
        switch (mechanismOfPersistence) {
            case "file":
                return UserDAOFile.getImplementation();
            case "jdbc":
                return UserDAOJDBC.getImplementation();
            default:
                return null;
        }
    }

    public static CommentDAO getCommentDAO(String mechanismOfPersistence) {
        switch (mechanismOfPersistence) {
            case "file":
                return CommentDAOFile.getImplementation();
            case "jdbc":
                return CommentDAOJDBC.getImplementation();
            default:
                return null;
        }
    }
}
