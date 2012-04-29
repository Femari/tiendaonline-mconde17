package persistence;

public class PersistenceDAO {

    public static ProductDAO getProductDAO(String persistenceMechanism) {
        switch (persistenceMechanism) {
            case "file":
                return ProductDAOFile.getImplementation();
            case "jdbc":
                return ProductDAOJDBC.getImplementation();
            default:
                return null;
        }
    }

    public static SaleDAO getSaleDAO(String persistenceMechanism) {
        switch (persistenceMechanism) {
            case "file":
                return SaleDAOFile.getImplementation();
            case "jdbc":
                return SaleDAOJDBC.getImplementation();
            default:
                return null;
        }
    }

    public static UserDAO getUserDAO(String persistenceMechanism) {
        switch (persistenceMechanism) {
            case "file":
                return UserDAOFile.getImplementation();
            case "jdbc":
                return UserDAOJDBC.getImplementation();
            default:
                return null;
        }
    }

    public static CommentDAO getCommentDAO(String persistenceMechanism) {
        switch (persistenceMechanism) {
            case "file":
                return CommentDAOFile.getImplementation();
            case "jdbc":
                return CommentDAOJDBC.getImplementation();
            default:
                return null;
        }
    }
}
