package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        CSVLoader.loadProductsFromCSV("src/main/java/org/example/data", productRepo);
        productRepo.printProducts();

        //
        OrderListRepo orderListRepo = new OrderListRepo();
        OrderProduct orderedProduct1 = new OrderProduct("1", 1);
        OrderProduct orderedProduct2 = new OrderProduct("5", 2);
        orderedProduct2.setQuantity(3);

        System.out.println("orderedProduct2 quantity = " + orderedProduct2.getQuantity());

        //
        ShopService shopService = new ShopService(orderListRepo, productRepo);
        shopService.placeOrder("1" , Arrays.asList(orderedProduct1, orderedProduct2));

        //
        Scanner scanner = new Scanner(System.in);
        String GREEN = "\033[32m";
        String RESET = "\033[0m";
        String CYAN = "\033[36m";

        System.out.println(GREEN + "Starting order" + RESET);
        System.out.print(CYAN + "Enter product id: " + RESET );
        String productId = scanner.nextLine();
        System.out.print(CYAN + "Enter quantity: " + RESET);
        int quantity = scanner.nextInt();
        scanner.nextLine();

        OrderProduct orderedProduct3 = new OrderProduct(productId, quantity);
        shopService.placeOrder("2", List.of(orderedProduct3));

        System.out.println(GREEN + "Starting order" + RESET);
        System.out.print(CYAN + "Enter product id: " + RESET );
        String productId2 = scanner.nextLine();
        System.out.print(CYAN + "Enter quantity: " + RESET);
        int quantity2 = scanner.nextInt();
        scanner.nextLine();

        OrderProduct orderedProduct4 = new OrderProduct(productId2, quantity2);
        shopService.placeOrder("3", List.of(orderedProduct4));

        scanner.close();
    }
}