public class ExcelDocument implements Document {
    public void open(){
        System.out.println("Excel Document Opened.");
    }
    public void close(){
        System.out.println("Excel Document Closed.");
    }
    public void save(){
        System.out.println("Excel Document Saved.");
    }
    
}