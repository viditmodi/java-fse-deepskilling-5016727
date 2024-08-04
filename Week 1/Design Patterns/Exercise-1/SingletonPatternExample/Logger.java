public class Logger {
    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            System.out.println("No Instance found. Creating a new Instance.");
            logger = new Logger();

        } else {

            System.out.println("Using the same Instance.");
        }
        return logger;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
