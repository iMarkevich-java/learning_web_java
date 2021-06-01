package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "employee_developer_communication")
public class EmployeeDeveloperCommunication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_developer_communication_id")
    private BigInteger employeeDeveloperId;

    @Column(name = "employee_id_fk")
    private BigInteger employeeIdFk;

    @Column(name = "developer_id_fk")
    private BigInteger developerIdFk;

    public EmployeeDeveloperCommunication() {
    }

    public EmployeeDeveloperCommunication(BigInteger employeeIdFk, BigInteger developerIdFk) {
        this.employeeIdFk = employeeIdFk;
        this.developerIdFk = developerIdFk;
    }

    public EmployeeDeveloperCommunication(BigInteger employeeDeveloperId, BigInteger employeeIdFk, BigInteger developerIdFk) {
        this.employeeDeveloperId = employeeDeveloperId;
        this.employeeIdFk = employeeIdFk;
        this.developerIdFk = developerIdFk;
    }

    public BigInteger getEmployeeDeveloperId() {
        return employeeDeveloperId;
    }

    public void setEmployeeDeveloperId(BigInteger employeeDeveloperId) {
        this.employeeDeveloperId = employeeDeveloperId;
    }

    public BigInteger getEmployeeIdFk() {
        return employeeIdFk;
    }

    public void setEmployeeIdFk(BigInteger employeeIdFk) {
        this.employeeIdFk = employeeIdFk;
    }

    public BigInteger getDeveloperIdFk() {
        return developerIdFk;
    }

    public void setDeveloperIdFk(BigInteger developerIdFk) {
        this.developerIdFk = developerIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDeveloperCommunication that = (EmployeeDeveloperCommunication) o;
        return employeeDeveloperId.equals(that.employeeDeveloperId) && employeeIdFk.equals(that.employeeIdFk) && developerIdFk.equals(that.developerIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeDeveloperId, employeeIdFk, developerIdFk);
    }
}
