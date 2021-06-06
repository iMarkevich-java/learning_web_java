package my.project.service.entity;

import my.project.dao.hibernate.entity.DeveloperHibernateDao;
import my.project.dao.repository.DeveloperRepositoryDao;
import my.project.entity.Developer;
import my.project.exceptions.DeveloperWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperService {

    @Autowired
    DeveloperRepositoryDao developerRepositoryDao;

    private final DeveloperHibernateDao dao;

    public DeveloperService() {
        dao = new DeveloperHibernateDao();
    }

    public BigInteger createDeveloper(String developerDepartmentParam, String developerExperienceParam) {
        checkAllParameterOnException(developerDepartmentParam, developerExperienceParam);
        int experience = Integer.parseInt(developerExperienceParam);
        Developer developer = new Developer(developerDepartmentParam, experience);
//        dao.create(developer);
        developerRepositoryDao.create(developer);
        return developer.getDeveloperId();
    }

    public void updateDeveloperById(String updateDeveloperIdParam, String updateDeveloperDepartmentParam, String updateDeveloperExperienceParam) {
        checkAllParameterOnException(updateDeveloperIdParam, updateDeveloperDepartmentParam, updateDeveloperExperienceParam);
        BigInteger updateDeveloperId = new BigInteger(updateDeveloperIdParam);
        int updateDeveloperExperience = Integer.parseInt(updateDeveloperExperienceParam);
        Developer updateDeveloper = new Developer(updateDeveloperId, updateDeveloperDepartmentParam, updateDeveloperExperience);
//        dao.update(updateDeveloper);
        developerRepositoryDao.update(updateDeveloper);
    }

    public void deleteDeveloperById(String deleteDeveloperIdParam) {
        BigInteger deleteDeveloperId = new BigInteger(deleteDeveloperIdParam);
//        dao.delete(deleteClientId);
        developerRepositoryDao.delete(deleteDeveloperId);
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

    private void checkAllParameterOnException(String developerDepartmentParam, String developerExperienceParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (developerDepartmentParam.isEmpty()) {
            String errorMessage = "Developer department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (developerExperienceParam.isEmpty()) {
            String errorMessage = "Developer experience can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new DeveloperWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String developerIdParam, String developerDepartmentParam, String developerExperienceParam) {
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
        if (developerExperienceParam.isEmpty()) {
            String errorMessage = "Developer experience can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new DeveloperWebException(errorList);
        }
    }
}
