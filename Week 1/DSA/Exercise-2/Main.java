
import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of products for testing: ");
        int num = sc.nextInt();
        Catalog catalog = new Catalog(num);
        boolean isRunning = true;
        System.out.println("Welcome to the ABC Online Store");
        while (isRunning) {

            System.out.println("1: View product catalog.");
            System.out.println("2: Search product by id.");
            System.out.println("3: Search product by name.");
            System.out.println("4: Search product by category.");
            System.out.println("5: Exit.");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Call Catalog displayer
                    catalog.display();
                    break;
                case 2:
                    // Call IdSearcher
                    System.out.println("Enter Product ID: ");
                    int queryId = sc.nextInt();
                    IdSearcher idSearcher = new IdSearcher();
                    idSearcher.searchLinear(queryId, catalog);
                    Product result = idSearcher.result;
                    ProductPrinter.print(result);
                    idSearcher.reset();
                    idSearcher.searchBinary(queryId, catalog);
                    Product resultB = idSearcher.result;
                    ProductPrinter.print(resultB);
                    break;
                case 3:
                    // Call NameSearcher
                    System.out.println("Enter Product Name: ");
                    String queryName = sc.next();
                    NameSearcher namSearcher = new NameSearcher();
                    namSearcher.search(queryName, catalog);
                    ProductPrinter.print(namSearcher.results);
                    break;
                case 4:
                    // Call CategorySearcher
                    System.out.println("Enter Product Category: ");
                    String queryCategory = sc.next();
                    CategorySearcher categorySearcher = new CategorySearcher();
                    categorySearcher.search(queryCategory, catalog);
                    ProductPrinter.print(categorySearcher.results);
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
    }
}
