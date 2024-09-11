package org.example;

import java.util.List;

public class ShopService {
    private OrderListRepo orderListRepo;
    private ProductRepo productRepo;

    public ShopService(OrderListRepo orderListRepo, ProductRepo productRepo) {
        this.orderListRepo = orderListRepo;
        this.productRepo = productRepo;
    }

    public void placeOrder(String orderId, List<OrderProduct> orderProducts) {
        ProductRepo orderedProducts = new ProductRepo();
        double totalPrice = 0;

        for(OrderProduct orderProduct : orderProducts) {
            Product orderedProduct = productRepo.getProduct(orderProduct.getProductId());
            int orderedProductQuantity = orderProduct.getQuantity();
            if(orderedProduct == null) {
                System.out.println("No such product");
            } else {
                orderedProducts.addProduct(orderedProduct);
                totalPrice += orderedProduct.price() * orderedProductQuantity;;
            }
        }


        Order newOrder = new Order(orderId, orderedProducts, totalPrice);
        orderListRepo.addOrder(newOrder);

        orderListRepo.printOrders();
    }
}
