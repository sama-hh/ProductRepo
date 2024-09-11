package org.example;

import java.util.List;

public interface OrderRepo {
    void addOrder(Order order);

    List<Order> getAllOrders();

    Order getOrder(String id);

    void removeOrder(String id);
}
