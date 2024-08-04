import java.util.ArrayList;

public class CategorySearcher {
    public ArrayList<Product> results;

    CategorySearcher(){
        this.results = new ArrayList<Product>();
    }

    public CategorySearcher search(String category, Catalog catalog){
        for(Product product: catalog.products){
            if(product.categories.contains(category)){
                this.results.add(product);
            }
        }
        return this;
    }
}
