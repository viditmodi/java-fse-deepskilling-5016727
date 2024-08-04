
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Orders for testing: ");
        int num = sc.nextInt();
        OrderList orderList = new OrderList(num);
        boolean isRunning = true;
        System.out.println("Welcome to the Customer Order Prioritizer");
        while (isRunning) {

            System.out.println("1: View Order List.");
            System.out.println("2: Sort using Bubble Sort.");
            System.out.println("3: Sort using Quick Sort.");
            System.out.println("4: Compare Both Algorithms.");
            System.out.println("5: Exit.");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Call Catalog displayer
                    orderList.display();
                    break;
                case 2:
                    System.out.println("Using Bubble Sort.");
                    Sorter.bubbleSort(orderList.ordersBubble);
                    OrderPrinter.print(orderList.ordersBubble);
                    break;
                case 3:
                    System.out.println("Using Quick Sort.");
                    Sorter.quickSort(orderList.ordersQuick, 0, orderList.ordersQuick.size() - 1, 0);
                    OrderPrinter.print(orderList.ordersQuick);
                    break;
                case 4:
                    System.out.println("Using Bubble Sort.");
                    Sorter.bubbleSort(orderList.ordersBubble);
                    OrderPrinter.print(orderList.ordersBubble);

                    System.out.println("Using Quick Sort.");
                    Sorter.quickSort(orderList.ordersQuick, 0, orderList.ordersQuick.size() - 1, 0);
                    OrderPrinter.print(orderList.ordersQuick);
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
