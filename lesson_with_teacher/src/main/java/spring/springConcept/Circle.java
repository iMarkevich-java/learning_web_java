package spring.springConcept;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure{
    @Override
    public void draw() {
        System.out.println("circle");
    }
}
