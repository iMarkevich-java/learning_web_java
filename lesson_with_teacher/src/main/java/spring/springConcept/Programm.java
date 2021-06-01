package spring.springConcept;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programm {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("common-beans.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Calculator calculatorBean = (Calculator) context.getBean("calculatorBean");
        int number = calculatorBean.add(3, 5);
        int numberString = calculatorBean.add("one", "two");
        System.out.println(number);
        System.out.println(calculatorBean.result);

        Calculator calculatorBean2 = (Calculator) context.getBean("calculatorBean");
        int number2 = calculatorBean2.add(3, 5);
        System.out.println(number2);
        System.out.println(calculatorBean2.result);

//        Calculator calculator = new Calculator();
//        int number = calculator.add(3, 5);
//        System.out.println(number);
//        int number2 = calculator.add("one", "five");
//        System.out.println(number2);
    }
}
