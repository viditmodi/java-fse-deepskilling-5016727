public class BuilderTester {
    public static void main(String[] args) {

        Computer comp1 = new Computer.ComputerBuilder().setCpu("Intel").setRam(16).setStorage(512).build();
        System.out.println(comp1);
        Computer comp2 = new Computer.ComputerBuilder().setCpu("AMD").setRam(32).setStorage(1024).build();
        System.out.println(comp2);

    }
}
