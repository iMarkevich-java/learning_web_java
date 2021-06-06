package lombok.examples.getter;

import lombok.Getter;

@Getter
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

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
 */


