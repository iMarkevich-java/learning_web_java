package my.project.service.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.entity.ProjectHibernateDao;
import my.project.entity.Project;
import my.project.exceptions.DeveloperWebException;
import my.project.exceptions.ProjectWebException;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private Dao dao;

    public ProjectService() {
        dao = new ProjectHibernateDao();
    }

    public void createProject(String projectNameParam, String projectBudgetParam, String projectTimeLimitParam, String projectDeadlineParam) throws ProjectWebException {
        ArrayList<String> errorList = new ArrayList<>();

        if (projectBudgetParam.isEmpty() || projectNameParam.isEmpty() || projectTimeLimitParam.isEmpty() || projectDeadlineParam.isEmpty()) {
            String errorMessage = "Name, budget, time limit or deadline experience  can't be empty";
            errorList.add(errorMessage);
            throw new DeveloperWebException(errorList);
        }

        int budget = Integer.parseInt(projectBudgetParam);
        int timeLimit = Integer.parseInt(projectTimeLimitParam);
        Date deadLine = new StringToSqlDate().parse(projectDeadlineParam);
        Project project = new Project(projectNameParam, budget, timeLimit, deadLine);
        dao.create(project);
    }

    public void updateProjectById(String updateProjectIdParam, String updateProjectNameParam, String updateProjectBudgetParam, String updateProjectTimeLimitParam, String updateProjectDeadlineParam) {
        ArrayList<String> errorList = new ArrayList<>();

        if (updateProjectBudgetParam.isEmpty() || updateProjectNameParam.isEmpty() || updateProjectTimeLimitParam.isEmpty() || updateProjectDeadlineParam.isEmpty()) {
            String errorMessage = "Name, budget, time limit or deadline experience  can't be empty";
            errorList.add(errorMessage);
            throw new DeveloperWebException(errorList);
        }

        int projectId = Integer.parseInt(updateProjectIdParam);
        int updateProjectBudget = Integer.parseInt(updateProjectBudgetParam);
        int timeLimit = Integer.parseInt(updateProjectTimeLimitParam);
        Date deadLine = new StringToSqlDate().parse(updateProjectDeadlineParam);
        Project updateProject = new Project(projectId, updateProjectNameParam, updateProjectBudget, timeLimit, deadLine);
        dao.update(updateProject);
    }

    public void deleteProjectById(String deleteProjectIdParam) {
        BigInteger deleteProjectId = new BigInteger(deleteProjectIdParam);
        dao.delete(deleteProjectId);
    }

    public Project readProjectById(BigInteger projectId) {
        Project project = (Project) dao.readById(projectId);
        return project;
    }

    public List<Project> readAllProject() {
        List<Project> projects = dao.readAll();
        return projects;
    }
}
