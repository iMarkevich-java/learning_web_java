package my.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_activity")
    private String companyActivity;

    public Company() {
    }

    public Company(String companyName, String companyActivity) {
        this.companyName = companyName;
        this.companyActivity = companyActivity;
    }

    public Company(int companyId, String companyName, String companyActivity) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyActivity = companyActivity;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyActivity() {
        return companyActivity;
    }

    public void setCompanyActivity(String companyActivity) {
        this.companyActivity = companyActivity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyActivity='" + companyActivity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return companyId == company.companyId && companyName.equals(company.companyName) && companyActivity.equals(company.companyActivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, companyActivity);
    }
}
