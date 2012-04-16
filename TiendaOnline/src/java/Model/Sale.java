package Model;

public class Sale {

    private int saleID;
    private User saleClient;
    private ShoppingCart saleCart;
    private String salePaymentMethod;
    private String saleDate;

    public Sale(int id, User client, ShoppingCart cart, String paymentMethod, String shoppingDate) {
        saleID = id;
        saleClient = client;
        saleCart = cart;
        salePaymentMethod = paymentMethod;
        saleDate = shoppingDate;
    }

    public int getID() {
        return this.saleID;
    }

    public void setID(int id) {
        this.saleID = id;
    }

    public User getClient() {
        return this.saleClient;
    }

    public void setClient(User client) {
        this.saleClient = client;
    }

    public ShoppingCart getShoppingCart() {
        return this.saleCart;
    }

    public void setShoppingCart(ShoppingCart cart) {
        this.saleCart = cart;
    }

    public String getPaymentMethod() {
        return this.salePaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.salePaymentMethod = paymentMethod;
    }

    public String getDate() {
        return this.saleDate;
    }

    public void setDate(String shoppingDate) {
        this.saleDate = shoppingDate;
    }

    public void generateSaleInvoiceFile() {
    }
}
