package patternBuilder;

public class Using {
    public static void main(String[] args) {
        Car car1 = extracted();
        Car car2 = Car.newCarBuilder().setModel("BMW").setNumberDoors(4).setAirConditioner(true).build();

    }

    private static Car extracted() {
        return Car.newCarBuilder()
                .setModel("BMW")
                .setId(4)
                .setNumberDoors(2)
                .setEngineV(1.9)
                .build();
    }
}
