package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart implements Serializable {

    private ArrayList<Product> shoppingCart;

    public ShoppingCart(ArrayList<Product> cart) {
        shoppingCart = cart;
    }

    public ShoppingCart() {
        shoppingCart = new ArrayList<>();
    }

    public ArrayList<Product> getShoppingCart() {
        return this.shoppingCart;
    }

    public int getNumberOfProducts() {
        return this.getShoppingCart().size();
    }

    public int getNumberOfProducts(Product product) {
        int numberOfProducts = 0;
        ArrayList<Product> cart = this.getShoppingCart();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(product)) {
                numberOfProducts++;
            }
        }
        return numberOfProducts;
    }

    public void addProduct(Product product) {
        this.shoppingCart.add(product);
    }

    public void removeProduct(Product product, int amount) {
        this.shoppingCart.remove(product);
    }

    public double getPriceOfShoppingCart() {
        double total = 0;
        Product p;
        Iterator it = shoppingCart.iterator();
        while (it.hasNext()) {
            p = (Product) it.next();
            total = total + p.getProductPrice();
        }
        return total;
    }

    public String listShoppingCart() {
        String shop = new String();
        Iterator it = shoppingCart.iterator();
        while (it.hasNext()) {
            Product p = (Product) it.next();
            shop = shop + "Producto: " + p.getProductShortDescription() + " Precio: " + p.getProductPrice() + "€\n";
        }
        return shop;
    }
}
