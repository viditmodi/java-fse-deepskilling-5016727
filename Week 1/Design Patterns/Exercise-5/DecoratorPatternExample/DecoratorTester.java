public class DecoratorTester {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        
        notifier = new SMSNotifierDecorator(notifier);
        
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("This is a test message.");
    }
}
