package Persistence;

import Model.User;

public interface UserDAO {

    public boolean newUser(User user);

    public boolean deleteUser(User user);

    public boolean updateUser(User oldUser, User newUser);

    public boolean userAuthentication(String userName, String userPass);

}
