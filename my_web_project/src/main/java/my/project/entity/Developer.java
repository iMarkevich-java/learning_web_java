package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private BigInteger developerId;

    @Column(name = "developer_department")
    private String developerDepartment;

    @Column(name = "developer_experience")
    private int developerExperience;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_developer_communication", joinColumns = @JoinColumn(name = "developer_id_fk"), inverseJoinColumns = @JoinColumn(name = "employee_id_fk"))
    private Employee employee;

    public Developer() {
    }

    public Developer(String developerDepartment, int developerExperience) {
        this.developerDepartment = developerDepartment;
        this.developerExperience = developerExperience;
    }

    public Developer(BigInteger developerId, String developerDepartment, int developerExperience) {
        this.developerId = developerId;
        this.developerDepartment = developerDepartment;
        this.developerExperience = developerExperience;
    }

    public BigInteger getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(BigInteger developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperDepartment() {
        return developerDepartment;
    }

    public void setDeveloperDepartment(String developerDepartment) {
        this.developerDepartment = developerDepartment;
    }

    public int getDeveloperExperience() {
        return developerExperience;
    }

    public void setDeveloperExperience(int developerExperience) {
        this.developerExperience = developerExperience;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Developer developer = (Developer) o;
//        return developerExperience == developer.developerExperience && developerId.equals(developer.developerId) && developerDepartment.equals(developer.developerDepartment) && address.equals(developer.address);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(developerId, developerDepartment, developerExperience, address);
//    }

    @Override
    public String toString() {
        return "<h2>Отдел:</h2>" + developerDepartment + "\n" +
                "<h2>Стаж:</h2>" + developerExperience + "\n";
    }

}
