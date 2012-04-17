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

    public void setProductID(String nameID) {
        this.productID = nameID;
    }

    public String getProductID() {
        return this.productID;
    }

    public void setProductPrice(float price) {
        this.productPrice = price;
    }

    public float getProductPrice() {
        return this.productPrice;
    }

    public void setProductShortDescription(String shortDescription) {
        this.productShortDescription = shortDescription;
    }

    public String getProductShortDescription() {
        return this.productShortDescription;
    }

    public void setProductLongDescription(String longDescription) {
        this.productLongDescription = longDescription;
    }

    public String getProductLongDescription() {
        return this.productLongDescription;
    }

    public void setProductStock(int stock) {
        this.productStock = stock;
    }

    public int getProductStock() {
        return this.productStock;
    }

    public boolean isEquals(String parameter, String condition) {
        boolean equals = false;
        switch (parameter) {
            case "productID":
                if (this.productID.equals(condition)) {
                    equals = true;
                }
                break;
            case "productPrice":
                if (this.productPrice == Float.parseFloat(condition)) {
                    equals = true;
                }
                break;
            case "productShortDescription":
                if (this.productShortDescription.equals(condition)) {
                    equals = true;
                }
                break;
            case "productLongDescription":
                if (this.productLongDescription.equals(condition)) {
                    equals = true;
                }
                break;
            case "producStock":
                if (this.productStock == Integer.parseInt(condition)) {
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
