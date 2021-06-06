package patternBuilder;

import lombok.Getter;


@Getter
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

    private Car() {
    }



    public static CarBuilder newCarBuilder() {
        return new Car().new CarBuilder();
    }

    public class CarBuilder {
        private CarBuilder() {
        }

        public CarBuilder setId(int id) {
            Car.this.id = id;
            return this;
        }

        public CarBuilder setModel(String model) {
            Car.this.model = model;
            return this;
        }

        public CarBuilder setMark(String mark) {
            Car.this.mark = mark;
            return this;
        }

        public CarBuilder setNumberDoors(int numberDoors) {
            Car.this.numberDoors = numberDoors;
            return this;
        }

        public CarBuilder setEngineV(double engineV) {
            Car.this.engineV = engineV;
            return this;
        }

        public CarBuilder setAirConditioner(boolean airConditioner) {
            Car.this.airConditioner = airConditioner;
            return this;
        }

        public Car build() {
            return Car.this;
        }
    }
}
