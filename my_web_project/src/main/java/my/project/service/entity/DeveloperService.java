package my.project.service.entity;

import my.project.dao.hibernate.entity.DeveloperHibernateDao;
import my.project.dao.repository.DeveloperRepositoryDao;
import my.project.entity.Developer;
import my.project.exceptions.DeveloperWebException;
import my.project.service.communication.EmployeeDeveloperCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperService {

    private final DeveloperHibernateDao dao;
    @Autowired
    private DeveloperRepositoryDao developerRepositoryDao;
    @Autowired
    private EmployeeDeveloperCommunicationService employeeDeveloperCommunicationService;

    public DeveloperService() {
        dao = new DeveloperHibernateDao();
    }

    public BigInteger createDeveloper(String developerDepartmentParam, int developerExperienceParam) {
        checkAllParameterOnException(developerDepartmentParam, developerExperienceParam);
        Developer developer = new Developer(developerDepartmentParam, developerExperienceParam);
//        dao.create(developer);
        developerRepositoryDao.create(developer);
        return developer.getDeveloperId();
    }

    public void createDeveloper(Developer developer, BigInteger employeeId) {
        developerRepositoryDao.create(developer);
        employeeDeveloperCommunicationService.createCommunication(employeeId, developer.getDeveloperId());
    }

    public void updateDeveloperById(String updateDeveloperIdParam, String updateDeveloperDepartmentParam, int updateDeveloperExperienceParam) {
        checkAllParameterOnException(updateDeveloperIdParam, updateDeveloperDepartmentParam, updateDeveloperExperienceParam);
        BigInteger updateDeveloperId = new BigInteger(updateDeveloperIdParam);
        Developer updateDeveloper = new Developer(updateDeveloperId, updateDeveloperDepartmentParam, updateDeveloperExperienceParam);
//        dao.update(updateDeveloper);
        developerRepositoryDao.update(updateDeveloper);
    }

    public void updateDeveloper(Developer updateDeveloper) {
//        BigInteger employeeId = updateDeveloper.getEmployee().getEmployeeId();
//        BigInteger developerId = updateDeveloper.getDeveloperId();
        developerRepositoryDao.update(updateDeveloper);
//        employeeDeveloperCommunicationService.updateCommunication(employeeId, developerId);
    }

    public void deleteDeveloperById(String deleteDeveloperIdParam) {
        BigInteger deleteDeveloperId = new BigInteger(deleteDeveloperIdParam);
//        dao.delete(deleteClientId);
        developerRepositoryDao.delete(deleteDeveloperId);
    }

    public void deleteDeveloperById(BigInteger deleteDeveloperIdParam) {
        developerRepositoryDao.delete(deleteDeveloperIdParam);
    }

    public void deleteDeveloperByIdWithCommunication(BigInteger deleteDeveloperId, BigInteger employeeId) {
        developerRepositoryDao.delete(deleteDeveloperId);
        employeeDeveloperCommunicationService.deleteCommunicationByEmployeeId(employeeId);
    }

    public Developer readDeveloperById(String developerIdPParam) {
        BigInteger developerId = new BigInteger(developerIdPParam);
//        dao.readById(developerId);
        return developerRepositoryDao.readById(developerId);
    }

    public List<Developer> readAllDeveloper() {
//        dao.readAll();
        return developerRepositoryDao.readAll();
    }

    private void checkAllParameterOnException(String developerDepartmentParam, int developerExperienceParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (developerDepartmentParam.isEmpty()) {
            String errorMessage = "Developer department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (developerExperienceParam < 0) {
            String errorMessage = "Developer experience can't be < 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new DeveloperWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String developerIdParam, String developerDepartmentParam, int developerExperienceParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (developerIdParam.isEmpty()) {
            String errorMessage = "Developer id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (developerDepartmentParam.isEmpty()) {
            String errorMessage = "Developer department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (developerExperienceParam < 0) {
            String errorMessage = "Developer experience can't be < 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new DeveloperWebException(errorList);
        }
    }

    public DeveloperRepositoryDao getDeveloperRepositoryDao() {
        return developerRepositoryDao;
    }

    public void setDeveloperRepositoryDao(DeveloperRepositoryDao developerRepositoryDao) {
        this.developerRepositoryDao = developerRepositoryDao;
    }

    public EmployeeDeveloperCommunicationService getEmployeeDeveloperCommunicationService() {
        return employeeDeveloperCommunicationService;
    }

    public void setEmployeeDeveloperCommunicationService(EmployeeDeveloperCommunicationService employeeDeveloperCommunicationService) {
        this.employeeDeveloperCommunicationService = employeeDeveloperCommunicationService;
    }
}
