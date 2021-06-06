package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "qa_engineer")
public class QaEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qa_engineer_id")
    private BigInteger qAEngineerId;

    @Column(name = "qa_engineer_department")
    private String qaEngineerDepartment;

    @Column(name = "qa_engineer_experience")
    private int qaEngineerExperience;

    @OneToOne
    @JoinTable(name = "employee_qa_engineer_communication", joinColumns = @JoinColumn(name = "qa_engineer_id_fk"), inverseJoinColumns = @JoinColumn(name = "employee_id_fk"))
    private Employee employee;

    public QaEngineer() {
    }

    public QaEngineer(String qaEngineerDepartment, int qaEngineerExperience) {
        this.qaEngineerDepartment = qaEngineerDepartment;
        this.qaEngineerExperience = qaEngineerExperience;
    }

    public QaEngineer(BigInteger qAEngineerId, String qaEngineerDepartment, int qaEngineerExperience) {
        this.qAEngineerId = qAEngineerId;
        this.qaEngineerDepartment = qaEngineerDepartment;
        this.qaEngineerExperience = qaEngineerExperience;
    }

    public BigInteger getqAEngineerId() {
        return qAEngineerId;
    }

    public void setqAEngineerId(BigInteger qAEngineerId) {
        this.qAEngineerId = qAEngineerId;
    }

    public String getQaEngineerDepartment() {
        return qaEngineerDepartment;
    }

    public void setQaEngineerDepartment(String qaEngineerDepartment) {
        this.qaEngineerDepartment = qaEngineerDepartment;
    }

    public int getQaEngineerExperience() {
        return qaEngineerExperience;
    }

    public void setQaEngineerExperience(int qaEngineerExperience) {
        this.qaEngineerExperience = qaEngineerExperience;
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
        QaEngineer that = (QaEngineer) o;
        return qaEngineerExperience == that.qaEngineerExperience && qAEngineerId.equals(that.qAEngineerId) && qaEngineerDepartment.equals(that.qaEngineerDepartment) && employee.equals(that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qAEngineerId, qaEngineerDepartment, qaEngineerExperience, employee);
    }

    @Override
    public String toString() {
        return "<h2>Отдел:</h2>" + qaEngineerDepartment + "\n" +
                "<h2>Стаж:</h2>" + qaEngineerExperience + "\n";
    }
}
