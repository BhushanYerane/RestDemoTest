package EcomTest;

import java.util.List;

public class OrderRequest {
    private List<Order> orders;

    // Constructors
    public OrderRequest(List<Order> orders) {
        this.orders = orders;
    }

    // Getters and Setters
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

