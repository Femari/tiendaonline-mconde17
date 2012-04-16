package Model;

public class User {

    private String userName;
    private String userSurnames;
    private String userAdress;
    private String userEmail;
    private String userPassword;
    private boolean userPrivileged;

    public User(String name, String surnames, String adress, String email, String password) {
        userName = name;
        userSurnames = surnames;
        userAdress = adress;
        userEmail = email;
        userPassword = password;
        userPrivileged = false;
    }

    public User(String name, String surnames, String adress, String email, String password,
            boolean privileged) {
        userName = name;
        userSurnames = surnames;
        userAdress = adress;
        userEmail = email;
        userPassword = password;
        userPrivileged = privileged;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getName() {
        return this.userName;
    }

    public void setSurnames(String surnames) {
        this.userSurnames = surnames;
    }

    public String getSurnames() {
        return this.userSurnames;
    }

    public void setAdress(String adress) {
        this.userAdress = adress;
    }

    public String getAdress() {
        return this.userAdress;
    }

    public void setEmail(String email) {
        this.userEmail = email;
    }

    public String getEmail() {
        return this.userEmail;
    }

    public void setPassword(String password) {
        this.userPassword = password;
    }

    public String getPassword() {
        return this.userPassword;
    }

    public void setPrivileged(boolean privileged) {
        this.userPrivileged = privileged;
    }

    public boolean getPrivileged() {
        return this.userPrivileged;
    }
}
