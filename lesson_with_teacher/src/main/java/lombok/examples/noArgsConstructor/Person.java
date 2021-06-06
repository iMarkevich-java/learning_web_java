package lombok.examples.noArgsConstructor;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Person {

    private int id;

    private String name;

    private int age;

    public Person(int age) {
        this.age = age;
    }
}
