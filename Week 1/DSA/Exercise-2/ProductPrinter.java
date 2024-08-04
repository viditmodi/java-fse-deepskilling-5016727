import java.util.ArrayList;

public class ProductPrinter {
    public static void print(Product product){
        System.out.println("|------------------------------");
        System.out.println("|"+product.id + " - " + product.name);
        System.out.println("|"+product.categories);
        System.out.println("|------------------------------");
    }
    public static void print(ArrayList<Product> products){
        for(Product product: products){
            ProductPrinter.print(product);
        }
    }
}
