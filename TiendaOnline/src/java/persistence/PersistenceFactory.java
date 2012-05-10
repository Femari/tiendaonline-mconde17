package persistence;

public class PersistenceFactory {

    public static ProductDAO getProductDAO(String persistenceMechanism) {
        switch (persistenceMechanism) {
            case "file":
                return ProductDAOFile.getInstance();
            case "jdbc":
                return ProductDAOJDBC.getInstance();
            default:
                return null;
        }
    }

    public static SaleDAO getSaleDAO(String persistenceMechanism) {
        switch (persistenceMechanism) {
            case "file":
                return SaleDAOFile.getInstance();
            case "jdbc":
                return SaleDAOJDBC.getInstance();
            default:
                return null;
        }
    }

    public static UserDAO getUserDAO(String persistenceMechanism) {
        switch (persistenceMechanism) {
            case "file":
                return UserDAOFile.getInstance();
            case "jdbc":
                return UserDAOJDBC.getInstance();
            default:
                return null;
        }
    }

    public static CommentDAO getCommentDAO(String persistenceMechanism) {
        switch (persistenceMechanism) {
            case "file":
                return CommentDAOFile.getInstance();
            case "jdbc":
                return CommentDAOJDBC.getInstance();
            default:
                return null;
        }
    }
}
