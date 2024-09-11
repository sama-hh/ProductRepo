package org.example;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVLoader {
    public static void loadProductsFromCSV(String filePath, ProductRepo productRepo) {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();
            for (int i = 1; i < records.size(); i++) { // Skip header row
                String[] record = records.get(i);
                String id = record[0];
                String name = record[1];
                double price = Double.parseDouble(record[2]);

                Product product = new Product(id, name, price);
                productRepo.addProduct(product);
            }
            System.out.println("Products loaded from CSV successfully.");
        } catch (IOException | CsvException e) {
            System.out.println("Error loading products from CSV: " + e.getMessage());
        }
    }

}
