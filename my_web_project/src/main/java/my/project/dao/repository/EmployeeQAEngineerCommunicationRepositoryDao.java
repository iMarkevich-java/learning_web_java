package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.EmployeeQAEngineerCommunication;
import my.project.repository.EmployeeQAEngineerCommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class EmployeeQAEngineerCommunicationRepositoryDao implements Dao<EmployeeQAEngineerCommunication> {

    @Autowired
    EmployeeQAEngineerCommunicationRepository employeeQAEngineerCommunicationRepository;

    @Override
    public void create(EmployeeQAEngineerCommunication employeeQAEngineerCommunication) {
        employeeQAEngineerCommunicationRepository.save(employeeQAEngineerCommunication);
    }

    @Override
    public void update(EmployeeQAEngineerCommunication employeeQAEngineerCommunication) {
        employeeQAEngineerCommunicationRepository.save(employeeQAEngineerCommunication);
    }

    @Override
    public void delete(BigInteger employeeIdFk) {
        employeeQAEngineerCommunicationRepository.deleteCommunication(employeeIdFk);
    }

    @Override
    public List<EmployeeQAEngineerCommunication> readAll() {
        return (List<EmployeeQAEngineerCommunication>) employeeQAEngineerCommunicationRepository.findAll();
    }

    @Override
    public EmployeeQAEngineerCommunication readById(BigInteger id) {
        return employeeQAEngineerCommunicationRepository.findById(id).get();
    }

    @Override
    public List<EmployeeQAEngineerCommunication> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<EmployeeQAEngineerCommunication> readAllByHqlQuery(String sql) {
        return null;
    }
}
