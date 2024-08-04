
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Employees for testing: ");
        int num = sc.nextInt();
        EMS ems = new EMS(num);
        boolean isRunning = true;
        System.out.println("Welcome to the Employee Management System");
        while (isRunning) {

            System.out.println("1: View Employee List.");
            System.out.println("2: Add Employee");
            System.out.println("3: Search an Employee by ID.");
            // System.out.println("4: Traverse Employees");
            System.out.println("4: Delete Employee");
            System.out.println("5: Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ems.display();
                    break;
                case 2:
                    ems.addEmployee();
                    break;
                case 3:
                    System.out.println("Enter ID to Search: ");
                    int id = sc.nextInt();
                    ems.searchEmployee(id);
                    break;
                case 4:
                    System.out.println("Enter ID to Delete: ");
                    int idDelete = sc.nextInt();
                    ems.deleteEmployee(idDelete);
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
