package Model;

public class Product {

    private String productID;
    private float productPrice;
    private String productShortDescription;
    private String productLongDescription;
    private int productStock;

    public Product(String nameID, float price, String shortDescription, String longDescription,
            int stock) {
        productID = nameID;
        productPrice = price;
        productShortDescription = shortDescription;
        productLongDescription = longDescription;
        productStock = stock;
    }

    public void setNameID(String nameID) {
        this.productID = nameID;
    }

    public String getNameID() {
        return this.productID;
    }

    public void setPrice(float price) {
        this.productPrice = price;
    }

    public float getPrice() {
        return this.productPrice;
    }

    public void setShortDescription(String shortDescription) {
        this.productShortDescription = shortDescription;
    }

    public String getShortDescription() {
        return this.productShortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.productLongDescription = longDescription;
    }

    public String getLongDescription() {
        return this.productLongDescription;
    }

    public void setStock(int stock) {
        this.productStock = stock;
    }

    public int getStock() {
        return this.productStock;
    }
}
