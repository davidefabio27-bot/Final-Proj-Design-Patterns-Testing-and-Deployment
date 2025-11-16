package inventory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class InventoryManagerTest {

    private InventoryManager manager;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        manager = new InventoryManager();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testAddProductAndVerifyPresence() {
        manager.addProduct("B001", "Java Book", ProductFactory.BOOK_TYPE, 20.0, 10);
        manager.addProduct("E001", "Headphones", ProductFactory.ELECTRONICS_TYPE, 50.0, 5);

        manager.viewInventory();

        String output = outContent.toString();
        assertTrue(output.contains("Java Book"));
        assertTrue(output.contains("Headphones"));
    }

    @Test
    void testValidSaleUpdatesStock() {
        manager.addProduct("B002", "Data Structures", ProductFactory.BOOK_TYPE, 30.0, 10);
        manager.sellProduct("B002", 3, "NONE");

        Product product = manager.products.get("B002");
        assertEquals(7, product.getQuantity());

        String output = outContent.toString();
        assertTrue(output.contains("Sold 3 units"));
    }

    @Test
    void testInvalidSaleNotEnoughStock() {
        manager.addProduct("E002", "Smartphone", ProductFactory.ELECTRONICS_TYPE, 200.0, 2);
        manager.sellProduct("E002", 5, "NONE");

        Product product = manager.products.get("E002");
        assertEquals(2, product.getQuantity()); // quantity should not change

        String output = outContent.toString();
        assertTrue(output.contains("Insufficient stock"));
    }

    @Test
    void testAddStockIncreasesQuantity() {
        manager.addProduct("B003", "Algorithms", ProductFactory.BOOK_TYPE, 25.0, 5);
        manager.addStock("B003", 10);

        Product product = manager.products.get("B003");
        assertEquals(15, product.getQuantity());

        String output = outContent.toString();
        assertTrue(output.contains("Added 10 units"));
    }

    @Test
    void testViewStatisticsIncludesLowStock() {
        manager.addProduct("B004", "Clean Code", ProductFactory.BOOK_TYPE, 40.0, 3);
        manager.addProduct("E003", "Laptop", ProductFactory.ELECTRONICS_TYPE, 1000.0, 10);

        manager.viewStatistics();

        String output = outContent.toString();
        assertTrue(output.contains("Total number of products: 2"));
        assertTrue(output.contains("Low stock products"));
        assertTrue(output.contains("Clean Code"));
    }

    @BeforeEach
    void tearDown() {
        System.setOut(originalOut);
    }
}