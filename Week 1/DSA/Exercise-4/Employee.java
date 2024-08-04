public class Employee {
    private int id;
    private String name;
    private String position;
    private int salary;

    public Employee(int id, String name, String position, int salary) {
        this.setEmployeeId(id).setName(name).setPosition(position).setSalary(salary);
    }

    public Employee setEmployeeId(int id) {
        this.id = id;
        return this;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public Employee setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public int getEmployeeId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + position + " - " + salary;
    }
}
