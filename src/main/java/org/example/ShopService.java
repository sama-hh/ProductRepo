package org.example;

import java.util.List;

public class ShopService {
    private OrderListRepo orderListRepo;
    private ProductRepo productRepo;

    public ShopService(OrderListRepo orderListRepo, ProductRepo productRepo) {
        this.orderListRepo = orderListRepo;
        this.productRepo = productRepo;
    }

    public void placeOrder(String orderId, List<String> productIds) {
        ProductRepo orderedProducts = new ProductRepo();

        for(String productId : productIds) {
            if(productRepo.getProduct(productId) == null) {
                System.out.println("No such product");
            } else {
                orderedProducts.addProduct(productRepo.getProduct(productId));
            }
        }

        Order newOrder = new Order(orderId, orderedProducts);
        orderListRepo.addOrder(newOrder);

        orderListRepo.printOrders();
        System.out.println("------");
        productRepo.printProducts();

    }
}
