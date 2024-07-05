package coreJavaz.oopz;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public void displayCart() {
        for (Product product : cartItems) {
            System.out.println(product);
        }
    }
}
