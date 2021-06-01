package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "employee_manager_communication")
public class EmployeeManagerCommunication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_manager_communication_id")
    private BigInteger employeeManagerId;

    @Column(name = "employee_id_fk")
    private BigInteger employeeIdFk;

    @Column(name = "manager_id_fk")
    private BigInteger managerIdFk;

    public EmployeeManagerCommunication() {
    }

    public EmployeeManagerCommunication(BigInteger employeeIdFk, BigInteger managerIdFk) {
        this.employeeIdFk = employeeIdFk;
        this.managerIdFk = managerIdFk;
    }

    public EmployeeManagerCommunication(BigInteger employeeManagerId, BigInteger employeeIdFk, BigInteger managerIdFk) {
        this.employeeManagerId = employeeManagerId;
        this.employeeIdFk = employeeIdFk;
        this.managerIdFk = managerIdFk;
    }

    public BigInteger getEmployeeManagerId() {
        return employeeManagerId;
    }

    public void setEmployeeManagerId(BigInteger employeeManagerId) {
        this.employeeManagerId = employeeManagerId;
    }

    public BigInteger getEmployeeIdFk() {
        return employeeIdFk;
    }

    public void setEmployeeIdFk(BigInteger employeeIdFk) {
        this.employeeIdFk = employeeIdFk;
    }

    public BigInteger getManagerIdFk() {
        return managerIdFk;
    }

    public void setManagerIdFk(BigInteger managerIdFk) {
        this.managerIdFk = managerIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeManagerCommunication that = (EmployeeManagerCommunication) o;
        return employeeManagerId.equals(that.employeeManagerId) && employeeIdFk.equals(that.employeeIdFk) && managerIdFk.equals(that.managerIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeManagerId, employeeIdFk, managerIdFk);
    }
}
