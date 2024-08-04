public class DependencyInjectionTester {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);
        Customer customer = service.findCustomerById("1");

        System.out.println(customer);
    }
}
