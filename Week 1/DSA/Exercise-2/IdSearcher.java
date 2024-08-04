// import java.util.HashSet;

public class IdSearcher {
    public Product result;

    public IdSearcher searchLinear(int id, Catalog catalog) {
        int numSearches = 0;
        for (Product product : catalog.products) {
            numSearches++;
            if (id == product.id) {
                this.result = product;
                break;
            }
        }
        System.out.println("Number of operations -> Linear Search: "+ numSearches);
        return this;
    }

    public void reset(){
        this.result = null;
    }

    private Product binarySearchHelper(int id, Catalog catalog, int left, int right, int numSearches) {
        numSearches++;
        if (right >= left) {
            int mid = left + (right - left) / 2;
            Product prod = catalog.products.get(mid);

            if (prod.id == id) {
                System.out.println("Number of operations -> Binary Search: "+ numSearches);
                return prod;
            }

            if (prod.id > id) {
                return binarySearchHelper(id, catalog, left, mid - 1, numSearches);
            }
            return binarySearchHelper(id, catalog, mid + 1, right, numSearches);
        }

        return null;
    }

    public IdSearcher searchBinary(int id, Catalog catalog) {
        // Implement Binary Search
        int left = 0, right = catalog.products.size() - 1;
        this.result = binarySearchHelper(id, catalog, left, right, 0);
        return this;
    }
}
