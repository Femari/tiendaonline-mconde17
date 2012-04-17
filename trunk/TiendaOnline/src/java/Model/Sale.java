package Model;

public class Sale {

    private String saleID;
    private User saleClient;
    private ShoppingCart saleCart;
    private String salePaymentMethod;
    private String saleDate;

    public Sale(String id, User client, ShoppingCart cart, String paymentMethod, String shoppingDate) {
        saleID = id;
        saleClient = client;
        saleCart = cart;
        salePaymentMethod = paymentMethod;
        saleDate = shoppingDate;
    }

    public String getSaleID() {
        return this.saleID;
    }

    public void setSaleID(String id) {
        this.saleID = id;
    }

    public User getSaleClient() {
        return this.saleClient;
    }

    public void setSaleClient(User client) {
        this.saleClient = client;
    }

    public ShoppingCart getSaleShoppingCart() {
        return this.saleCart;
    }

    public void setSaleShoppingCart(ShoppingCart cart) {
        this.saleCart = cart;
    }

    public String getSalePaymentMethod() {
        return this.salePaymentMethod;
    }

    public void setSalePaymentMethod(String paymentMethod) {
        this.salePaymentMethod = paymentMethod;
    }

    public String getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(String shoppingDate) {
        this.saleDate = shoppingDate;
    }

    public void generateSaleInvoiceFile() {
    }

    public boolean isEquals(String parameter, String condition) {
        boolean equals = false;
        switch (parameter) {
            case "saleID":
                if (this.saleID.equals(condition)) {
                    equals = true;
                }
                break;
            case "saleClient":
                if (this.saleClient.getUserEmail().equals(condition)) {
                    equals = true;
                }
                break;
            case "salePaymentMethod":
                if (this.salePaymentMethod.equals(condition)) {
                    equals = true;
                }
                break;
            case "saleDate":
                if (this.saleDate.equals(condition)) {
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
