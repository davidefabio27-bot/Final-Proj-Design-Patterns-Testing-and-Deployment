package inventory;

/**
 * Product class representing items in the inventory.
 * TODO: Implement this class with all required fields, constructor, and methods.
 *
 * Requirements:
 * - Private fields: id, name, type, price, quantity
 * - Constructor with validation
 * - Getter and setter methods
 * - sell(), addStock(), isInStock() methods
 * - toString() method
 */
public class Product {

    // TODO: Declare private fields
    // private String id;
    // private String name;
    // private String type;
    // private double price;
    // private int quantity;
    private String id;
    private String name;   
    private String type;
    private double price;
    private int quantity; 

    
    /**
     * TODO: Implement constructor
     * @param id - unique product identifier
     * @param name - product name
     * @param type - product category (BOOK or ELECTRONICS)
     * @param price - product price (must be non-negative)
     * @param quantity - stock quantity (must be non-negative)
     * @throws IllegalArgumentException if price or quantity is negative
     */
    public Product(String id, String name, String type, double price, int quantity) {
        // TODO: Implement constructor with validation
        // Hint: Check if price >= 0 and quantity >= 0
        // Throw IllegalArgumentException with descriptive message if invalid
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
     }
     // TODO: Implement getter methods
    // public String getId() { }
    // public String getName() { }
    // public String getType() { }
    // public double getPrice() { }
    // public int getQuantity() { }

    // TODO: Implement setter methods with validation
    // public void setPrice(double price) { }
    // public void setQuantity(int quantity) { }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(tring type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be negative")
    }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0){
            throw new IllegalArgumentException("quantity cannot be negative")
        }
        this.quantity = quantity;
    }
    /**
     * TODO: Implement sell method
     * @param amount - quantity to sell
     * @return true if sale successful, false if insufficient stock
     */
    public boolean sell(int amount) {
        // TODO: Implement sell logic
        // Check if amount is valid and sufficient stock exists
        // Update quantity if successful
        if (amount <= 0) {
            throw new IllegalArgumentException("amount to sell must be positive");
        }
        if (quantity >= amount) {
            quantity -= amount;
            return true;
        }
        return false; // Placeholder
    }

    /**
     * TODO: Implement addStock method
     * @param amount - quantity to add to stock
     */
    public void addStock(int amount) {
        // TODO: Implement stock addition
        // Validate amount is positive before adding
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to add must be posite");
        }
        quantity += amount;
    }

    /**
     * TODO: Implement isInStock method
     * @return true if product has stock available
     */
    public boolean isInStock() {
        // TODO: Return true if quantity > 0
         return quantity > 0;
    }
    }
    return false; // Placeholder
    /**
     * TODO: Implement toString method
     * @return formatted string representation of the product
     */
    @Override
    public String toString() {
        // TODO: Return formatted string with all product details
        // Suggested format: "Product{id='B001', name='Java Book', type='BOOK', price=29.99, quantity=5}"
        return String.format("Product[id=B001, name=Java Book, type=Book, price=29.99, quantity=5]",
        id, name, type, price, quantity);; // Placeholder
    }
}