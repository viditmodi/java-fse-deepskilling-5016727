import java.util.HashMap;
import java.util.Random;

public class RandomData {

    public static HashMap<Integer, Product> generateNProducts(int num) {
        HashMap<Integer, Product> products = new HashMap<Integer, Product>();
        Random rnd = new Random();
        int rndNum = rnd.nextInt(10000);
        while (num-- > 0) {
            Product prod = new Product((rndNum*(num+1))%10000, "Test Product " + num, (rnd.nextInt(10)+1)*(num+1)*10);
            products.put(prod.id, prod);
        }
        return products;
    }
}
