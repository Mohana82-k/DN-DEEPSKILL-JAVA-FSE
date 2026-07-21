/*
 * Exercise 3 : Builder Pattern Example
 * Author : Mohana Priya K
 */

// Task 1: Product Class
class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private String gpu;

    // Task 2: Private Constructor
    private Computer(Builder builder) {

        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
    }
    public void displayConfiguration() {

        System.out.println("\n===== COMPUTER CONFIGURATION =====");
        System.out.println("CPU     : " + cpu);
        System.out.println("RAM     : " + ram);
        System.out.println("Storage : " + storage);
        System.out.println("GPU     : " + gpu);
    }

    // Task 3: Static Nested Builder Class
    public static class Builder {

        private String cpu;
        private String ram;
        private String storage;
        private String gpu;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String gpu) {
            this.gpu = gpu;
            return this;
        }

        // Task 4: Build Method
        public Computer build() {
            return new Computer(this);
        }
    }
}

// Task 5: Test Class
public class BuilderPatternTest {

    public static void main(String[] args) {

        Computer gamingPC =
                new Computer.Builder()
                        .setCPU("Intel i9")
                        .setRAM("32 GB")
                        .setStorage("1 TB SSD")
                        .setGPU("RTX 4080")
                        .build();

        Computer officePC =
                new Computer.Builder()
                        .setCPU("Intel i5")
                        .setRAM("16 GB")
                        .setStorage("512 GB SSD")
                        .setGPU("Integrated Graphics")
                        .build();

        gamingPC.displayConfiguration();
        officePC.displayConfiguration();
    }
}