package my.project.service.entity;

import my.project.dao.hibernate.entity.QAEngineerHibernateDao;
import my.project.dao.repository.QAEngineerRepositoryDao;
import my.project.entity.QaEngineer;
import my.project.exceptions.QAEngineerWebException;
import my.project.service.communication.EmployeeQAEngineerCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class QAEngineerService {

    @Autowired
    private QAEngineerRepositoryDao qaEngineerRepositoryDao;

    @Autowired
    private EmployeeQAEngineerCommunicationService employeeQAEngineerCommunicationService;

    final QAEngineerHibernateDao dao;

    public QAEngineerService() {
        this.dao = new QAEngineerHibernateDao();
    }

    public BigInteger createQAEngineer(String qAEngineerDepartmentParam, int qAEngineerExperienceStringParam) {
        checkAllParameterOnException(qAEngineerDepartmentParam, qAEngineerExperienceStringParam);
        QaEngineer qAEngineer = new QaEngineer(qAEngineerDepartmentParam, qAEngineerExperienceStringParam);
//        dao.create(qAEngineer);
        qaEngineerRepositoryDao.create(qAEngineer);
        return qAEngineer.getqAEngineerId();
    }

    public void updateQAEngineerById(String updateQAEngineerIdParam, String updateQAEngineerDepartmentParam, int updateQAEngineerExperienceParam) {
        checkAllParameterOnException(updateQAEngineerIdParam, updateQAEngineerDepartmentParam, updateQAEngineerExperienceParam);
        BigInteger employeeId = new BigInteger(updateQAEngineerIdParam);
        QaEngineer qaEngineer = new QaEngineer(employeeId, updateQAEngineerDepartmentParam, updateQAEngineerExperienceParam);
//        dao.update(qaEngineer);
        qaEngineerRepositoryDao.update(qaEngineer);
    }

    public void updateQAEngineer(QaEngineer qaEngineer) {
        BigInteger employeeId = qaEngineer.getEmployee().getEmployeeId();
        BigInteger qaEngineerId = qaEngineer.getqAEngineerId();
        qaEngineerRepositoryDao.update(qaEngineer);
        employeeQAEngineerCommunicationService.updateCommunication(employeeId, qaEngineerId);
    }

    public void deleteQAEngineerById(String deleteQAEngineerIdParam) {
        BigInteger deleteQAEngineerId = new BigInteger(deleteQAEngineerIdParam);
//        dao.delete(deleteEmployeeId);
        qaEngineerRepositoryDao.delete(deleteQAEngineerId);
    }

    public void deleteQAEngineerById(BigInteger deleteQAEngineerIdParam) {
        qaEngineerRepositoryDao.delete(deleteQAEngineerIdParam);
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

    private void checkAllParameterOnException(String qAEngineerDepartment, int qAEngineerExperienceString) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (qAEngineerDepartment.isEmpty()) {
            String errorMessage = "QAEngineer department can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (qAEngineerExperienceString < 0) {
            String errorMessage = "QAEngineer experience can't be < 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new QAEngineerWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String qAEngineerId, String qAEngineerDepartment, int qAEngineerExperienceString) {
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
        if (qAEngineerExperienceString < 0) {
            String errorMessage = "QAEngineer experience can't be < 0!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new QAEngineerWebException(errorList);
        }
    }

    public QAEngineerRepositoryDao getQaEngineerRepositoryDao() {
        return qaEngineerRepositoryDao;
    }

    public void setQaEngineerRepositoryDao(QAEngineerRepositoryDao qaEngineerRepositoryDao) {
        this.qaEngineerRepositoryDao = qaEngineerRepositoryDao;
    }

    public EmployeeQAEngineerCommunicationService getEmployeeQAEngineerCommunicationService() {
        return employeeQAEngineerCommunicationService;
    }

    public void setEmployeeQAEngineerCommunicationService(EmployeeQAEngineerCommunicationService employeeQAEngineerCommunicationService) {
        this.employeeQAEngineerCommunicationService = employeeQAEngineerCommunicationService;
    }
}
