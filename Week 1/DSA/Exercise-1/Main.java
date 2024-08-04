
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Creating new inventory.");
        System.out.println("Enter Inventory Name: ");
        String name = sc.next();
        System.out.println("Enter number of Random products to create: ");
        int num = sc.nextInt();

        Inventory inventory = new Inventory(name, num);
        boolean isRunning = true;
        System.out.println("Welcome to the Inventory Management System");
        while (isRunning) {

            System.out.println("1: View product catalog.");
            System.out.println("2: Add New Product");
            System.out.println("3: Update Product");
            System.out.println("4: Delete Product");
            System.out.println("5: Exit.");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    inventory.display();
                    break;
                case 2:
                    System.out.println("Creating new product.");
                    Product prod = new Product();
                    inventory.addProduct(prod);

                    break;
                case 3:
                    System.out.println("Updating product.");
                    System.out.println("Enter the id of the product: ");
                    inventory.updateProduct(sc.nextInt());
                    break;
                    case 4:
                    System.out.println("Deleting product.");
                    System.out.println("Enter the id of the product: ");
                    inventory.deleteProduct(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Thank you for visiting");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;
            }
        }
        
        sc.close();
    }
}
