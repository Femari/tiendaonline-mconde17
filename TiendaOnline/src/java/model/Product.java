package model;

import java.io.Serializable;

public class Product implements Serializable {

    private String productID;
    private double productPrice;
    private String productShortDescription;
    private String productLongDescription;
    private int productStock;
    private String productImageURL;

    public Product(String nameID, double price, String shortDescription, String longDescription,
            int stock, String imageURL) {
        productID = nameID;
        productPrice = price;
        productShortDescription = shortDescription;
        productLongDescription = longDescription;
        productStock = stock;
        productImageURL = imageURL;
    }

    public void setProductID(String nameID) {
        this.productID = nameID;
    }

    public String getProductID() {
        return this.productID;
    }

    public void setProductPrice(double price) {
        this.productPrice = price;
    }

    public double getProductPrice() {
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

    public void setProductImageURL(String imageURL) {
        this.productImageURL = imageURL;
    }

    public String getProductImageURL() {
        return this.productImageURL;
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
                if (this.productPrice == Double.parseDouble(condition)) {
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
