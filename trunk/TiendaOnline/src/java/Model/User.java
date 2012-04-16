package Model;

public class User {

    private String name;
    private String surnames;
    private String adress;
    private String email;
    private String password;
    private boolean privileged;

    public User(String userName, String userSurnames, String userAdress, String userEmail, String userPassword) {
        name = userName;
        surnames = userSurnames;
        adress = userAdress;
        email = userEmail;
        password = userPassword;
        privileged = false;
    }

    public User(String userName, String userSurnames, String userAdress, String userEmail, String userPassword,
            boolean userPrivileged) {
        name = userName;
        surnames = userSurnames;
        adress = userAdress;
        email = userEmail;
        password = userPassword;
        privileged = userPrivileged;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getName() {
        return this.name;
    }

    public void setSurnames(String userSurnames) {
        this.surnames = userSurnames;
    }

    public String getSurnames() {
        return this.surnames;
    }

    public void setAdress(String userAdress) {
        this.adress = userAdress;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setEmail(String userEmail) {
        this.email = userEmail;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPrivileged(boolean userPrivileged) {
        this.privileged = userPrivileged;
    }

    public boolean getPrivileged() {
        return this.privileged;
    }
}
