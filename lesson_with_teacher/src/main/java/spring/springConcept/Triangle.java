package spring.springConcept;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Figure{
    @Override
    public void draw() {
        System.out.println("triangle");
    }
}
