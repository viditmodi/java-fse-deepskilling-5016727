import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RandomData {
    public static String[] availableCats = { "sports", "games", "education", "lifestyle", "music", "home", "electronics",
            "books" };

    public static ArrayList<Product> generateNProducts(int num) {
        ArrayList<Product> products = new ArrayList<Product>();
        Random rnd = new Random();
        int rndNum = rnd.nextInt(10000);
        while (num-- > 0) {
            int numCats = rnd.nextInt(4) + 1;
            HashSet<String> cats = new HashSet<String>();
            while (numCats-- > 0) {
                int catIndex = rnd.nextInt(availableCats.length);
                cats.add(availableCats[catIndex]);
            }
            // System.out.println(cats);
            // Product prod = new Product((1000/(num+1)), "Test Product " + num, cats);
            Product prod = new Product((rndNum*(num+1))%10000, "Test Product " + num, cats);
            products.add(prod);
        }
        return products;
    }
}
