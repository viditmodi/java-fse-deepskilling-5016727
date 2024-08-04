import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Financial Forecaster");
        System.out.println("Enter the initial amount: ");
        int init = sc.nextInt();
        System.out.println("Enter the growth rate(%): ");
        int rate = sc.nextInt();
        
        FinancialForecster ff = new FinancialForecster(init, rate);
        System.out.println("Enter the forecast offset: ");
        int offset = sc.nextInt();

        System.out.println("Forecasted Value: "+ ff.forecast(offset));
    }
}