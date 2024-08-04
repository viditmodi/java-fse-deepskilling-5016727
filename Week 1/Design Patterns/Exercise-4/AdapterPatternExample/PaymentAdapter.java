public class PaymentAdapter implements PaymentProcessor{
    public Payment processor;
    public PaymentAdapter(String gateway){
        switch (gateway) {
            case "card":
                processor = new CardPayment();
                break;
            case "upi":
                processor = new UPIPayment();
                break;
            case "cash":
                processor = new CashOnDeliveryPayment();
                break;
        
            default:
                break;
        }
    }

    public void processPayment(){
        processor.pay();
    }
    
}