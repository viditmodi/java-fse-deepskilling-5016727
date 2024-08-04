
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of books for testing: ");
        int num = sc.nextInt();
        LMS lms = new LMS(num);
        boolean isRunning = true;
        System.out.println("Welcome to the ABC Library");
        while (isRunning) {

            System.out.println("1: View books catalog.");
            System.out.println("2: Linear Search.");
            System.out.println("3: Binary Search.");
            System.out.println("4: Exit.");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lms.display();
                    break;
                case 2:
                    System.out.println("Enter Book Title: ");
                    String lTitle = sc.next();
                    BookPrinter.print(lms.linearSearchByTitle(lTitle));
                    break;
                case 3:
                    System.out.println("Enter Book Title: ");
                    String bTitle = sc.next();
                    BookPrinter.print(lms.binarySearchByTitle(bTitle));

                    break;

                case 4:
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
