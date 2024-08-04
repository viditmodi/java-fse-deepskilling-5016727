import java.util.Arrays;
import java.util.Comparator;

public class LMS {
    private Book[] books;
    private int size;

    public LMS(int capacity) {
        books = RandomData.generateNBooks(capacity);
        size = capacity;
    }

    public void display(){
        BookPrinter.print(books);
    }

    // public void addBook(Book book) {
    //     if (size < books.length) {
    //         books[size++] = book;
    //     } else {
    //         System.out.println("Library is full, cannot add more books.");
    //     }
    // }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, 0, size, Comparator.comparing(Book::getTitle));

        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = books[mid].getTitle().compareToIgnoreCase(title);
            if (compareResult == 0) {
                return books[mid];
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // public static void main(String[] args) {
    //     LMS lms = new LMS(10);
    //     lms.addBook(new Book(1, "Harry Potter", "J.K. Rowling"));
    //     lms.addBook(new Book(2, "The Hobbit", "J.R.R. Tolkien"));
    //     lms.addBook(new Book(3, "1984", "George Orwell"));

    //     // Linear Search
    //     System.out.println("Linear Search for 'The Hobbit': " + lms.linearSearchByTitle("The Hobbit"));

    //     // Binary Search
    //     System.out.println("Binary Search for '1984': " + lms.binarySearchByTitle("1984"));
    // }
}
