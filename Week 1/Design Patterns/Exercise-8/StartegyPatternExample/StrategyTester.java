public class StrategyTester {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe", "123", "12/23"));
        context.executePayment(250.00);
        System.out.println();

        context.setPaymentStrategy(new PayPalPayment("john.doe@example.com", "password"));
        context.executePayment(100.00);
    }
}
