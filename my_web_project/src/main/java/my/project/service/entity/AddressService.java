package my.project.service.entity;

import my.project.dao.hibernate.entity.AddressHibernateDao;
import my.project.dao.repository.AddressRepositoryDao;
import my.project.entity.Address;
import my.project.exceptions.AddressWebException;
import my.project.service.communication.EmployeeAddressCommunicationService;
import my.project.service.communication.EmployeeQAEngineerCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepositoryDao addressRepositoryDao;

    @Autowired
    EmployeeAddressCommunicationService employeeAddressCommunicationService;

    final private AddressHibernateDao dao;

    boolean flag;

    public AddressService() {
        dao = new AddressHibernateDao();
    }

    public BigInteger createAddress(String addressCountryParam, String addressRegionParam, String addressLocalityParam, String addressCityParam, String addressStreetParam, int addressHouseParam, int addressFlatParam) {
        checkAllParameterOnException(addressCountryParam, addressRegionParam, addressLocalityParam, addressCityParam, addressStreetParam, addressHouseParam, addressFlatParam);
        Address address = new Address(addressCountryParam, addressRegionParam, addressLocalityParam, addressCityParam, addressStreetParam, addressHouseParam, addressFlatParam);
//        dao.create(address);
        addressRepositoryDao.create(address);
        return address.getAddressId();
    }

    public void updateAddressById(String updateAddressIdParam, String updateAddressCountryParam, String updateAddressRegionParam, String updateAddressLocalityParam, String updateAddressCityParam, String updateAddressStreetParam, int updateAddressHouseParam, int updateAddressFlatParam) {
        checkAllParameterOnException(updateAddressIdParam, updateAddressCountryParam, updateAddressRegionParam, updateAddressLocalityParam, updateAddressCityParam, updateAddressStreetParam, updateAddressHouseParam, updateAddressFlatParam);
        BigInteger employeeId = readAddressById(updateAddressIdParam).getEmployee().getEmployeeId();
        Address updateAddress = new Address(new BigInteger(updateAddressIdParam), updateAddressCountryParam, updateAddressRegionParam, updateAddressLocalityParam, updateAddressCityParam, updateAddressStreetParam, updateAddressHouseParam, updateAddressFlatParam);
//        dao.update(updateAddress);
        addressRepositoryDao.update(updateAddress);
        employeeAddressCommunicationService.updateCommunication(employeeId, updateAddress.getAddressId());
    }

    public void deleteAddressById(String deleteAddressIdParam) {
        BigInteger deleteAddressId = new BigInteger(deleteAddressIdParam);
//        dao.delete(deleteAddressId);
        addressRepositoryDao.delete(deleteAddressId);
    }

    public Address readAddressById(String addressId) {
//        Address address = (Address) dao.readById(addressId);
        return addressRepositoryDao.readById(new BigInteger(addressId));
    }

    public List<Address> readAllAddress() {
//        List<Address> addresses = dao.readAll();
        return addressRepositoryDao.readAll();
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

    private void checkAllParameterOnException(String addressCountryParam, String addressRegionParam, String addressLocalityParam, String addressCityParam, String addressStreetParam, int addressHouseParam, int addressFlatParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (addressCountryParam.isEmpty()) {
            String errorMessage = "Country can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressRegionParam.isEmpty()) {
            String errorMessage = "Region can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressLocalityParam.isEmpty()) {
            String errorMessage = "Locality can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressCityParam.isEmpty()) {
            String errorMessage = "City can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressStreetParam.isEmpty()) {
            String errorMessage = "Street can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressHouseParam == 0) {
            String errorMessage = "House can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressFlatParam == 0) {
            String errorMessage = "Flat can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new AddressWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String addressIdParam, String addressCountryParam, String addressRegionParam, String addressLocalityParam, String addressCityParam, String addressStreetParam, int addressHouseParam, int addressFlatParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (addressIdParam.isEmpty()) {
            String errorMessage = "Address id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressCountryParam.isEmpty()) {
            String errorMessage = "Country can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressRegionParam.isEmpty()) {
            String errorMessage = "Region can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressLocalityParam.isEmpty()) {
            String errorMessage = "Locality can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressCityParam.isEmpty()) {
            String errorMessage = "City can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressStreetParam.isEmpty()) {
            String errorMessage = "Street can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressHouseParam == 0) {
            String errorMessage = "House can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (addressFlatParam == 0) {
            String errorMessage = "Flat can't be empty";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new AddressWebException(errorList);
        }
    }
}