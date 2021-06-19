package my.project.service.entity;

import my.project.dao.hibernate.entity.EmployeeHibernateDao;
import my.project.dao.repository.EmployeeRepositoryDao;
import my.project.entity.Employee;
import my.project.exceptions.EmployeeWebException;
import my.project.path.PathToFiles;
import my.project.service.communication.EmployeeAddressCommunicationService;
import my.project.service.communication.EmployeeDeveloperCommunicationService;
import my.project.service.communication.EmployeeManagerCommunicationService;
import my.project.service.communication.EmployeeQAEngineerCommunicationService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    final private EmployeeHibernateDao dao;
    @Autowired
    private EmployeeAddressCommunicationService employeeAddressCommunicationService;
    @Autowired
    private EmployeeDeveloperCommunicationService employeeDeveloperCommunicationService;
    @Autowired
    private EmployeeManagerCommunicationService employeeManagerCommunicationService;
    @Autowired
    private EmployeeQAEngineerCommunicationService employeeQAEngineerCommunicationService;
    @Autowired
    private EmployeeRepositoryDao employeeRepositoryDao;
    private Boolean flag = false;

    public EmployeeService() {
        this.dao = new EmployeeHibernateDao();
    }

    public BigInteger createEmployee(Employee employee) {
        employeeRepositoryDao.create(employee);
        return employee.getEmployeeId();
    }

    public BigInteger createEmployee(Blob employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        checkAllParameterOnException(employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
        Employee employee = new Employee(employeePhotoParam, employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
//        dao.create(employee);
        employeeRepositoryDao.create(employee);
        return employee.getEmployeeId();
    }

    public BigInteger createEmployee(MultipartFile employeePhotoParam, String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        checkAllParameterOnException(employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
        Blob employeePhotoBlob = convertMultiPartFileToBlob(employeePhotoParam, PathToFiles.PATH_TO_TEMP_IMAGE.getPath());
        Employee employee = new Employee(employeePhotoBlob, employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
//        dao.create(employee);
        employeeRepositoryDao.create(employee);
        return employee.getEmployeeId();
    }

    public void updateEmployee(Employee updateEmployee) {
        employeeRepositoryDao.update(updateEmployee);
    }

    public void updateEmployeeById(String updateEmployeeIdParam, Blob updateEmployeePhotoParam, String updateEmployeeFirstNameParam, String updateEmployeeSurnameParam, Date updateEmployeeDateOfBornParam, String updateEmployeePositionParam) {
        checkAllParameterOnException(updateEmployeeIdParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
        BigInteger employeeId = new BigInteger(updateEmployeeIdParam);
        Employee updateEmployee = new Employee(employeeId, updateEmployeePhotoParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
//        dao.update(updateEmployee);
        employeeRepositoryDao.create(updateEmployee);
    }

    public void updateEmployeeById(String updateEmployeeIdParam, MultipartFile updateEmployeePhotoParam, String updateEmployeeFirstNameParam, String updateEmployeeSurnameParam, Date updateEmployeeDateOfBornParam, String updateEmployeePositionParam) {
        checkAllParameterOnException(updateEmployeeIdParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
        Blob employeePhotoBlob = convertMultiPartFileToBlob(updateEmployeePhotoParam, PathToFiles.PATH_TO_PHOTO.getPath());
        Employee employee = readEmployeeById(updateEmployeeIdParam);
        BigInteger addressId = employee.getAddress().getAddressId();
        Employee updateEmployee = new Employee(new BigInteger(updateEmployeeIdParam), employeePhotoBlob, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
        if (updateEmployee.getManager() != null) {
            BigInteger managerId = employee.getManager().getManagerId();
            employeeRepositoryDao.update(updateEmployee);
            employeeAddressCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), addressId);
            employeeManagerCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), managerId);
        }
        if (updateEmployee.getDeveloper() != null) {
            BigInteger developerId = employee.getDeveloper().getDeveloperId();
            employeeRepositoryDao.update(updateEmployee);
            employeeAddressCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), addressId);
            employeeDeveloperCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), developerId);
        }
        if (updateEmployee.getQaEngineer() != null) {
            BigInteger qaEngineerId = employee.getQaEngineer().getQaEngineerId();
            employeeRepositoryDao.update(updateEmployee);
            employeeAddressCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), addressId);
            employeeQAEngineerCommunicationService.updateCommunication(updateEmployee.getEmployeeId(), qaEngineerId);
        }
    }

    public void deleteEmployeeById(String deleteEmployeeIdParam) {
        BigInteger deleteEmployeeId = new BigInteger(deleteEmployeeIdParam);
//        dao.delete(deleteEmployeeId);
        employeeRepositoryDao.delete(deleteEmployeeId);
    }

    public Employee readEmployeeById(String employeeIdString) {
        BigInteger employeeIdInt = new BigInteger(employeeIdString);
//        Employee employee = dao.readById(employeeIdInt);
        Employee employee = employeeRepositoryDao.readById(employeeIdInt);
        Blob photo = employee.getPhoto();
        if(!(photo == null)){
            try (InputStream binaryStream = photo.getBinaryStream(1, photo.length())) {
                ImageIO.write(ImageIO.read(binaryStream), "JPG", new File(PathToFiles.PATH_TO_PHOTO.getPath()));
            } catch (SQLException | IOException throwables) {

            }
        }else {
            try (FileInputStream fileInputStream = new FileInputStream(PathToFiles.PATH_TO_TEMP_IMAGE.getPath())) {
                ImageIO.write(ImageIO.read(fileInputStream), "JPG", new File(PathToFiles.PATH_TO_PHOTO.getPath()));
            } catch (IOException e) {
                throw new EmployeeWebException("Can't save employee photo in class " + getClass().getName());
            }
        }
        return employee;
    }

    public Employee readEmployeeById(BigInteger employeeIdBigInteger) {
//        Employee employee = dao.readById(employeeIdBigInteger);
        Employee employee = employeeRepositoryDao.readById(employeeIdBigInteger);
        Blob photo = employee.getPhoto();
        try (InputStream binaryStream = photo.getBinaryStream(1, photo.length())) {
            ImageIO.write(ImageIO.read(binaryStream), "JPG", new File(PathToFiles.PATH_TO_PHOTO.getPath()));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    public List<Employee> readAllEmployee() {
        return employeeRepositoryDao.readAll();
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

    private void checkAllParameterOnException(String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
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
        if (employeeDateOfBornParam.toString().isEmpty()) {
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

    private void checkAllParameterOnException(String employeeId, String employeeFirstNameParam, String employeeSurnameParam, Date employeeDateOfBornParam, String employeePositionParam) {
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
        if (employeeDateOfBornParam.toString().isEmpty()) {
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

    public EmployeeAddressCommunicationService getEmployeeAddressCommunicationService() {
        return employeeAddressCommunicationService;
    }

    public void setEmployeeAddressCommunicationService(EmployeeAddressCommunicationService employeeAddressCommunicationService) {
        this.employeeAddressCommunicationService = employeeAddressCommunicationService;
    }

    public EmployeeDeveloperCommunicationService getEmployeeDeveloperCommunicationService() {
        return employeeDeveloperCommunicationService;
    }

    public void setEmployeeDeveloperCommunicationService(EmployeeDeveloperCommunicationService employeeDeveloperCommunicationService) {
        this.employeeDeveloperCommunicationService = employeeDeveloperCommunicationService;
    }

    public EmployeeManagerCommunicationService getEmployeeManagerCommunicationService() {
        return employeeManagerCommunicationService;
    }

    public void setEmployeeManagerCommunicationService(EmployeeManagerCommunicationService employeeManagerCommunicationService) {
        this.employeeManagerCommunicationService = employeeManagerCommunicationService;
    }

    public EmployeeQAEngineerCommunicationService getEmployeeQAEngineerCommunicationService() {
        return employeeQAEngineerCommunicationService;
    }

    public void setEmployeeQAEngineerCommunicationService(EmployeeQAEngineerCommunicationService employeeQAEngineerCommunicationService) {
        this.employeeQAEngineerCommunicationService = employeeQAEngineerCommunicationService;
    }

    public EmployeeRepositoryDao getEmployeeRepositoryDao() {
        return employeeRepositoryDao;
    }

    public void setEmployeeRepositoryDao(EmployeeRepositoryDao employeeRepositoryDao) {
        this.employeeRepositoryDao = employeeRepositoryDao;
    }

    public EmployeeHibernateDao getDao() {
        return dao;
    }
}
