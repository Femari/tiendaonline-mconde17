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

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserSurnames(String surnames) {
        this.userSurnames = surnames;
    }

    public String getUserSurnames() {
        return this.userSurnames;
    }

    public void setUserAdress(String adress) {
        this.userAdress = adress;
    }

    public String getUserAdress() {
        return this.userAdress;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPrivileged(boolean privileged) {
        this.userPrivileged = privileged;
    }

    public boolean getUserPrivileged() {
        return this.userPrivileged;
    }

    public boolean isEquals(String parameter, String condition) {
        boolean equals = false;
        switch (parameter) {
            case "userName":
                if (this.userName.equals(condition)) {
                    equals = true;
                }
                break;
            case "userSurnames":
                if (this.userSurnames.equals(condition)) {
                    equals = true;
                }
                break;
            case "userAdress":
                if (this.userAdress.equals(condition)) {
                    equals = true;
                }
                break;
            case "userEmail":
                if (this.userEmail.equals(condition)) {
                    equals = true;
                }
                break;
            case "userPassword":
                if (this.userPassword.equals(condition)) {
                    equals = true;
                }
                break;
            case "userPrivileged":
                boolean privileged = false;
                if (condition.equals("true")) {
                    privileged = true;
                }
                if (this.userPrivileged == privileged) {
                    equals = true;
                }
                break;
            default:
                equals = false;
                break;
        }
        return equals;
    }
}
