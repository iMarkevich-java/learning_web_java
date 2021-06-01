package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "qa_engineer")
public class QAEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qa_engineer_id")
    private BigInteger qAEngineerId;

    @Column(name = "qa_engineer_department")
    private String qAEngineerDepartment;

    @Column(name = "qa_engineer_experience")
    private int qAEngineerExperience;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_qa_engineer_communication", joinColumns = @JoinColumn(name = "qa_engineer_id_fk"), inverseJoinColumns = @JoinColumn(name = "employee_id_fk"))
    private Employee employee;

    public QAEngineer() {
    }

    public QAEngineer(String qAEngineerDepartment, int qAEngineerExperience) {
        this.qAEngineerDepartment = qAEngineerDepartment;
        this.qAEngineerExperience = qAEngineerExperience;
    }

    public QAEngineer(BigInteger qAEngineerId, String qAEngineerDepartment, int qAEngineerExperience) {
        this.qAEngineerId = qAEngineerId;
        this.qAEngineerDepartment = qAEngineerDepartment;
        this.qAEngineerExperience = qAEngineerExperience;
    }

    public BigInteger getQAEngineerId() {
        return qAEngineerId;
    }

    public void setQAEngineerId(BigInteger qAEngineerId) {
        this.qAEngineerId = qAEngineerId;
    }

    public String getQAEngineerDepartment() {
        return qAEngineerDepartment;
    }

    public void setQAEngineerDepartment(String qAEngineerDepartment) {
        this.qAEngineerDepartment = qAEngineerDepartment;
    }

    public int getQAEngineerExperience() {
        return qAEngineerExperience;
    }

    public void setQAEngineerExperience(int qAEngineerExperience) {
        this.qAEngineerExperience = qAEngineerExperience;
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
        QAEngineer that = (QAEngineer) o;
        return qAEngineerExperience == that.qAEngineerExperience && qAEngineerId.equals(that.qAEngineerId) && qAEngineerDepartment.equals(that.qAEngineerDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qAEngineerId, qAEngineerDepartment, qAEngineerExperience);
    }

    @Override
    public String toString() {
        return "<h2>Отдел:</h2>" + qAEngineerDepartment + "\n" +
                "<h2>Стаж:</h2>" + qAEngineerExperience + "\n";
    }
}
