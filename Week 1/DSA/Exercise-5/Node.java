public class Node {
    private Task task;
    private Node next;

    Node(Task task, Node next){
        this.setTask(task).setNextNode(next);
    }
    Node(Task task){
        this.setTask(task).setNextNode(null);
    }

    public Node setTask(Task task){
        this.task = task;
        return this;
    }
    public Node setNextNode(Node next){
        this.next = next;
        return this;
    }

    public Task getTask(){
        return this.task;
    }

    public Node getNextNode(){
        return this.next;
    }

    @Override
    public String toString(){
        return task.getId()+" - "+task.getName()+" - "+task.getStatus();
    }
}
