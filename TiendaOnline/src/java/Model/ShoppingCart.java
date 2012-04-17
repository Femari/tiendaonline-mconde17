package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {

    private ArrayList<Product> shoppingCart;

    public ShoppingCart(ArrayList<Product> cart) {
        shoppingCart = cart;
    }

    public ArrayList<Product> getShoppingCart() {
        return this.shoppingCart;
    }

    public int getNumberOfProducts() {
        return this.shoppingCart.size();
    }

    public void addProduct(Product product) {
        this.shoppingCart.add(product);
    }

    public void removeProduct(Product product, int amount) {
        this.shoppingCart.remove(product);
    }

    public float getPriceOfShoppingCart() {
        float total = 0;
        Product p;
        Iterator it = shoppingCart.iterator();
        while (it.hasNext()) {
            p = (Product) it.next();
            total = total + p.getProductPrice();
        }
        return total;
    }
}
