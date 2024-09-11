package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductRepoTest {

    @Test
    void test_addAndGetProduct() {
        ProductRepo productRepo = new ProductRepo();
        Product product = new Product("1", "Banana", 10);
        productRepo.addProduct(product);

        Product result = productRepo.getProduct("1");
        assertThat(result).isEqualTo(product);
    }

    @Test
    void test_getAllProducts() {
        ProductRepo productRepo = new ProductRepo();
        Product product1 = new Product("1", "Banana", 10);
        Product product2 = new Product("2", "Apple", 3);
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);

        List<Product> result = productRepo.getAllProducts();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void test_removeProduct() {
        ProductRepo productRepo = new ProductRepo();
        Product product1 = new Product("1", "Banana", 10);
        Product product2 = new Product("2", "Apple", 3);
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        productRepo.removeProduct(product1);
        List<Product> result = productRepo.getAllProducts();
        assertThat(result.size()).isEqualTo(1);
    }
}