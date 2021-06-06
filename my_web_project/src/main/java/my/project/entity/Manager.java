package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private BigInteger managerId;

    @Column(name = "manager_department")
    private String managerDepartment;

    @Column(name = "manager_experience")
    private int managerExperience;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinTable(name = "employee_manager_communication", joinColumns = @JoinColumn(name = "manager_id_fk"), inverseJoinColumns = @JoinColumn(name = "employee_id_fk"))
    private Employee employee;

    public Manager() {
    }

    public Manager(String managerDepartment, int managerExperience) {
        this.managerDepartment = managerDepartment;
        this.managerExperience = managerExperience;
    }

    public Manager(BigInteger managerId, String managerDepartment, int managerExperience) {
        this.managerId = managerId;
        this.managerDepartment = managerDepartment;
        this.managerExperience = managerExperience;
    }

    public BigInteger getManagerId() {
        return managerId;
    }

    public void setManagerId(BigInteger managerId) {
        this.managerId = managerId;
    }

    public String getManagerDepartment() {
        return managerDepartment;
    }

    public void setManagerDepartment(String managerDepartment) {
        this.managerDepartment = managerDepartment;
    }

    public int getManagerExperience() {
        return managerExperience;
    }

    public void setManagerExperience(int managerExperience) {
        this.managerExperience = managerExperience;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return managerExperience == manager.managerExperience && managerId.equals(manager.managerId) && managerDepartment.equals(manager.managerDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId, managerDepartment, managerExperience);
    }

    @Override
    public String toString() {
        return "<h2>Отдел:</h2>" + managerDepartment + "\n" +
                "<h2>Стаж:</h2>" + managerExperience + "\n";
    }
}
