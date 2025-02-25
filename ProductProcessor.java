import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }                               //Selim Jahangir 22bcs13878

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.99),
            new Product("Smartphone", "Electronics", 899.49),
            new Product("TV", "Electronics", 1500.00),
            new Product("Sofa", "Furniture", 750.75),
            new Product("Table", "Furniture", 299.99),
            new Product("Chair", "Furniture", 120.50)
        );

        // Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        
        System.out.println("Products grouped by category: " + productsByCategory);

        // Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));
        
        System.out.println("Most expensive product in each category: " + mostExpensiveByCategory);

        // Calculate the average price of all products
        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);
        
        System.out.println("Average price of all products: $" + averagePrice);
    }
}