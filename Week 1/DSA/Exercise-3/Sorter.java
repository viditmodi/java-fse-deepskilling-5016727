import java.util.ArrayList;

public class Sorter {
    public static void bubbleSort(ArrayList<Order> orders) {
        int numSwaps = 0;
        int n = orders.size();
        int i, j;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (orders.get(j).totalPrice > orders.get(j + 1).totalPrice) {
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                    numSwaps++;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        System.out.println("Number of Swaps-> Bubble Sort: "+ numSwaps);
    }

    static void swap(ArrayList<Order> orders, int i, int j) {
        Order temp = orders.get(i);
        orders.set(i, orders.get(j));
        orders.set(j, temp);
    }

    static int partition(ArrayList<Order> orders, int low, int high) {
        Order pivot = orders.get(high);

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (orders.get(j).totalPrice < pivot.totalPrice) {

                i++;
                swap(orders, i, j);
            }
        }
        swap(orders, i + 1, high);
        return (i + 1);
    }

    static void quickSort(ArrayList<Order> orders, int low, int high, int numSwaps) {
        if (low < high) {

            int pi = partition(orders, low, high);
            numSwaps++;

            quickSort(orders, low, pi - 1, numSwaps);
            quickSort(orders, pi + 1, high, numSwaps);
        }
        // System.out.println("Number of Swaps-> Quick Sort: "+ numSwaps);
    }
}
