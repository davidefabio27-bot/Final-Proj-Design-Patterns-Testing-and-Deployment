package inventory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductFactoryTest {

    @Test
    void testCreateValidBook() {
        Product book = ProductFactory.createProduct("B001", "Java Book", ProductFactory.BOOK_TYPE, 15.99, 10);
        assertNotNull(book);
        assertEquals("B001", book.getId());
        assertEquals("Java Book", book.getName());
        assertEquals(ProductFactory.BOOK_TYPE, book.getType());
        assertEquals(15.99, book.getPrice());
        assertEquals(10, book.getQuantity());
    }

    @Test
    void testCreateValidElectronics() {
        Product electronics = ProductFactory.createProduct("E001", "Smartphone", ProductFactory.ELECTRONICS_TYPE, 299.99, 5);
        assertNotNull(electronics);
        assertEquals("E001", electronics.getId());
        assertEquals("Smartphone", electronics.getName());
        assertEquals(ProductFactory.ELECTRONICS_TYPE, electronics.getType());
        assertEquals(299.99, electronics.getPrice());
        assertEquals(5, electronics.getQuantity());
    }

    @Test
    void testBookMinimumPriceValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ProductFactory.createProduct("B002", "Cheap Book", ProductFactory.BOOK_TYPE, 3.99, 5);
        });
        assertTrue(exception.getMessage().contains("Book price must be at least"));
    }

    @Test
    void testElectronicsMinimumPriceValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ProductFactory.createProduct("E002", "Cheap Gadget", ProductFactory.ELECTRONICS_TYPE, 5.99, 3);
        });
        assertTrue(exception.getMessage().contains("Electronics price must be at least"));
    }

    @Test
    void testInvalidProductType() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ProductFactory.createProduct("X001", "Unknown Product", "TOY", 10.00, 1);
        });
        assertTrue(exception.getMessage().contains("Invalid product type"));
    }

    @Test
    void testNullProductType() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ProductFactory.createProduct("N001", "Null Type Product", null, 10.00, 1);
        });
        assertTrue(exception.getMessage().contains("Product type cannot be null"));
    }
}