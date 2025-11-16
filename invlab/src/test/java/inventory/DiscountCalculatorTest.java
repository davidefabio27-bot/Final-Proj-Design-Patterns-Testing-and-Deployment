package inventory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {

    @Test
    void testStudentDiscountOnBook() {
        Product book = new Product("B001", "Java Book", ProductFactory.BOOK_TYPE, 20.0, 10);
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(book, 2, "STUDENT");
        assertEquals(4.0, result.getDiscountAmount(), 0.001); // 10% of 20 * 2 = 4.0
        assertTrue(result.getDescription().contains("Student discount"));
    }

    @Test
    void testStudentDiscountOnNonBook() {
        Product electronics = new Product("E001", "Headphones", ProductFactory.ELECTRONICS_TYPE, 50.0, 10);
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(electronics, 2, "STUDENT");
        assertEquals(0.0, result.getDiscountAmount(), 0.001);
        assertTrue(result.getDescription().contains("Student discount applies to books only"));
    }

    @Test
    void testBulkDiscountEligible() {
        Product book = new Product("B002", "Data Structures", ProductFactory.BOOK_TYPE, 30.0, 10);
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(book, 5, "BULK");
        assertEquals(22.5, result.getDiscountAmount(), 0.001); // 15% of 30 * 5 = 22.5
        assertTrue(result.getDescription().contains("Bulk discount"));
    }

    @Test
    void testBulkDiscountNotEligible() {
        Product book = new Product("B003", "Algorithms", ProductFactory.BOOK_TYPE, 30.0, 10);
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(book, 3, "BULK");
        assertEquals(0.0, result.getDiscountAmount(), 0.001);
        assertTrue(result.getDescription().contains("Bulk discount requires 5+ items"));
    }

    @Test
    void testNoDiscount() {
        Product electronics = new Product("E002", "Smartphone", ProductFactory.ELECTRONICS_TYPE, 200.0, 5);
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(electronics, 1, "NONE");
        assertEquals(0.0, result.getDiscountAmount(), 0.001);
        assertTrue(result.getDescription().contains("No discount applied"));
    }

    @Test
    void testNullDiscountType() {
        Product book = new Product("B004", "Clean Code", ProductFactory.BOOK_TYPE, 25.0, 5);
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(book, 1, null);
        assertEquals(0.0, result.getDiscountAmount(), 0.001);
        assertTrue(result.getDescription().contains("No discount applied"));
    }
}