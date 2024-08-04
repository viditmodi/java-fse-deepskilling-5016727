import java.util.HashSet;
import java.util.List;

public class Product{
    public int id;
    public String name;
    public HashSet<String> categories;
    Product(int id, String name, HashSet<String> categories){
        try {
            this.setId(id).setName(name).setCategories(categories);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    Product(int id, String name, String category){
        try {
            this.setId(id).setName(name);
            HashSet<String> cats = new HashSet<String>(List.of(category.split("[ ]*,[ ]*")));
            this.setCategories(cats);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Product setId(int id){
        this.id = id;
        return this;
    }
    public Product setName(String name){
        this.name = name;
        return this;
    }
    public Product setCategories(HashSet<String> categories){
        this.categories = categories;
        return this;
    }
}