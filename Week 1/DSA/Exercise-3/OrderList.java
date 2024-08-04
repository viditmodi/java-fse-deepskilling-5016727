import java.util.ArrayList;

public class OrderList {
    public ArrayList<Order> ordersBubble;
    public ArrayList<Order> ordersQuick;
    OrderList(){
        this.ordersBubble = RandomData.generateNOrders(10);
        this.ordersQuick = (ArrayList<Order>)this.ordersBubble.clone();
    }
    OrderList(int num){
        this.ordersBubble = RandomData.generateNOrders(10);
        this.ordersQuick = (ArrayList<Order>)this.ordersBubble.clone();
    }

    public void display(){
        OrderPrinter.print(ordersBubble);
    }

}
