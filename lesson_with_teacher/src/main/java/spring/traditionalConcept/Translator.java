package spring.traditionalConcept;

public class Translator {
    public int getNumberFromStringValue(String numberString) {
        try {
            int numberInt = Integer.parseInt(numberString);
            return numberInt;
        } catch (NumberFormatException e) {

        }

        if ("one".equals(numberString)) {
            return 1;
        } else if ("two".equals(numberString)) {
            return 2;
        }else if ("three".equals(numberString)) {
            return 3;
        }else if ("four".equals(numberString)) {
            return 4;
        }else if ("five".equals(numberString)) {
            return 5;
        }else if ("six".equals(numberString)) {
            return 6;
        }
        return 0;
    }
}
