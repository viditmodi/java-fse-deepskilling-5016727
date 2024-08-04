import java.util.ArrayList;

public class OrderPrinter {
    public static void print(Order order){
        System.out.println("|------------------------------");
        System.out.println("| "+order.id + " " + order.customerName + " "+ order.totalPrice);
        System.out.println("|------------------------------");
    }
    public static void print(ArrayList<Order> orders){
        for(Order order: orders){
            print(order);
        }
    }
}
