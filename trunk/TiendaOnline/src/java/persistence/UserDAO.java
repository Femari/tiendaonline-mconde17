package persistence;

import java.util.Map;
import model.User;

public interface UserDAO extends PersistenceManager {

    @Override
    public boolean newUser(User user);

    @Override
    public boolean deleteUser(User user);

    @Override
    public boolean updateUser(User oldUser, User newUser);

    @Override
    public boolean userAuthentication(String userEmail, String userPass);

    @Override
    public User getUser(String userEmail);

    @Override
    public Map<String, User> getUserMap();

    @Override
    public Map<String, User> getUserMap(String parameter, String condition);

    @Override
    public boolean connection(String user, String pass, String destiny, String driver);

    @Override
    public boolean disconnect();
}
