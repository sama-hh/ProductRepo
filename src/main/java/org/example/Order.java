package org.example;

public record Order(String id, ProductRepo orderedProducts, double totalPrice) {
}
