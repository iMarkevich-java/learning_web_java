package my.project.service.entity;

import my.project.dao.hibernate.entity.AddressHibernateDao;
import my.project.entity.Address;
import my.project.exceptions.ClientWebException;
import my.project.exceptions.EmployeeWebException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    boolean flag;
    final private AddressHibernateDao dao;

    public AddressService() {
        dao = new AddressHibernateDao();
    }

    public BigInteger createAddress(String addressCountryParam, String addressRegionParam, String addressLocalityParam, String addressCityParam, String addressStreetParam, int addressHouseParam, int addressFlatParam) {
//        checkAllParameterOnException(employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);

        Address address = new Address(addressCountryParam, addressRegionParam, addressLocalityParam, addressCityParam, addressStreetParam, addressHouseParam, addressFlatParam);
        dao.create(address);
        return address.getAddressId();
    }

    public void updateAddressById(String updateAddressIdParam, String updateAddressCountryParam, String updateAddressRegionParam, String updateAddressLocalityParam, String updateAddressCityParam, String updateAddressStreetParam, String updateAddressHouseParam, String updateAddressFlatParam) {
        ArrayList<String> errorList = new ArrayList<>();
        if (updateAddressIdParam.isEmpty() || updateAddressCountryParam.isEmpty() || updateAddressRegionParam.isEmpty() || updateAddressLocalityParam.isEmpty() || updateAddressCityParam.isEmpty() || updateAddressStreetParam.isEmpty() || updateAddressHouseParam.isEmpty() || updateAddressFlatParam.isEmpty()) {
            String errorMessage = "All fields can't be empty";
            errorList.add(errorMessage);
            throw new ClientWebException(errorList);
        }
        BigInteger id = new BigInteger(updateAddressIdParam);
        int house = Integer.parseInt(updateAddressHouseParam);
        int flat = Integer.parseInt(updateAddressFlatParam);
        Address updateAddress = new Address(id, updateAddressCountryParam, updateAddressRegionParam, updateAddressLocalityParam, updateAddressCityParam, updateAddressStreetParam, house, flat);
        dao.update(updateAddress);
    }

    public void deleteAddressById(String deleteAddressIdParam) {
        BigInteger deleteAddressId = new BigInteger(deleteAddressIdParam);
        dao.delete(deleteAddressId);
    }

    public Address readAddressById(BigInteger addressId) {
        Address address = (Address) dao.readById(addressId);
        return address;
    }

    public List<Address> readAllAddress() {
        List<Address> addresses = dao.readAll();
        return addresses;
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