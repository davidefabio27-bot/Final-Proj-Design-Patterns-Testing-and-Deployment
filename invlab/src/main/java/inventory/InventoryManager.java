package inventory;

import java.util.*;

/**
 * Main business logic class that manages inventory operations.
 * TODO: Implement inventory management using Factory and Strategy patterns.
 *
 * Requirements:
 * - Use ProductFactory for creating products
 * - Use DiscountCalculator for sales with discounts
 * - Maintain product collection
 * - Provide inventory operations and statistics
 */
public class InventoryManager {

    // TODO: Declare collection to store products
    // private Map<String, Product> products;
    private Map<String, Product> products;
    /**
     * TODO: Implement constructor
     */
    public InventoryManager() {
        // TODO: Initialize the products collection
        this.products = new HashMap<>();
    }

    /**
     * TODO: Add product to inventory using Factory pattern
     * @param id - product identifier
     * @param name - product name
     * @param type - product type
     * @param price - product price
     * @param quantity - initial quantity
     */
    public void addProduct(String id, String name, String type, double price, int quantity) {
        // TODO: Implement product addition
        // Use ProductFactory.createProduct()
        // Handle exceptions and display appropriate messages
        // Add product to collection if successful
    try {
        Product product = ProductFactory.createProduct(id, name, type, price, quantity);
        products.put(id, product);
        System.out.println("product added successfully: " + product);
    } catch (IllegalArgumentException e) {
        System.out.println("Error adding product: " + e.getMessage());
    }
    }

    /**
     * TODO: Sell product with discount using Strategy pattern
     * @param id - product identifier
     * @param quantity - quantity to sell
     * @param discountType - type of discount to apply
     */
    public void sellProduct(String id, int quantity, String discountType) {
        // TODO: Implement sales logic
        // 1. Find product by ID
        // 2. Validate stock availability
        // 3. Calculate discount using DiscountCalculator
        // 4. Calculate total price and final price
        // 5. Update product quantity
        // 6. Display sale information
        Product product = products.get(id);
        if (product == null) {
            System.out.println("Product not found" + id);
            return;
        }
        if (!product.isInStock() || product.getQuantity() < quantity) {
            System.out.println("Insufficient stoc for product: " + id);
            return;
        }

        DiscountCalculator.DiscountResult discount = DiscountCalculator.calculateDiscount(product, quantity, discountType);

        double totalPrice = product.getPrice() * quantity;
        double finalPrice = totalPrice - discount.getDiscountAmount();

        product.sell(quantity);

         System.out.printf("Sale completed:%n");
         System.out.printf("Product: %s%n", product.getName());
         System.out.printf("Quantity: %d%n", quantity);
         System.out.printf("Original Price: $%.2f%n", totalPrice);
         System.out.printf("Discount: $%.2f (%s)%n", discount.getDiscountAmount(), discount.getDescription());
         System.out.printf("Final Price: $%.2f%n", finalPrice);
        }
    }

    /**
     * TODO: Add stock to existing product
     * @param id - product identifier
     * @param quantity - quantity to add
     */
    public void addStock(String id, int quantity) {
        // TODO: Implement stock addition
        // Find product and add stock
        // Display confirmation message
        if ( product == null) {
            System.out.println("Product not found " + id);
            return;
        }
        if (quantity <= 0){
            System.out.println("Quantity to add must be positive");
            return;
        }
        product.addStock(quantity);
        System.out.println("added " + quantity + " units to product: " + id);
    }

    /**
     * TODO: Display all products in inventory
     */
    public void viewInventory() {
        // TODO: Implement inventory display
        // Check if inventory is empty
        // Display all products with formatting
        if (products.isEmpty()) {
            System.out.println("Inventory is empity.");
            return;
        }
        System.out.println("Current inventory:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    /**
     * TODO: Calculate total inventory value
     * @return total value of all products
     */
    public double getInventoryValue() {
        // TODO: Calculate total value
        // Iterate through products and sum (price * quantity)
        double totalValue = 0.0;
        for (Product product : products.values()) {
        totalValue += product.getPrice() * product.getQuantity();
        }
        return totalValue;
    }

    /**
     * TODO: Get products with low stock
     * @param threshold - minimum stock level
     * @return list of products below threshold
     */
    public List<Product> getLowStockProducts(int threshold) {
        // TODO: Implement low stock detection
        // Filter products with quantity <= threshold
       List<Product> lowStockProducts = new ArrayList<>();
    for (Product product : products.values()) {
        if (product.getQuantity() <= threshold) {
            lowStockProducts.add(product);
        }
         return lowStockProducts;
    }

    /**
     * TODO: Display inventory statistics
     */
    public void viewStatistics() {
        // TODO: Implement statistics display
        // Show total products count
        // Show total inventory value
        // Show low stock alerts (threshold = 5)
         int totalProducts = products.size();
    double totalValue = getInventoryValue();
    List<Product> lowStockProducts = getLowStockProducts(5);

    System.out.println("Inventory Statistics:");
    System.out.println("Total number of products: " + totalProducts);
    System.out.printf("Total inventory value: ", totalValue);

    if (lowStockProducts.isEmpty()) {
        System.out.println("No low stock products.");
    } else {
        System.out.println("Low stock products (threshold <= 5):");
        for (Product product : lowStockProducts) {
            System.out.println(product);
        }
    }
    }

    // TODO: Optional helper methods
    // private boolean productExists(String id) { }
    // private void displaySalesSummary(Product product, int quantity, double originalPrice, double finalPrice, String discountInfo) { }
}