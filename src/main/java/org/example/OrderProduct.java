package org.example;

public class OrderProduct {
    private String id;
    private int quantity;

    public OrderProduct(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getProductId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
