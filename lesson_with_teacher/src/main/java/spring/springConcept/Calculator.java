package spring.springConcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("calculatorBean")
@Scope("prototype")
public class Calculator {

    int result = 0;

    @Autowired
    Translator translatorObj;

    @Autowired
    @Qualifier("circle")
    Figure figure;

    public int add(int a, int b) {
        figure.draw();
        int add = a + b;
        result += add;
        return add;
    }

    public int add(String a, String b) {
        int numberAFromStringValue = translatorObj.getNumberFromStringValue(a);
        int numberBFromStringValue = translatorObj.getNumberFromStringValue(b);
        int add = add(numberAFromStringValue, numberBFromStringValue);
        return add;
    }

    public Translator getTranslatorObj() {
        return translatorObj;
    }

    public void setTranslatorObj(Translator translatorObj) {
        this.translatorObj = translatorObj;
    }
}
