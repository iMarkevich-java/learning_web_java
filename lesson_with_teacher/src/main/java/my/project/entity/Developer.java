package my.project.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private int developerId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @Column(name = "year_skills")
    private int yearSkills;

    @ManyToMany(mappedBy = "developerList", fetch = FetchType.LAZY)
    private Set<Project> projectList;

    public Developer() {
    }

    public Developer(String name, int age, int salary, int yearSkills) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.yearSkills = yearSkills;
    }

    public Developer(int developerId, String name, int age, int salary, int yearSkills) {
        this.developerId = developerId;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.yearSkills = yearSkills;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYearSkills() {
        return yearSkills;
    }

    public void setYearSkills(int yearSkills) {
        this.yearSkills = yearSkills;
    }
}
