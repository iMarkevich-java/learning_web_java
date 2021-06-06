package lombok.examples.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private int id;
    private String model;
    private String mark;
    private int numberDoors;
    private double engineV;
    private int ear;
    private String color;
    private boolean airConditioner;
    private boolean chairMassagers;
}
/*

public class Car {
    private int id;
    private String model;
    private String mark;
    private int numberDoors;
    private double engineV;
    private int ear;
    private String color;
    private boolean airConditioner;
    private boolean chairMassagers;

    Car(int id, String model, String mark, int numberDoors, double engineV, int ear, String color, boolean airConditioner, boolean chairMassagers) {
        this.id = id;
        this.model = model;
        this.mark = mark;
        this.numberDoors = numberDoors;
        this.engineV = engineV;
        this.ear = ear;
        this.color = color;
        this.airConditioner = airConditioner;
        this.chairMassagers = chairMassagers;
    }

    public static Car.CarBuilder builder() {
        return new Car.CarBuilder();
    }

    public static class CarBuilder {
        private int id;
        private String model;
        private String mark;
        private int numberDoors;
        private double engineV;
        private int ear;
        private String color;
        private boolean airConditioner;
        private boolean chairMassagers;

        CarBuilder() {
        }

        public Car.CarBuilder id(int id) {
            this.id = id;
            return this;
        }

        public Car.CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public Car.CarBuilder mark(String mark) {
            this.mark = mark;
            return this;
        }

        public Car.CarBuilder numberDoors(int numberDoors) {
            this.numberDoors = numberDoors;
            return this;
        }

        public Car.CarBuilder engineV(double engineV) {
            this.engineV = engineV;
            return this;
        }

        public Car.CarBuilder ear(int ear) {
            this.ear = ear;
            return this;
        }

        public Car.CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Car.CarBuilder airConditioner(boolean airConditioner) {
            this.airConditioner = airConditioner;
            return this;
        }

        public Car.CarBuilder chairMassagers(boolean chairMassagers) {
            this.chairMassagers = chairMassagers;
            return this;
        }

        public Car build() {
            return new Car(this.id, this.model, this.mark, this.numberDoors, this.engineV, this.ear, this.color, this.airConditioner, this.chairMassagers);
        }

        public String toString() {
            return "Car.CarBuilder(id=" + this.id + ", model=" + this.model + ", mark=" + this.mark + ", numberDoors=" + this.numberDoors + ", engineV=" + this.engineV + ", ear=" + this.ear + ", color=" + this.color + ", airConditioner=" + this.airConditioner + ", chairMassagers=" + this.chairMassagers + ")";
        }
    }
}
 */