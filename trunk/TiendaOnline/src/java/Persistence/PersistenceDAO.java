package Persistence;

public class PersistenceDAO {

    public static ProductDAO getProductDAO(String mechanismOfPersistence) {
        if (mechanismOfPersistence.equals("file")) {
            return ProductDAOFile.getImplementation();
        } else if (mechanismOfPersistence.equals("jdbc")) {
            return ProductDAOJDBC.getImplementation();
        } else {
            return null;
        }
    }

    public static SaleDAO getSaleDAO(String mechanismOfPersistence) {
        if (mechanismOfPersistence.equals("file")) {
            return SaleDAOFile.getImplementation();
        } else if (mechanismOfPersistence.equals("jdbc")) {
            return SaleDAOJDBC.getImplementation();
        } else {
            return null;
        }
    }

    public static UserDAO getUserDAO(String mechanismOfPersistence) {
        if (mechanismOfPersistence.equals("file")) {
            return UserDAOFile.getImplementation();
        } else if (mechanismOfPersistence.equals("jdbc")) {
            return UserDAOJDBC.getImplementation();
        } else {
            return null;
        }
    }
    
    public static CommentDAO getCommentDAO(String mechanismOfPersistence){
        if (mechanismOfPersistence.equals("file")) {
            return CommentDAOFile.getImplementation();
        } else if (mechanismOfPersistence.equals("jdbc")) {
            return CommentDAOJDBC.getImplementation();
        } else {
            return null;
        }
    }
}
