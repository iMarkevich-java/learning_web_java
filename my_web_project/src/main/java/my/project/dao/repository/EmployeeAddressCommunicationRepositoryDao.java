package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.EmployeeAddressCommunication;
import my.project.repository.EmployeeAddressCommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class EmployeeAddressCommunicationRepositoryDao implements Dao<EmployeeAddressCommunication> {
    @Autowired
    EmployeeAddressCommunicationRepository employeeAddressCommunicationRepository;

    @Override
    public void create(EmployeeAddressCommunication employeeAddressCommunication) {
        employeeAddressCommunicationRepository.save(employeeAddressCommunication);
    }

    @Override
    public void update(EmployeeAddressCommunication employeeAddressCommunication) {
        employeeAddressCommunicationRepository.save(employeeAddressCommunication);
    }

    @Override
    public void delete(BigInteger employeeIdFk) {
        employeeAddressCommunicationRepository.deleteCommunicationByEmployeeId(employeeIdFk);
    }

    @Override
    public List<EmployeeAddressCommunication> readAll() {
        return (List<EmployeeAddressCommunication>) employeeAddressCommunicationRepository.findAll();
    }

    @Override
    public EmployeeAddressCommunication readById(BigInteger id) {
        return employeeAddressCommunicationRepository.findById(id).get();
    }

    @Override
    public List<EmployeeAddressCommunication> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<EmployeeAddressCommunication> readAllByHqlQuery(String sql) {
        return null;
    }
}
