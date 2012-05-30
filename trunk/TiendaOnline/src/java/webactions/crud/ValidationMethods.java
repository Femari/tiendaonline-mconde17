package webactions.crud;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Comment;
import model.Product;
import model.User;

public class ValidationMethods {

    User userValidate;
    Product productValidate;
    Comment commentValidate;

    public ValidationMethods(User user) {
        userValidate = user;
    }

    public ValidationMethods(Product product) {
        productValidate = product;
    }

    public ValidationMethods(Comment comment) {
        commentValidate = comment;
    }

    /*
     * User Validation Methods:
     */
    private boolean validateName(String userName) {
        String namePattern = "[A-Z]([a-zA-ZñÑáéíóúÁÉÍÓÚ ])*";
        if (userName.matches(namePattern) && checkLength(userName, 0, 30) && checkXSS(userName)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateSurnames(String userSurnames) {
        String namePattern = "[A-Z]([a-zA-ZñÑáéíóúÁÉÍÓÚ ])*";
        if (userSurnames.matches(namePattern) && checkLength(userSurnames, 0, 120) && checkXSS(userSurnames)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateAdress(String userAdress) {
        if (checkLength(userAdress, 0, 240) && checkXSS(userAdress)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateEmail(String userEmail) {
        String emailPattern =
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(userEmail);
        if (matcher.matches() && checkLength(userEmail, 0, 60) && checkXSS(userEmail)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validatePassword(String userPassword) {
        if (checkLength(userPassword, 0, 30) && checkXSS(userPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateUser() {
        if (validateName(userValidate.getUserName())
                && validateSurnames(userValidate.getUserSurnames())
                && validateAdress(userValidate.getUserAdress())
                && validateEmail(userValidate.getUserEmail())
                && validatePassword(userValidate.getUserPassword())) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Product Validation Methods:
     */
    private boolean validatePrice(double productPrice) {
        if (productPrice > 0 && productPrice < 1000000) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateShortDescription(String productShortDescription) {
        if (checkLength(productShortDescription, 0, 60) && checkXSS(productShortDescription)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateLongDescription(String productLongDescription) {
        if (checkLength(productLongDescription, 0, 600) && checkXSS(productLongDescription)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateStock(int productStock) {
        if (productStock >= 0 && productStock <= 1000000) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateProduct() {
        if (validatePrice(productValidate.getProductPrice())
                && validateShortDescription(productValidate.getProductShortDescription())
                && validateLongDescription(productValidate.getProductLongDescription())
                && validateStock(productValidate.getProductStock())) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Comment Validation Methods:
     */
    private boolean validateContent(String commentContent) {
        if (checkLength(commentContent, 0, 600) && checkXSS(commentContent)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateComment() {
        if (validateContent(commentValidate.getCommentContent())) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Other Validation Methods:
     */
    private boolean checkLength(String data, int minLength, int maxLength) {
        int length = data.length();
        boolean isGoodLength = length > minLength && length < maxLength;
        return isGoodLength;
    }

    //@Abraham insisto en que yo hubiese puesto un filtro para mirar eso, por si acaso me despistó y no lo compruebo en alguna ocasión
    private boolean checkXSS(String data) {
        if (data.contains("<") || data.contains(">")) {
            return false;
        } else {
            return true;
        }
    }
}
