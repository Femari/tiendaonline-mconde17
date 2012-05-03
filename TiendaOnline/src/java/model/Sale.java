package model;

import java.io.*;

public class Sale implements Serializable {

    private String saleID;
    private User saleClient;
    private ShoppingCart saleCart;
    private String salePaymentMethod;
    private String saleAdress;
    private String saleDate;

    public Sale(String id, User client, ShoppingCart cart, String paymentMethod, String adress,
            String shoppingDate) {
        saleID = id;
        saleClient = client;
        saleCart = cart;
        salePaymentMethod = paymentMethod;
        saleAdress = adress;
        saleDate = shoppingDate;
    }

    public Sale() {
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

    public String getSaleAdress() {
        return this.saleAdress;
    }

    public void setSaleAdress(String adress) {
        this.saleAdress = adress;
    }

    public String getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(String shoppingDate) {
        this.saleDate = shoppingDate;
    }

    public String generateSaleID() {
        String id;
        id = java.util.UUID.randomUUID().toString().substring(0, 29);
        return id;
    }

    public void generateSaleInvoiceFile(Sale s) {
        String saleFileName = "/web/" + s.getSaleClient().getUserEmail() + "_" + s.getSaleID() + ".txt";
        File saleFile = new File(saleFileName);
        FileWriter fw = null;
        PrintWriter pw = null;
        if (!saleFile.exists()) {
            try {
                fw = new FileWriter(saleFile);
                pw = new PrintWriter(fw);
                pw.println("Identificador de la Compra: " + s.getSaleID());
                pw.println("Nombre Completo del Cliente: " + s.getSaleClient().getUserName() + " "
                        + s.getSaleClient().getUserSurnames());
                pw.println("Dirección de Envío: " + s.getSaleAdress());
                pw.println("Forma de Pago: " + s.getSalePaymentMethod());
                pw.println("\n\nLista de Productos\n\n");
                ShoppingCart cart = s.getSaleShoppingCart();
                for (int i = 0; i < cart.getNumberOfProducts(); i++) {
                    String productName = cart.getShoppingCart().get(i).getProductShortDescription();
                    float productPrice = cart.getShoppingCart().get(i).getProductPrice();
                    pw.println(productName + " " + productPrice + "€" + "\n");
                }
                pw.println("Gracias por su compra. Esperemos que la disfrute.");
                pw.println("Para cualquier duda: Consúltenos. ¡¡¡Le atenderemos encantados!!!");
            } catch (IOException ex) {
            } finally {
                if (pw != null) {
                    pw.close();
                }
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }
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
