public class ObserverTester {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        stockMarket.setStockPrice("AAPL", 150.00);
        System.out.println();

        stockMarket.deregisterObserver(mobileApp2);
        stockMarket.setStockPrice("GOOG", 2800.00);
    }
}
