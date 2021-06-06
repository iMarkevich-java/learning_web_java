package lombok.examples.toString;

import lombok.ToString;

@ToString
public class Person {
    private int id;
    private String name;
}
/*

public class Person {
    private int id;
    private String name;

    public Person() {
    }

    public String toString() {
        return "Person(id=" + this.id + ", name=" + this.name + ")";
    }
}
 */
