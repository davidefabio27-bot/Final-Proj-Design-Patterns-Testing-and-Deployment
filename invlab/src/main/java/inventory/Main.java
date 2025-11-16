package inventory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Inventory");
            System.out.println("3. Sell Product");
            System.out.println("4. Add Stock");
            System.out.println("5. View Statistics");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                scanner.nextLine(); // consume invalid input
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter product type (BOOK/ELECTRONICS): ");
                    String type = scanner.nextLine();

                    System.out.print("Enter product price: ");
                    double price = 0;
                    if (scanner.hasNextDouble()) {
                        price = scanner.nextDouble();
                        scanner.nextLine();
                    } else {
                        scanner.nextLine();
                        System.out.println("Invalid price input.");
                        break;
                    }

                    System.out.print("Enter product quantity: ");
                    int quantity = 0;
                    if (scanner.hasNextInt()) {
                        quantity = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.nextLine();
                        System.out.println("Invalid quantity input.");
                        break;
                    }

                    manager.addProduct(id, name, type, price, quantity);
                    break;

                case 2:
                    manager.viewInventory();
                    break;

                case 3:
                    System.out.print("Enter product ID to sell: ");
                    String sellId = scanner.nextLine();

                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = 0;
                    if (scanner.hasNextInt()) {
                        sellQuantity = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.nextLine();
                        System.out.println("Invalid quantity input.");
                        break;
                    }

                    System.out.print("Enter discount type (STUDENT/BULK/NONE): ");
                    String discountType = scanner.nextLine();

                    manager.sellProduct(sellId, sellQuantity, discountType);
                    break;

                case 4:
                    System.out.print("Enter product ID to add stock: ");
                    String stockId = scanner.nextLine();

                    System.out.print("Enter quantity to add: ");
                    int addQuantity = 0;
                    if (scanner.hasNextInt()) {
                        addQuantity = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.nextLine();
                        System.out.println("Invalid quantity input.");
                        break;
                    }

                    manager.addStock(stockId, addQuantity);
                    break;

                case 5:
                    manager.viewStatistics();
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}