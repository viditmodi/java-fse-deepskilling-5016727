public class BookPrinter {
    public static void print(Book book){
        System.out.println("|------------------------------");
        System.out.println("| "+book);
        System.out.println("|------------------------------");
    }
    
    public static void print(Book[] books){
       for(Book book: books){
        if(book!=null){
            print(book);
        }
       }
    }

}
