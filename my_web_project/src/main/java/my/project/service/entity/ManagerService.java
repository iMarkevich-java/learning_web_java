package my.project.service.entity;

import my.project.dao.hibernate.entity.ManagerHibernateDao;
import my.project.dao.repository.ManagerRepositoryDao;
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
    EmployeeManagerCommunicationService employeeManagerCommunicationService;

    @Autowired
    ManagerRepositoryDao managerRepositoryDao;

    private final ManagerHibernateDao dao;

    public ManagerService() {
        dao = new ManagerHibernateDao();
    }

    public BigInteger createManager(String managerDepartmentParam, String managerExperienceParam) {
        checkAllParameterOnException(managerDepartmentParam, managerExperienceParam);
        int managerExperience = Integer.parseInt(managerExperienceParam);
        Manager manager = new Manager(managerDepartmentParam, managerExperience);
//        dao.create(manager);
        managerRepositoryDao.create(manager);
        return manager.getManagerId();
    }

    public void updateManagerById(String updateManagerIdParam, String updateManagerDepartmentParam, String updateManagerExperienceParam) {
        checkAllParameterOnException(updateManagerIdParam, updateManagerDepartmentParam, updateManagerExperienceParam);
        int updateManagerExperience = Integer.parseInt(updateManagerExperienceParam);
        BigInteger employeeId = readManagerById(updateManagerIdParam).getEmployee().getEmployeeId();
        Manager manager = new Manager(new BigInteger(updateManagerIdParam), updateManagerDepartmentParam, updateManagerExperience);
//        dao.update(manager);
        managerRepositoryDao.update(manager);
        employeeManagerCommunicationService.updateCommunication(employeeId, manager.getManagerId());
    }

    public void deleteManagerById(String deleteManagerIdParam) {
        BigInteger deleteManagerId = new BigInteger(deleteManagerIdParam);
//        dao.delete(deleteManagerId);
        managerRepositoryDao.delete(deleteManagerId);
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

    private void checkAllParameterOnException(String managerDepartmentParam, String managerExperienceParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (managerDepartmentParam.isEmpty()) {
            String errorMessage = "Manager department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (managerExperienceParam.isEmpty()) {
            String errorMessage = "Manager experience can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new ManagerWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String managerIdParam, String managerDepartmentParam, String managerExperienceParam) {
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
        if (managerExperienceParam.isEmpty()) {
            String errorMessage = "Manager experience can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new ManagerWebException(errorList);
        }
    }
}
