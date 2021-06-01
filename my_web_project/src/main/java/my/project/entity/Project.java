package my.project.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_budget")
    private int projectBudget;

    @Column(name = "project_time_limit")
    private int projectTimeLimit;

    @Column(name = "project_deadline")
    private Date projectDeadline;

    public Project() {
    }

    public Project(String projectName, int projectBudget, int projectTimeLimit, Date projectDeadline) {
        this.projectName = projectName;
        this.projectBudget = projectBudget;
        this.projectTimeLimit = projectTimeLimit;
        this.projectDeadline = projectDeadline;
    }

    public Project(int projectId, String projectName, int projectBudget, int projectTimeLimit, Date projectDeadline) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectBudget = projectBudget;
        this.projectTimeLimit = projectTimeLimit;
        this.projectDeadline = projectDeadline;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(int projectBudget) {
        this.projectBudget = projectBudget;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectTimeLimit() {
        return projectTimeLimit;
    }

    public void setProjectTimeLimit(int projectTimeLimit) {
        this.projectTimeLimit = projectTimeLimit;
    }

    public Date getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectDeadline(Date projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectBudget=" + projectBudget +
                ", projectName='" + projectName + '\'' +
                ", projectTimeLimit=" + projectTimeLimit +
                ", projectDeadline=" + projectDeadline +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectId == project.projectId && projectBudget == project.projectBudget && projectTimeLimit == project.projectTimeLimit && projectName.equals(project.projectName) && projectDeadline.equals(project.projectDeadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectBudget, projectName, projectTimeLimit, projectDeadline);
    }
}
