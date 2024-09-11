package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String GREEN = "\033[32m";
        String RESET = "\033[0m";
        String CYAN = "\033[36m";

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

        System.out.println(GREEN + "Starting order" + RESET);
        System.out.print(CYAN + "Enter product id: " + RESET );
        String productId = scanner.nextLine();
        System.out.print(CYAN + "Enter quantity: " + RESET);
        int quantity = scanner.nextInt();

        OrderProduct orderedProduct3 = new OrderProduct(productId, quantity);
        shopService.placeOrder("2", List.of(orderedProduct3));

    }
}