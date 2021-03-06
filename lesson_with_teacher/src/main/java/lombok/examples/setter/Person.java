package lombok.examples.setter;

import lombok.Setter;

@Setter
public class Person {
    private int id;
    private String name;
    private final int age = 5;
}
/*
public class Person {
    private int id;
    private String name;

    public Person() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
 */
