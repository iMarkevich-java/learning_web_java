package my.project.service.entity;

import my.project.dao.hibernate.entity.QAEngineerHibernateDao;
import my.project.dao.repository.QAEngineerRepositoryDao;
import my.project.entity.QaEngineer;
import my.project.exceptions.QAEngineerWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class QAEngineerService {

    final QAEngineerHibernateDao dao;
    @Autowired
    QAEngineerRepositoryDao qaEngineerRepositoryDao;

    public QAEngineerService() {
        this.dao = new QAEngineerHibernateDao();
    }

    public BigInteger createQAEngineer(String qAEngineerDepartmentParam, String qAEngineerExperienceStringParam) {
        checkAllParameterOnException(qAEngineerDepartmentParam, qAEngineerExperienceStringParam);
        int qAEngineerExperienceInteger = Integer.parseInt(qAEngineerExperienceStringParam);
        QaEngineer qAEngineer = new QaEngineer(qAEngineerDepartmentParam, qAEngineerExperienceInteger);
//        dao.create(qAEngineer);
        qaEngineerRepositoryDao.create(qAEngineer);
        return qAEngineer.getqAEngineerId();
    }

    public void updateQAEngineerById(String updateQAEngineerIdParam, String updateQAEngineerDepartmentParam, String updateQAEngineerExperienceParam) {
        checkAllParameterOnException(updateQAEngineerIdParam, updateQAEngineerDepartmentParam, updateQAEngineerExperienceParam);
        BigInteger employeeId = new BigInteger(updateQAEngineerIdParam);
        int qaEngineerExperience = Integer.parseInt(updateQAEngineerExperienceParam);
        QaEngineer qaEngineer = new QaEngineer(employeeId, updateQAEngineerDepartmentParam, qaEngineerExperience);
//        dao.update(qaEngineer);
        qaEngineerRepositoryDao.update(qaEngineer);
    }

    public void deleteQAEngineerById(String deleteQAEngineerIdParam) {
        BigInteger deleteQAEngineerId = new BigInteger(deleteQAEngineerIdParam);
//        dao.delete(deleteEmployeeId);
        qaEngineerRepositoryDao.delete(deleteQAEngineerId);
    }

    public QaEngineer readQAEngineerById(String qaEngineerIdParam) {
        BigInteger qaEngineerId = new BigInteger(qaEngineerIdParam);
//      dao.readById(employeeId);

        return qaEngineerRepositoryDao.readById(qaEngineerId);
    }

    public List<QaEngineer> readAllQAEngineer() {
//        dao.readAll()
        return qaEngineerRepositoryDao.readAll();
    }

    private void checkAllParameterOnException(String qAEngineerDepartment, String qAEngineerExperienceString) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (qAEngineerDepartment.isEmpty()) {
            String errorMessage = "QAEngineer department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (qAEngineerExperienceString.isEmpty()) {
            String errorMessage = "QAEngineer experience can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new QAEngineerWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String qAEngineerId, String qAEngineerDepartment, String qAEngineerExperienceString) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (qAEngineerId.isEmpty()) {
            String errorMessage = "QAEngineer id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (qAEngineerDepartment.isEmpty()) {
            String errorMessage = "QAEngineer department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (qAEngineerExperienceString.isEmpty()) {
            String errorMessage = "QAEngineer experience can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new QAEngineerWebException(errorList);
        }
    }
}
