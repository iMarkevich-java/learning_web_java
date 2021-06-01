package spring.traditionalConcept;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(String a, String b) {
        Translator translator = new Translator();
        int numberAFromStringValue = translator.getNumberFromStringValue(a);
        int numberBFromStringValue = translator.getNumberFromStringValue(b);
        int add = add(numberAFromStringValue, numberBFromStringValue);
        return add;
    }
}
