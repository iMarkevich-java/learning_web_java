package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "employee_qa_engineer_communication")
public class EmployeeQAEngineerCommunication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_qa_engineer_communication_id")
    private BigInteger employeeQAEngineerId;

    @Column(name = "employee_id_fk")
    private BigInteger employeeIdFk;

    @Column(name = "qa_engineer_id_fk")
    private BigInteger qAEngineerIdFk;

    public EmployeeQAEngineerCommunication() {
    }

    public EmployeeQAEngineerCommunication(BigInteger employeeIdFk, BigInteger qAEngineerIdFk) {
        this.employeeIdFk = employeeIdFk;
        this.qAEngineerIdFk = qAEngineerIdFk;
    }

    public EmployeeQAEngineerCommunication(BigInteger employeeQAEngineerId, BigInteger employeeIdFk, BigInteger qAEngineerIdFk) {
        this.employeeQAEngineerId = employeeQAEngineerId;
        this.employeeIdFk = employeeIdFk;
        this.qAEngineerIdFk = qAEngineerIdFk;
    }

    public BigInteger getEmployeeQAEngineerId() {
        return employeeQAEngineerId;
    }

    public void setEmployeeQAEngineerId(BigInteger employeeQAEngineerId) {
        this.employeeQAEngineerId = employeeQAEngineerId;
    }

    public BigInteger getEmployeeIdFk() {
        return employeeIdFk;
    }

    public void setEmployeeIdFk(BigInteger employeeIdFk) {
        this.employeeIdFk = employeeIdFk;
    }

    public BigInteger getQAEngineerIdFk() {
        return qAEngineerIdFk;
    }

    public void setQAEngineerIdFk(BigInteger qAEngineerIdFk) {
        this.qAEngineerIdFk = qAEngineerIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeQAEngineerCommunication that = (EmployeeQAEngineerCommunication) o;
        return employeeQAEngineerId.equals(that.employeeQAEngineerId) && employeeIdFk.equals(that.employeeIdFk) && qAEngineerIdFk.equals(that.qAEngineerIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeQAEngineerId, employeeIdFk, qAEngineerIdFk);
    }
}
