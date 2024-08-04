public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.setID(bookId).setTitle(title).setAuthor(author);
    }

    public Book setID(int id) {
        this.id = id;
        return this;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getBookId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return id +
                " - " + title +
                " - " + author;
    }
}
