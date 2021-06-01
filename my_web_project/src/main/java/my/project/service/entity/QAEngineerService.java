package my.project.service.entity;

import my.project.dao.hibernate.entity.QAEngineerHibernateDao;
import my.project.entity.Employee;
import my.project.entity.QAEngineer;
import my.project.exceptions.EmployeeWebException;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QAEngineerService {
    final QAEngineerHibernateDao dao;

    private Boolean flag = false;

    public QAEngineerService() {
        this.dao = new QAEngineerHibernateDao();
    }

    public BigInteger createQAEngineer(String qAEngineerDepartment, String qAEngineerExperienceString) {
        int qAEngineerExperienceInteger= Integer.parseInt(qAEngineerExperienceString);
        QAEngineer qAEngineer = new QAEngineer(qAEngineerDepartment, qAEngineerExperienceInteger);
        dao.create(qAEngineer);
        return qAEngineer.getQAEngineerId();
    }

    public BigInteger createQAEngineer(MultipartFile employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, String employeeDateOfBornParam, String employeePositionParam) {
        checkAllParameterOnException(employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
        Date dateOfBorn = new StringToSqlDate().parse(employeeDateOfBornParam);
        Blob employeePhotoBlob = convertMultiPartFileToBlob(employeePhotoParam, "src/main/webapp/images/tempImage.jpg");
        QAEngineer qaEngineer = new QAEngineer();
        dao.create(qaEngineer);
        return new BigInteger("12");
    }

    public void updateQAEngineerById(String updateEmployeeIdParam, Blob updateEmployeePhotoParam, String updateEmployeeFirstNameParam, String updateEmployeeSurnameParam, String updateEmployeeDateOfBornParam, String updateEmployeePositionParam) {
        checkAllParameterOnException(updateEmployeeIdParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
        BigInteger employeeId = new BigInteger(updateEmployeeIdParam);
        Date dateOfBorn = new StringToSqlDate().parse(updateEmployeeDateOfBornParam);
        QAEngineer qaEngineer = new QAEngineer();
        dao.update(qaEngineer);
    }

    public void updateQAEngineerById(String updateEmployeeIdParam, MultipartFile updateEmployeePhotoParam, String updateEmployeeFirstNameParam, String updateEmployeeSurnameParam, String updateEmployeeDateOfBornParam, String updateEmployeePositionParam) {
        checkAllParameterOnException(updateEmployeeIdParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
        BigInteger employeeId = new BigInteger(updateEmployeeIdParam);
        Date dateOfBorn = new StringToSqlDate().parse(updateEmployeeDateOfBornParam);
        Blob employeePhotoBlob = convertMultiPartFileToBlob(updateEmployeePhotoParam, "src/main/webapp/images/employeePhoto.jpg");
        Employee updateEmployee = new Employee(employeeId, employeePhotoBlob, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, dateOfBorn, updateEmployeePositionParam);
        QAEngineer qaEngineer = new QAEngineer();
        dao.update(qaEngineer);
    }

    public void deleteQAEngineerById(String deleteEmployeeIdParam) {
        BigInteger deleteEmployeeId = new BigInteger(deleteEmployeeIdParam);
        dao.delete(deleteEmployeeId);
    }

    public QAEngineer readQAEngineerById(String employeeIdString) {
        BigInteger employeeIdInt = new BigInteger(employeeIdString);
        QAEngineer qaEngineer = dao.readById(employeeIdInt);

        return qaEngineer;
    }

    public List<QAEngineer> readAllQAEngineer() {
        return dao.readAll();
    }

    public List<QAEngineer> readAllQAEngineerByParameter(String selectEmployeeIdParam, String selectEmployeeFirstNameParam, String selectEmployeeSurnameParam,
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

    public Blob convertMultiPartFileToBlob(MultipartFile photoParam, String pathEmployeeImage) {
        Blob photoBlob = null;
        if (!(photoParam.isEmpty())) {
            try (InputStream inputStreamImage = photoParam.getInputStream()) {
                byte[] imageByte = IOUtils.toByteArray(inputStreamImage);
                photoBlob = new SerialBlob(imageByte);
            } catch (IOException | SQLException e) {
                List<String> errorList = new EmployeeWebException().getErrorList();
                errorList.add(e.getMessage());
                new EmployeeWebException().setErrorList(errorList);
            }
        } else {
            try (FileInputStream fileInputStream = new FileInputStream(pathEmployeeImage)) {
                byte[] imageByte = IOUtils.toByteArray(fileInputStream);
                photoBlob = new SerialBlob(imageByte);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return photoBlob;
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
