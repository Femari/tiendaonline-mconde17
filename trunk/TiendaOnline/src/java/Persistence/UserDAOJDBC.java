package Persistence;

import Model.User;

public class UserDAOJDBC implements UserDAO {

    @Override
    public boolean newUser(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteUser(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateUser(User oldUser, User newUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean userAuthentication(String userName, String userPass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static UserDAO getImplementation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
