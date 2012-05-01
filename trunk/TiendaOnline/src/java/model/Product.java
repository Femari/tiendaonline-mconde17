package model;

import java.sql.Blob;

public class Product {

    private String productID;
    private float productPrice;
    private String productShortDescription;
    private String productLongDescription;
    private int productStock;
    private Blob productImage;

    public Product(String nameID, float price, String shortDescription, String longDescription,
            int stock, Blob image) {
        productID = nameID;
        productPrice = price;
        productShortDescription = shortDescription;
        productLongDescription = longDescription;
        productStock = stock;
        productImage = image;
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

    public void setProductImage(Blob image) {
        this.productImage = image;
    }

    public Blob getProductImage() {
        return this.productImage;
    }

    public String generateProductID() {
        String id;
        id = java.util.UUID.randomUUID().toString().substring(0, 29);
        return id;
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
