import java.util.Random;

public class RandomData {
    public static String[] names = { "Rajesh", "Sneha", "Vikram", "Neha", "Karan", "Pooja", "Rakesh", "Anita", "Sameer",
            "Lata", "Vikas", "Ritu", "Amit", "Nisha", "Sunil" };
    public static String[] positions = { "Manager", "Developer", "Designer", "Analyst", "Tester", "Sales Executive",
            "HR Specialist", "Marketing Manager", "Product Manager", "Support Engineer" };

    public static Employee[] generateNEmployees(int num) {
        Random rnd = new Random();
        Employee[] employees = new Employee[num+10];
        while (num-- > 0) {
            int rndNum = rnd.nextInt(10000) + 1;
            employees[num] = new Employee((rndNum * (num + 1)) % 10000, names[rnd.nextInt(names.length)],
                    positions[rnd.nextInt(positions.length)], rndNum * 50);
        }
        return employees;

    }
}
