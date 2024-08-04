public class Order{
    public String id;
    public String customerName;
    public int totalPrice;

    Order(String id, String name, int price){
        this.setId(id).setCustomerName(name).setTotalPrice(price);
    }

    public Order setId(String id) {
        this.id = id;
        return this;
    }
    public Order setCustomerName(String name) {
        this.customerName = name;
        return this;
    }
    public Order setTotalPrice(int price) {
        this.totalPrice = price;
        return this;
    }
}