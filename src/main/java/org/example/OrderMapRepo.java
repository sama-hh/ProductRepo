package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {
   private Map<String, Order> ordersMap;

    public OrderMapRepo() {
        this.ordersMap = new HashMap<>();
    }

    @Override
    public void addOrder(Order order) {
        ordersMap.put(order.id(), order);
    }

    @Override
    public List<Order> getAllOrders() {
        return List.copyOf(ordersMap.values());
    }

    @Override
    public Order getOrder(String id) {
        return ordersMap.get(id);
    }

    @Override
    public void removeOrder(String id) {
        ordersMap.remove(id);
    }
}
