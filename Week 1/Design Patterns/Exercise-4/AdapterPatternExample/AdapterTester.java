public class AdapterTester{
    public static void main(String[] args) {
        PaymentProcessor cardPay = new PaymentAdapter("card");
        cardPay.processPayment();
        PaymentProcessor upiPay = new PaymentAdapter("upi");
        upiPay.processPayment();
        PaymentProcessor codPay = new PaymentAdapter("cash");
        codPay.processPayment();
    }
}