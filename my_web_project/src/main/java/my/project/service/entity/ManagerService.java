package my.project.service.entity;

import my.project.dao.hibernate.entity.ManagerHibernateDao;
import my.project.entity.Manager;
import my.project.exceptions.DeveloperWebException;
import my.project.exceptions.EmployeeWebException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {
    private boolean flag = false;

    private ManagerHibernateDao dao;

    public ManagerService() {
        dao = new ManagerHibernateDao();
    }

    public BigInteger createManager(String managerDepartmentParam, String managerExperienceParam) {
        int managerExperience = Integer.parseInt(managerExperienceParam);
        Manager manager = new Manager(managerDepartmentParam, managerExperience);
        dao.create(manager);
        return manager.getManagerId();
    }

    public void updateManagerById(String updateDeveloperIdParam, String updateDeveloperDepartmentParam, String updateDeveloperExperienceParam) {
        ArrayList<String> errorList = new ArrayList<>();
        if (updateDeveloperDepartmentParam.isEmpty() || updateDeveloperExperienceParam.isEmpty()) {
            String errorMessage = "Department or experience  can't be empty";
            errorList.add(errorMessage);
            throw new DeveloperWebException(errorList);
        }

        BigInteger updateDeveloperId = new BigInteger(updateDeveloperIdParam);
        int updateDeveloperExperience = Integer.parseInt(updateDeveloperExperienceParam);
        Manager manager = new Manager();
        dao.update(manager);
    }

    public void deleteDeveloperById(String deleteDeveloperIdParam) {
        BigInteger deleteClientId = new BigInteger(deleteDeveloperIdParam);
        dao.delete(deleteClientId);
    }

    public Manager readManagerById(String developerIdPParam) {
        BigInteger developerId = new BigInteger(developerIdPParam);

        return new Manager();
    }

    public List<Manager> readAllManager() {
        List<Manager> managers = dao.readAll();
        return managers;
    }

    public List<Manager> readAllManagerByParameter(String selectEmployeeIdParam, String selectEmployeeFirstNameParam, String selectEmployeeSurnameParam,
                                                   String selectEmployeeDateOfBornParam, String selectEmployeePositionParam) {
        flag = false;
        String hql = checkAllParameter(selectEmployeeIdParam, selectEmployeeFirstNameParam, selectEmployeeSurnameParam, selectEmployeeDateOfBornParam, selectEmployeePositionParam);
        hql = checkParameter("employee.employeeId", selectEmployeeIdParam, hql);
        hql = checkParameter("employee.employeeFirstName", selectEmployeeFirstNameParam, hql);
        hql = checkParameter("employee.employeeSurname", selectEmployeeSurnameParam, hql);
        hql = checkParameter("employee.employeeDateOfBorn", selectEmployeeDateOfBornParam, hql);
        hql = checkParameter("employee.employeePosition", selectEmployeePositionParam, hql);
        return dao.readAllByHqlQuery(hql);
    }

    private String checkAllParameter(String... parameter) {
        String hqlString;
        if (parameter[0].isEmpty() && parameter[1].isEmpty() && parameter[2].isEmpty() &&
                parameter[3].isEmpty() && parameter[4].isEmpty()) {
            hqlString = "from Employee";
        } else {
            hqlString = "FROM Employee employee WHERE ";
        }
        return hqlString;
    }

    private String checkParameter(String parameterName, String parameterValue, String sql) {
        if (!parameterValue.isEmpty() && this.flag) {
            sql += " and " + parameterName + "='" + parameterValue + "'";
        } else if (!parameterValue.isEmpty()) {
            sql += parameterName + "='" + parameterValue + "'";
            this.flag = true;
        }
        return sql;
    }

    private void checkAllParameterOnException(String employeeFirstNameParam, String employeeSurnameParam, String employeeDateOfBornParam, String employeePositionParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (employeeFirstNameParam.isEmpty()) {
            String errorMessage = "Employee first name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeFirstNameParam.isEmpty()) {
            String errorMessage = "Employee first name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeSurnameParam.isEmpty()) {
            String errorMessage = "Employee surname can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeDateOfBornParam.isEmpty()) {
            String errorMessage = "Employee date of born can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeePositionParam.isEmpty()) {
            String errorMessage = "Employee position can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new EmployeeWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String employeeId, String employeeFirstNameParam, String employeeSurnameParam, String employeeDateOfBornParam, String employeePositionParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (employeeId.isEmpty()) {
            String errorMessage = "Employee id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeFirstNameParam.isEmpty()) {
            String errorMessage = "Employee first name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeSurnameParam.isEmpty()) {
            String errorMessage = "Employee surname can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeeDateOfBornParam.isEmpty()) {
            String errorMessage = "Employee date of born can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (employeePositionParam.isEmpty()) {
            String errorMessage = "Employee position can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new EmployeeWebException(errorList);
        }
    }
}
