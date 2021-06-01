package my.project.service.entity;

import my.project.dao.hibernate.entity.EmployeeHibernateDao;
import my.project.entity.Employee;
import my.project.exceptions.EmployeeWebException;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
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
public class EmployeeService {

    final private EmployeeHibernateDao dao;

    private Boolean flag = false;

    public EmployeeService() {
        this.dao = new EmployeeHibernateDao();
    }

    public BigInteger createEmployee(Blob employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, String employeeDateOfBornParam, String employeePositionParam) {
        checkAllParameterOnException(employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
        Date dateOfBorn = new StringToSqlDate().parse(employeeDateOfBornParam);
        Employee employee = new Employee(employeePhotoParam, employeeFirstNameParam, employeeSurnameParam, dateOfBorn, employeePositionParam);
        dao.create(employee);
        return employee.getEmployeeId();
    }

    public BigInteger createEmployee(MultipartFile employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, String employeeDateOfBornParam, String employeePositionParam) {
        checkAllParameterOnException(employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
        Date dateOfBorn = new StringToSqlDate().parse(employeeDateOfBornParam);
        Blob employeePhotoBlob = convertMultiPartFileToBlob(employeePhotoParam, "src/main/webapp/images/tempImage.jpg");
        Employee employee = new Employee(employeePhotoBlob, employeeFirstNameParam, employeeSurnameParam, dateOfBorn, employeePositionParam);
        dao.create(employee);
        return employee.getEmployeeId();
    }

    public void updateEmployeeById(String updateEmployeeIdParam, Blob updateEmployeePhotoParam, String updateEmployeeFirstNameParam, String updateEmployeeSurnameParam, String updateEmployeeDateOfBornParam, String updateEmployeePositionParam) {
        checkAllParameterOnException(updateEmployeeIdParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
        BigInteger employeeId = new BigInteger(updateEmployeeIdParam);
        Date dateOfBorn = new StringToSqlDate().parse(updateEmployeeDateOfBornParam);
        Employee updateEmployee = new Employee(employeeId, updateEmployeePhotoParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, dateOfBorn, updateEmployeePositionParam);
        dao.update(updateEmployee);
    }

    public void updateEmployeeById(String updateEmployeeIdParam, MultipartFile updateEmployeePhotoParam, String updateEmployeeFirstNameParam, String updateEmployeeSurnameParam, String updateEmployeeDateOfBornParam, String updateEmployeePositionParam) {
        checkAllParameterOnException(updateEmployeeIdParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
        BigInteger employeeId = new BigInteger(updateEmployeeIdParam);
        Date dateOfBorn = new StringToSqlDate().parse(updateEmployeeDateOfBornParam);
        Blob employeePhotoBlob = convertMultiPartFileToBlob(updateEmployeePhotoParam, "src/main/webapp/images/employeePhoto.jpg");
        Employee updateEmployee = new Employee(employeeId, employeePhotoBlob, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, dateOfBorn, updateEmployeePositionParam);
        dao.update(updateEmployee);
    }

    public void deleteEmployeeById(String deleteEmployeeIdParam) {
        BigInteger deleteEmployeeId = new BigInteger(deleteEmployeeIdParam);
        dao.delete(deleteEmployeeId);
    }

    public Employee readEmployeeById(String employeeIdString) {
        BigInteger employeeIdInt = new BigInteger(employeeIdString);
        Employee employee = dao.readById(employeeIdInt);
        Blob photo = employee.getPhoto();
        try (InputStream binaryStream = photo.getBinaryStream(1, photo.length())) {
            ImageIO.write(ImageIO.read(binaryStream), "JPG", new File("src/main/webapp/images/employeePhoto.jpg"));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    public List<Employee> readAllEmployee() {
        return dao.readAll();
    }

    public List<Employee> readAllEmployeeByParameter(String selectEmployeeIdParam, String selectEmployeeFirstNameParam, String selectEmployeeSurnameParam,
                                                     String selectEmployeeDateOfBornParam, String selectEmployeePositionParam) {
        flag = false;
        String hql = checkAllParameter(selectEmployeeIdParam, selectEmployeeFirstNameParam, selectEmployeeSurnameParam, selectEmployeeDateOfBornParam, selectEmployeePositionParam);
        hql = checkParameter("employee.employeeId", selectEmployeeIdParam, hql);
        hql = checkParameter("employee.employeeFirstName", selectEmployeeFirstNameParam, hql);
        hql = checkParameter("employee.employeeSurname", selectEmployeeSurnameParam, hql);
        hql = checkParameter("employee.employeeDateOfBorn", selectEmployeeDateOfBornParam, hql);
        hql = checkParameter("employee.employeePosition", selectEmployeePositionParam, hql);
        return dao.readAllByHqlQuery(hql);
//        hibernate kriterie
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
