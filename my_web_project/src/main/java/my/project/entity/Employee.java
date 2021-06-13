package my.project.entity;

import lombok.Builder;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;

@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private BigInteger employeeId;

    @Column(name = "employee_photo")
    private Blob photo;

    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @Column(name = "employee_surname")
    private String employeeSurname;

    @Column(name = "date_of_born")
    private Date employeeDateOfBorn;

    @Column(name = "employee_position")
    private String employeePosition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_address_communication", joinColumns = @JoinColumn(name = "employee_id_fk"), inverseJoinColumns = @JoinColumn(name = "address_id_fk"))
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_developer_communication", joinColumns = @JoinColumn(name = "employee_id_fk"), inverseJoinColumns = @JoinColumn(name = "developer_id_fk"))
    private Developer developer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_manager_communication", joinColumns = @JoinColumn(name = "employee_id_fk"), inverseJoinColumns = @JoinColumn(name = "manager_id_fk"))
    private Manager manager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_qa_engineer_communication", joinColumns = @JoinColumn(name = "employee_id_fk"), inverseJoinColumns = @JoinColumn(name = "qa_engineer_id_fk"))
    private QaEngineer qaEngineer;

    public Employee() {
    }

    public Employee(Blob photo, String employeeFirstName, String employeeSurname, Date employeeDateOfBorn, String employeePosition) {
        this.photo = photo;
        this.employeeFirstName = employeeFirstName;
        this.employeeSurname = employeeSurname;
        this.employeeDateOfBorn = employeeDateOfBorn;
        this.employeePosition = employeePosition;
    }

    public Employee(BigInteger employeeId, Blob photo, String employeeFirstName, String employeeSurname, Date employeeDateOfBorn, String employeePosition) {
        this.employeeId = employeeId;
        this.photo = photo;
        this.employeeFirstName = employeeFirstName;
        this.employeeSurname = employeeSurname;
        this.employeeDateOfBorn = employeeDateOfBorn;
        this.employeePosition = employeePosition;
    }

    public Employee(BigInteger employeeId, Blob photo, String employeeFirstName, String employeeSurname, Date employeeDateOfBorn, String employeePosition, Address address, Developer developer, Manager manager, QaEngineer qaEngineer) {
        this.employeeId = employeeId;
        this.photo = photo;
        this.employeeFirstName = employeeFirstName;
        this.employeeSurname = employeeSurname;
        this.employeeDateOfBorn = employeeDateOfBorn;
        this.employeePosition = employeePosition;
        this.address = address;
        this.developer = developer;
        this.manager = manager;
        this.qaEngineer = qaEngineer;
    }

    public BigInteger getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(BigInteger employeeId) {
        this.employeeId = employeeId;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public Date getEmployeeDateOfBorn() {
        return employeeDateOfBorn;
    }

    public void setEmployeeDateOfBorn(Date employeeDateOfBorn) {
        this.employeeDateOfBorn = employeeDateOfBorn;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public QaEngineer getQaEngineer() {
        return qaEngineer;
    }

    public void setQaEngineer(QaEngineer qaEngineer) {
        this.qaEngineer = qaEngineer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId) && photo.equals(employee.photo) && employeeFirstName.equals(employee.employeeFirstName) && employeeSurname.equals(employee.employeeSurname) && employeeDateOfBorn.equals(employee.employeeDateOfBorn) && employeePosition.equals(employee.employeePosition) && developer.equals(employee.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, photo, employeeFirstName, employeeSurname, employeeDateOfBorn, employeePosition, developer);
    }

    @Override
    public String toString() {
        return "<h2>Имя:</h2> " + employeeFirstName + "\n" +
                "<h2>Фамилия:</h2>" + employeeSurname + "\n" +
                "<h2>Дата рождения:</h2>" + employeeDateOfBorn + "\n" +
                "<h2>Должность:</h2>" + employeePosition + "\n";
    }
}
