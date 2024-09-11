package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("1", "Apple", 10);
        Product product2 = new Product("2", "Banana",7);
        Product product3 = new Product("3", "Grape", 12);

        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        productRepo.addProduct(product3);

        OrderListRepo orderListRepo = new OrderListRepo();

        OrderProduct orderedProduct1 = new OrderProduct("1", 1);
        OrderProduct orderedProduct2 = new OrderProduct("2", 2);
        orderedProduct2.setQuantity(3);
        System.out.println("orderedProduct2 quantity = " + orderedProduct2.getQuantity());

        ShopService shopService = new ShopService(orderListRepo, productRepo);
        shopService.placeOrder("1" , Arrays.asList(orderedProduct1, orderedProduct2));
    }
}