package lombok.examples.builder;

public class Using {
    public static void main(String[] args) {
        Car audi100 = Car.builder().airConditioner(true).color("green").ear(1968).engineV(1.9).build();
        String color = audi100.getColor();
        audi100.setAirConditioner(true);
    }
}
