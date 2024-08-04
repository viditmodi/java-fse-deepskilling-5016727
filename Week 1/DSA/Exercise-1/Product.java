import java.util.Random;
import java.util.Scanner;

public class Product {
	public int id;
	public String name;
	public int quantity;
	public double price;

    Product(){
        Random rnd = new Random();
        int rndNum = rnd.nextInt(100000);
        this.id = (rndNum)%10000;
        this.newProduct();
    }
	Product(int id, String name, double price, int quantity) {
		try {
			this.setId(id).setName(name).setPrice(price).setQuantity(quantity);

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	Product(int id, String name, double price) {
		try {
			this.setId(id).setName(name).setPrice(price).setQuantity(0);

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Product setId(int id) {
		if( id<=0) {
			throw new Error("Invalid Product ID");
		}
		this.id = id;
		return this;
	}
	public Product setName(String name) {
		if(name.equals("") || name==null) {
			throw new Error("Invalid Product Name");
		}
		this.name = name;
		return this;
	}
	public Product setPrice(double price) {
		if( price<=0) {
			throw new Error("Invalid Product Price");
		}
		this.price = price;
		return this;
	}
	public Product setQuantity(int quantity) {
		if(quantity<0) {
			throw new Error("Invalid Product Quantity");
		}
		this.quantity = quantity;
		return this;
	}

	public int getId() {
	    return this.id;
	}
	public String getName() {
		
		return this.name;
	}
	public double getPrice() {
		
		return this.price;
	}
	public int getQuantity() {
		
		return this.quantity;
	}
	
	public Product addStock(int stock){
	    this.quantity+=stock;
	    return this;
	}
	public Product removeStock(int stock){
	    this.quantity-=stock;
	    return this;
	}
	public Product emptyStock(){
	    this.quantity=0;
	    return this;
	}


    public Product newProduct(){
        
        System.out.println("Provide data for Product ID: "+this.id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        this.name = sc.nextLine();
        System.out.println("Enter Price: ");
        this.price = sc.nextDouble();
        System.out.println("Enter Quantity: ");
        this.quantity = sc.nextInt();
        return this;
    }
    public Product update(){
        

        return this;

    }
    @Override
    public String toString(){
        return id+" - "+name+" - "+quantity+" - "+price;
    }
}

