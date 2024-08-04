import java.util.ArrayList;

public class NameSearcher {
    public ArrayList<Product> results;

    NameSearcher(){
        this.results = new ArrayList<Product>();
    }
    

    public NameSearcher search(String name, Catalog catalog){
        for(Product product: catalog.products){
            if(product.name.toLowerCase().contains(name.toLowerCase())){
                this.results.add(product);
            }
        }
        return this;
    }
}
