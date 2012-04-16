package Model;

public class Product {

    private String nameID;
    private float price;
    private String shortDescription;
    private String longDescription;
    private int stock;

    public Product(String id, float productPrice, String shortProductDescription, String longProductDescription,
            int productStock) {
        nameID = id;
        price = productPrice;
        shortDescription = shortProductDescription;
        longDescription = longProductDescription;
        stock = productStock;
    }

    public void setNameID(String id) {
        this.nameID = id;
    }

    public String getNameID() {
        return this.nameID;
    }

    public void setPrice(float productPrice) {
        this.price = productPrice;
    }

    public float getPrice() {
        return this.price;
    }

    public void setShortDescription(String shortProductDescription) {
        this.shortDescription = shortProductDescription;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setLongDescription(String longProductDescription) {
        this.longDescription = longProductDescription;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public void setStock(int productStock) {
        this.stock = productStock;
    }

    public int getStock() {
        return this.stock;
    }
}
