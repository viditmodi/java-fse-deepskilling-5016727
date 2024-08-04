import java.util.ArrayList;
import java.util.Random;

public class RandomData {
    public static String[] availableCustomers = {"Aarav", "Aditi", "Advait", "Ananya", "Arjun", "Diya", "Ishaan", "Kavya", "Meera", "Nikhil", "Priya", "Rohan", "Sakshi", "Sanjay", "Ved"};

    public static ArrayList<Order> generateNOrders(int num) {
        ArrayList<Order> orders = new ArrayList<Order>();
        Random rnd = new Random();
        while (num-- > 0) {
            int rndNum = rnd.nextInt(availableCustomers.length);
            // Product prod = new Product((1000/(num+1)), "Test Product " + num, cats);
            Order order = new Order("RNDORD"+num, availableCustomers[rndNum], (rnd.nextInt(5)+1)*100*(num+1));
            orders.add(order);
        }
        return orders;
    }
}
