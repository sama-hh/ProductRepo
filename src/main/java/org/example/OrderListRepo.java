package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo {
    private List<Order> orders;

    public OrderListRepo() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrder(String id) {
        for (Order order : orders) {
            if(order.id().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void printOrders() {
        for (Order order : orders) {
            System.out.println("Order id=" + order.id() + ", " + order.orderedProducts().getAllProducts());
        }
    }

}
