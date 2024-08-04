import java.util.Scanner;

public class Task {
    private int id;
    private String name;
    private String status;

    Task(int id, String name, String status) {
        this.setId(id).setName(name).setStatus(status);
    }

    Task() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        this.setId(sc.nextInt());
        System.out.println("Enter Name: ");
        this.setName(sc.next());
        System.out.println("Enter Status: ");
        this.setStatus(sc.next());
    }

    public Task setId(int id) {
        this.id = id;
        return this;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public Task setStatus(String status) {
        this.status = status;
        return this;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

}
