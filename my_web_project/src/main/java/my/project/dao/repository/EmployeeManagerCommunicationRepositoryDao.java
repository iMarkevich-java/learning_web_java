package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.EmployeeManagerCommunication;
import my.project.repository.EmployeeManagerCommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class EmployeeManagerCommunicationRepositoryDao implements Dao<EmployeeManagerCommunication> {
    @Autowired
    EmployeeManagerCommunicationRepository employeeManagerCommunicationRepository;

    @Override
    public void create(EmployeeManagerCommunication employeeManagerCommunication) {
        employeeManagerCommunicationRepository.save(employeeManagerCommunication);
    }

    @Override
    public void update(EmployeeManagerCommunication employeeManagerCommunication) {
        employeeManagerCommunicationRepository.save(employeeManagerCommunication);
    }

    @Override
    public void delete(BigInteger employeeIdFk) {
        employeeManagerCommunicationRepository.deleteCommunication(employeeIdFk);
    }

    @Override
    public List<EmployeeManagerCommunication> readAll() {
        return (List<EmployeeManagerCommunication>) employeeManagerCommunicationRepository.findAll();
    }

    @Override
    public EmployeeManagerCommunication readById(BigInteger id) {
        return employeeManagerCommunicationRepository.findById(id).get();
    }

    @Override
    public List<EmployeeManagerCommunication> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<EmployeeManagerCommunication> readAllByHqlQuery(String sql) {
        return null;
    }
}
