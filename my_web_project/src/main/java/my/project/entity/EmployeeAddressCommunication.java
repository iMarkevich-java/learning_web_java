package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "employee_address_communication")
public class EmployeeAddressCommunication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_address_communication_id")
    private BigInteger employeeAddressId;

    @Column(name = "employee_id_fk")
    private BigInteger employeeIdFk;

    @Column(name = "address_id_fk")
    private BigInteger addressIdFk;

    public EmployeeAddressCommunication() {
    }

    public EmployeeAddressCommunication(BigInteger employeeIdFk, BigInteger addressIdFk) {
        this.employeeIdFk = employeeIdFk;
        this.addressIdFk = addressIdFk;
    }

    public EmployeeAddressCommunication(BigInteger employeeAddressId, BigInteger employeeIdFk, BigInteger addressIdFk) {
        this.employeeAddressId = employeeAddressId;
        this.employeeIdFk = employeeIdFk;
        this.addressIdFk = addressIdFk;
    }

    public BigInteger getEmployeeAddressId() {
        return employeeAddressId;
    }

    public void setEmployeeAddressId(BigInteger employeeAddressId) {
        this.employeeAddressId = employeeAddressId;
    }

    public BigInteger getEmployeeIdFk() {
        return employeeIdFk;
    }

    public void setEmployeeIdFk(BigInteger employeeIdFk) {
        this.employeeIdFk = employeeIdFk;
    }

    public BigInteger getAddressIdFk() {
        return addressIdFk;
    }

    public void setAddressIdFk(BigInteger addressIdFk) {
        this.addressIdFk = addressIdFk;
    }

}
