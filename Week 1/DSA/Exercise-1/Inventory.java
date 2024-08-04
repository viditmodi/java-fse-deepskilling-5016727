import java.util.HashMap;
public class Inventory {
    public String name;
	HashMap<Integer, Product> products;

	Inventory(String name, int num) {
		try {
			this.setName(name);
			this.products = RandomData.generateNProducts(num);

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


    public void display(){
        ProductPrinter.print(products);
    }

	public Inventory setName(String name) {
		if(name.equals("") || name==null) {
			throw new Error("Invalid Inventory Name");
		}
		this.name = name;
		return this;
	}
    
    public Inventory addProduct(Product product){
        if(products.containsKey(product.getId())){
            throw new Error("Product already exists");
        }
        this.products.put(product.getId(), product);
        return this;
    }
    
    public Inventory updateProduct(int id){
        if(!this.products.containsKey(id)){
            throw new Error("No Product Found");
        }
        Product existingProduct = this.products.get(id);
        System.out.println("Existing Product: ");
        ProductPrinter.print(existingProduct);

        existingProduct.newProduct();

        this.products.put(existingProduct.id, existingProduct);
        System.out.println("Product Updated");
        return this;
    }
    public Inventory deleteProduct(int id){
        if(!this.products.containsKey(id)){
            throw new Error("No Product Found");
        }
        this.products.remove(id);


        System.out.println("Product Deleted");
        return this;
    }
}