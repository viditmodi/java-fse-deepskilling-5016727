public class WordDocument implements Document {
    public void open(){
        System.out.println("Word Document Opened.");
    }
    public void close(){
        System.out.println("Word Document Closed.");
    }
    public void save(){
        System.out.println("Word Document Saved.");
    }
    
}