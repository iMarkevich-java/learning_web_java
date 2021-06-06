package my.project.service.entity;

import my.project.dao.hibernate.entity.ProjectHibernateDao;
import my.project.dao.repository.ProjectRepositoryDao;
import my.project.entity.Project;
import my.project.exceptions.ProjectWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectHibernateDao dao;
    @Autowired
    ProjectRepositoryDao projectRepositoryDao;

    public ProjectService() {
        dao = new ProjectHibernateDao();
    }

    public BigInteger createProject(String projectNameParam, String projectBudgetParam, String projectTimeLimitParam, String projectDeadlineParam) {
        checkAllParameterOnException(projectNameParam, projectBudgetParam, projectTimeLimitParam, projectDeadlineParam);
        int budget = Integer.parseInt(projectBudgetParam);
        int timeLimit = Integer.parseInt(projectTimeLimitParam);
        Date deadLine = new StringToSqlDate().parse(projectDeadlineParam);
        Project project = new Project(projectNameParam, budget, timeLimit, deadLine);
//        dao.create(project);
        projectRepositoryDao.create(project);
        return project.getProjectId();
    }

    public void updateProjectById(String updateProjectIdParam, String updateProjectNameParam, String updateProjectBudgetParam, String updateProjectTimeLimitParam, String updateProjectDeadlineParam) {
        checkAllParameterOnException(updateProjectIdParam, updateProjectNameParam, updateProjectBudgetParam, updateProjectTimeLimitParam, updateProjectDeadlineParam);
        BigInteger projectId = new BigInteger(updateProjectIdParam);
        int updateProjectBudget = Integer.parseInt(updateProjectBudgetParam);
        int timeLimit = Integer.parseInt(updateProjectTimeLimitParam);
        Date deadLine = new StringToSqlDate().parse(updateProjectDeadlineParam);
        Project updateProject = new Project(projectId, updateProjectNameParam, updateProjectBudget, timeLimit, deadLine);
//        dao.update(updateProject);
        projectRepositoryDao.update(updateProject);
    }

    public void deleteProjectById(String deleteProjectIdParam) {
        BigInteger deleteProjectId = new BigInteger(deleteProjectIdParam);
//        dao.delete(deleteProjectId);
        projectRepositoryDao.delete(deleteProjectId);
    }

    public Project readProjectById(BigInteger projectId) {
//        dao.readById(projectId)
        return projectRepositoryDao.readById(projectId);
    }

    public List<Project> readAllProject() {
//        dao.readAll()
        return projectRepositoryDao.readAll();
    }

    private void checkAllParameterOnException(String projectNameParam, String projectBudgetParam, String projectTimeLimitParam, String projectDeadlineParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (projectNameParam.isEmpty()) {
            String errorMessage = "Project name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (projectBudgetParam.isEmpty()) {
            String errorMessage = "Project budget can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (projectTimeLimitParam.isEmpty()) {
            String errorMessage = "Project time limit can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (projectDeadlineParam.isEmpty()) {
            String errorMessage = "Project dead line can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new ProjectWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String projectIdParam, String projectNameParam, String projectBudgetParam, String projectTimeLimitParam, String projectDeadlineParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (projectIdParam.isEmpty()) {
            String errorMessage = "Project id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (projectNameParam.isEmpty()) {
            String errorMessage = "Project name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (projectBudgetParam.isEmpty()) {
            String errorMessage = "Project budget can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (projectTimeLimitParam.isEmpty()) {
            String errorMessage = "Project time limit can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (projectDeadlineParam.isEmpty()) {
            String errorMessage = "Project dead line can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new ProjectWebException(errorList);
        }
    }
}
