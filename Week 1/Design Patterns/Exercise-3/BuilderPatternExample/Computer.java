public class Computer {
    private String cpu;
    private int ram;
    private int storage;

    private Computer(ComputerBuilder computerBuilder) {
        this.cpu = computerBuilder.cpu;
        this.ram = computerBuilder.ram;
        this.storage = computerBuilder.storage;
    }

    public String toString(){
        return cpu+" - "+ram+" - "+storage;
    }

    public static class ComputerBuilder {
        private String cpu;
        private int ram;
        private int storage;

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        public ComputerBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }
        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

    }
}