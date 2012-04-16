package Model;

public class Sale {

    private int saleID;
    private User client;
    private ShoppingCart cart;
    private String paymentMethod;
    private String date;

    public Sale(int id, User clientSale, ShoppingCart trolley, String payment, String shoppingDate) {
        saleID = id;
        client = clientSale;
        cart = trolley;
        paymentMethod = payment;
        date = shoppingDate;
    }

    public int getID() {
        return this.saleID;
    }

    public void setID(int id) {
        this.saleID = id;
    }

    public User getClient() {
        return this.client;
    }

    public void setClient(User clientSale) {
        this.client = clientSale;
    }

    public ShoppingCart getShoppingCart() {
        return this.cart;
    }

    public void setShoppingCart(ShoppingCart trolley) {
        this.cart = trolley;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String payment) {
        this.paymentMethod = payment;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String shoppingDate) {
        this.date = shoppingDate;
    }

    public void generateSaleInvoiceFile() {
    }
}
