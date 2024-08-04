import java.util.ArrayList;

public class Catalog {
    public ArrayList<Product> products = new ArrayList<Product>();

    void bubbleSort() {
        int n = this.products.size();
        int i, j;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (this.products.get(j).id > this.products.get(j + 1).id) {
                    Product temp = this.products.get(j);
                    this.products.set(j, this.products.get(j + 1));
                    this.products.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    Catalog(int num) {
        products = RandomData.generateNProducts(num);
        this.bubbleSort();
        
    }
    
    Catalog(ArrayList<Product> products) {
        this.products = products;
        this.bubbleSort();
    }

    public void display() {
        System.out.println("Our Product Catalog.");
        ProductPrinter.print(products);
    }
}
