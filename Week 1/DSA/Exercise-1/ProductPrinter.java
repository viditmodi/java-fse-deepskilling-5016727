import java.util.HashMap;

public class ProductPrinter {
    public static void print(Product product){
        System.out.println("|------------------------------");
        System.out.println("| "+product);
        System.out.println("|------------------------------");
    }
    public static void print(HashMap<Integer, Product> products){
        for(int id: products.keySet()){
            print(products.get(id));
        }
    }


}
