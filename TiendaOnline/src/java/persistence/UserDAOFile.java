package persistence;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDAOFile implements UserDAO {

    private Map<String, User> userMap = new HashMap<>();
    private String userFile;
    private static UserDAOFile mechanismOfPersistence = null;
    private static final Logger log = Logger.getLogger(UserDAOFile.class.getName());

    public UserDAOFile() {
    }

    public static UserDAO getInstance() {
        if (mechanismOfPersistence == null) {
            mechanismOfPersistence = new UserDAOFile();
        }
        return mechanismOfPersistence;
    }

    @Override
    public synchronized boolean newUser(User user) {
        if (getUserMap().containsKey(user.getUserEmail())) {
            return false;
        } else {
            getUserMap().put(user.getUserEmail(), user);
            return true;
        }
    }

    @Override
    public synchronized boolean deleteUser(User user) {
        if (getUserMap().containsKey(user.getUserEmail())) {
            getUserMap().remove(user.getUserEmail());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized boolean updateUser(User oldUser, User newUser) {
        if (getUserMap().containsKey(oldUser.getUserEmail())) {
            getUserMap().put(oldUser.getUserEmail(), newUser);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean userAuthentication(String userEmail, String userPass) {
        boolean response = false;
        if (userEmail != null && userPass != null) {
            if (getUserMap().containsKey(userEmail)) {
                User u = getUser(userEmail);
                if (u.getUserPassword().equals(userPass)) {
                    response = true;
                }
            }
        }
        return response;
    }

    @Override
    public synchronized User getUser(String userEmail) {
        return getUserMap().get(userEmail);
    }

    @Override
    public Map<String, User> getUserMap() {
        return userMap;
    }

    @Override
    public Map<String, User> getUserMap(String parameter, String condition) {
        Map<String, User> resultMap = new HashMap<>(getUserMap());
        Iterator it = getUserMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            User u = (User) e.getValue();
            if (u.isEquals(parameter, condition)) {
                resultMap.put(u.getUserEmail(), u);
            }
        }
        return resultMap;
    }

    @Override
    public boolean connection(String user, String pass, String destiny, String driver) {
        this.userFile = destiny + "users";
        File f = new File(this.userFile);
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            if (f.exists() && f.isFile() && f.length() > 0) {
                is = new FileInputStream(f);
                ois = new ObjectInputStream(is);
                int numberOfUsers = (Integer) ois.readObject();
                for (int i = 0; i < numberOfUsers; i++) {
                    User u = (User) ois.readObject();
                    getUserMap().put(u.getUserEmail(), u);
                }
            } else {
                if (f.createNewFile()) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | IOException ex) {
            log.log(Level.WARNING, "No se pudo crear la Conexion correctamente", ex);
            return false;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex2);
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex3) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex3);
            }
        }
        return true;
    }

    @Override
    public boolean disconnect() {
        File f = new File(this.userFile);
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            if (f.exists() && f.isFile()) {
                os = new FileOutputStream(f);
                oos = new ObjectOutputStream(os);
                int mapSize = getUserMap().size();
                oos.writeObject(mapSize);
                Iterator it = getUserMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry e = (Map.Entry) it.next();
                    User u = (User) e.getValue();
                    oos.writeObject(u);
                }
            }
        } catch (IOException ex) {
            log.log(Level.WARNING, "No se pudo realizar la Desconexión de forma correcta", ex);
            return false;
        } finally {
            try {
                oos.close();
            } catch (IOException ex2) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex2);
            }
            try {
                os.close();
            } catch (IOException ex3) {
                log.log(Level.INFO, "No se pudo cerrar el fichero correctamente", ex3);
            }
        }
        return true;
    }
}
