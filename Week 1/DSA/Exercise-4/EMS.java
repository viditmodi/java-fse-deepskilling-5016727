import java.util.Scanner;

public class EMS {
    public Employee[] employees;
    public int capacity;
    public int size;

    EMS(int num) {
        this.employees = RandomData.generateNEmployees(num);
        this.capacity = num + 10;
        this.size = num;
    }

    public void display() {
        EmployeePrinter.print(employees);
    }

    public EMS addEmployee() {
        if (this.size >= this.capacity) {
            System.out.println("No Vacancy. Remove Some Employees");
            return this;
        }
        System.out.println("Provide Employee Details");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID (Integer): ");
        int id = sc.nextInt();
        System.out.println("Enter Name: ");
        String name = sc.next();
        System.out.println("Enter Position: ");
        String position = sc.next();
        System.out.println("Enter Salary: ");
        int salary = sc.nextInt();
        // sc.close();

        this.employees[this.size++] = new Employee(id, name, position, salary);
        System.out.println("Employee added");
        return this;
    }

    public void searchEmployee(int id) {
        for (Employee employee : employees) {
            if (employee!=null && employee.getEmployeeId() == id) {
                EmployeePrinter.print(employee);
                break;
            }
        }
        System.out.println("No Employee found");
        
    }

    public EMS deleteEmployee(int id) {
        for (int i = 0; i < this.size; i++) {
            if (employees[i].getEmployeeId() == id) {
                
                for (int j = i; j < this.size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--this.size] = null;
                return this;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
        return this;
    }
}
