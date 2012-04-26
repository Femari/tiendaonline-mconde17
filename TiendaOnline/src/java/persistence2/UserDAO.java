package persistence2;

import model2.User;
import java.util.Map;

public interface UserDAO {

    public boolean newUser(User user);

    public boolean deleteUser(User user);

    public boolean updateUser(User oldUser, User newUser);

    public String userAuthentication(String userEmail, String userPass);

    public User getUser(String userEmail);

    public Map<String, User> getUserMap();

    public Map<String, User> getUserMap(String parameter, String condition);

    public boolean connection(String user, String pass, String destiny, String driver);

    public boolean disconnect();
}
