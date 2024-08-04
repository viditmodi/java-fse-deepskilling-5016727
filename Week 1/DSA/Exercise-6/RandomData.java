import java.util.Random;

public class RandomData {
    public static String[] names = { "Rajesh", "Sneha", "Vikram", "Neha", "Karan", "Pooja", "Rakesh", "Anita", "Sameer",
            "Lata", "Vikas", "Ritu", "Amit", "Nisha", "Sunil" };

    public static Book[] generateNBooks(int num) {
        Book[] books = new Book[num];
        Random rnd = new Random();
        int rndNum = rnd.nextInt(10) + 1;
        while (num-- > 0) {

            Book book = new Book((rndNum * (num + 1)), "TestBook" + (rndNum * (num + 1)),
                    names[rnd.nextInt(names.length)]);
            books[num] = book;
        }
        return books;
    }
}
