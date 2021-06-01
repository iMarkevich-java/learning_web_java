package my.project.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "name")
    private String name;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "outsourc")
    private Boolean outsource;

    @ManyToMany
    @JoinTable(
            name = "project_developer",
            joinColumns = {@JoinColumn(name = "project_id_fk")},
            inverseJoinColumns = {@JoinColumn(name = "developer_id_fk")}
    )
    private Set<Developer> developerList;


    public Project() {
    }

    public Project(String name, Date dateCreate, Boolean outsource) {
        this.name = name;
        this.dateCreate = dateCreate;
        this.outsource = outsource;
    }

    public Project(int projectId, String name, Date dateCreate, Boolean outsource) {
        this.projectId = projectId;
        this.name = name;
        this.dateCreate = dateCreate;
        this.outsource = outsource;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Boolean getOutsource() {
        return outsource;
    }

    public void setOutsource(Boolean outsource) {
        this.outsource = outsource;
    }

    public Set<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(Set<Developer> developerList) {
        this.developerList = developerList;
    }
}
