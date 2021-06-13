package my.project.service.entity;

import my.project.dao.hibernate.entity.ManagerHibernateDao;
import my.project.dao.repository.ManagerRepositoryDao;
import my.project.entity.Employee;
import my.project.entity.Manager;
import my.project.exceptions.ManagerWebException;
import my.project.service.communication.EmployeeManagerCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private EmployeeManagerCommunicationService employeeManagerCommunicationService;

    @Autowired
    private ManagerRepositoryDao managerRepositoryDao;

    private final ManagerHibernateDao dao;

    public ManagerService() {
        dao = new ManagerHibernateDao();
    }

    public BigInteger createManager(String managerDepartmentParam, int managerExperienceParam) {
        checkAllParameterOnException(managerDepartmentParam, managerExperienceParam);
        Manager manager = new Manager(managerDepartmentParam, managerExperienceParam);
//        dao.create(manager);
        managerRepositoryDao.create(manager);
        return manager.getManagerId();
    }

    public void updateManagerById(String updateManagerIdParam, String updateManagerDepartmentParam, int updateManagerExperienceParam) {
        checkAllParameterOnException(updateManagerIdParam, updateManagerDepartmentParam, updateManagerExperienceParam);
        BigInteger employeeId = readManagerById(updateManagerIdParam).getEmployee().getEmployeeId();
        Manager manager = new Manager(new BigInteger(updateManagerIdParam), updateManagerDepartmentParam, updateManagerExperienceParam);
//        dao.update(manager);
        managerRepositoryDao.update(manager);
        employeeManagerCommunicationService.updateCommunication(employeeId, manager.getManagerId());
    }

    public void updateManager(Manager updateManager) {
        BigInteger employeeId = updateManager.getEmployee().getEmployeeId();
        BigInteger managerId = updateManager.getManagerId();
        managerRepositoryDao.update(updateManager);
//        employeeManagerCommunicationService.updateCommunication(employeeId, managerId);
    }

    public void deleteManagerById(BigInteger deleteManagerIdParam) {
        managerRepositoryDao.delete(deleteManagerIdParam);
    }

    public Manager readManagerById(String managerIdParam) {
        BigInteger managerId = new BigInteger(managerIdParam);
        managerRepositoryDao.readById(managerId);
        return managerRepositoryDao.readById(managerId);
    }

    public List<Manager> readAllManager() {
//        List<Manager> managers = dao.readAll();
        return managerRepositoryDao.readAll();
    }

    private void checkAllParameterOnException(String managerDepartmentParam, int managerExperienceParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (managerDepartmentParam.isEmpty()) {
            String errorMessage = "Manager department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (managerExperienceParam < 0) {
            String errorMessage = "Manager experience can't be < 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new ManagerWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String managerIdParam, String managerDepartmentParam, int managerExperienceParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (managerIdParam.isEmpty()) {
            String errorMessage = "Manager id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (managerDepartmentParam.isEmpty()) {
            String errorMessage = "Manager department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (managerExperienceParam < 0) {
            String errorMessage = "Manager experience can't be < 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new ManagerWebException(errorList);
        }
    }

    public EmployeeManagerCommunicationService getEmployeeManagerCommunicationService() {
        return employeeManagerCommunicationService;
    }

    public void setEmployeeManagerCommunicationService(EmployeeManagerCommunicationService employeeManagerCommunicationService) {
        this.employeeManagerCommunicationService = employeeManagerCommunicationService;
    }

    public ManagerRepositoryDao getManagerRepositoryDao() {
        return managerRepositoryDao;
    }

    public void setManagerRepositoryDao(ManagerRepositoryDao managerRepositoryDao) {
        this.managerRepositoryDao = managerRepositoryDao;
    }
}
