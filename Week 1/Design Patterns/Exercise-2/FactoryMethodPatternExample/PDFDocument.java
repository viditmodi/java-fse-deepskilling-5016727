
public class PDFDocument implements Document {
    public void open(){
        System.out.println("PDF Document Opened.");
    }
    public void close(){
        System.out.println("PDF Document Closed.");
    }
    public void save(){
        System.out.println("PDF Document Saved.");
    }
    
}