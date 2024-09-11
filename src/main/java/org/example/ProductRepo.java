package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(String id) {
        for (Product product : products) {
            if(product.id().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

}
