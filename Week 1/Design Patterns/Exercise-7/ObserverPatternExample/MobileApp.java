public class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println(appName + " received update: " + stockSymbol + " is now " + stockPrice);
    }
}
