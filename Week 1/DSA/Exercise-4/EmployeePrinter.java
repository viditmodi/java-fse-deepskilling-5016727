
public class EmployeePrinter {
    public static void print(Employee employee) {
        System.out.println("|------------------------------");
        System.out.println("| " + employee);
        System.out.println("|------------------------------");
    }

    public static void print(Employee[] employees) {
        for (Employee employee : employees) {
            if(employee==null){
                break;
            }
            print(employee);
        }
    }
}
