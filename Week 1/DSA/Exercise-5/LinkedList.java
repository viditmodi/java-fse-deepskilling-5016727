import java.util.Scanner;

public class LinkedList {
    private Node head;
    LinkedList(Node node){
        this.head = node;
    }
    LinkedList(){
        this.head = null;
    }
    LinkedList(Task task){
        Node node = new Node(task);
        this.head = node;
    }

    public void add(){
        Task newTask = new Task();
        Node newNode = new Node(newTask);
        if(this.head==null){
            this.head = newNode;
        }else{
            Node current = this.head;
            while (current.getNextNode()!=null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
    }
    
    public void traverse(){
        if(this.head==null){
            System.out.println("No Node to Traverse");
            return;
        }else{
            Node current = this.head;
            System.out.println("Printing the list");
            while (current!=null) {
                NodePrinter.print(current);
                current = current.getNextNode();
            }
        }
    }
    
    public void search(int id){
            Node current = this.head;
            int index = 0;
            while (current!=null) {
                if(current.getTask().getId()==id){
                    System.out.println("Task found at index: "+index);
                    break;
                }
                index++;
                current = current.getNextNode();
            }
            System.out.println("Task not found");

        
    }
    
    public void delete(int id){
            Node current = this.head;
            Node prev = null;
            while (current.getTask().getId()!=id) {
                prev = current;
                current = current.getNextNode();
            }
            prev.setNextNode(current.getNextNode());
            
            System.out.println("Task deleted");

        
    }
}
