package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.EmployeeDeveloperCommunication;
import my.project.repository.EmployeeDeveloperCommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class EmployeeDeveloperCommunicationRepositoryDao implements Dao<EmployeeDeveloperCommunication> {

    @Autowired
    EmployeeDeveloperCommunicationRepository employeeDeveloperCommunicationRepository;

    @Override
    public void create(EmployeeDeveloperCommunication employeeDeveloperCommunication) {
        employeeDeveloperCommunicationRepository.save(employeeDeveloperCommunication);
    }

    @Override
    public void update(EmployeeDeveloperCommunication employeeDeveloperCommunication) {
        employeeDeveloperCommunicationRepository.save(employeeDeveloperCommunication);
    }

    @Override
    public void delete(BigInteger id) {
        employeeDeveloperCommunicationRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDeveloperCommunication> readAll() {
        return (List<EmployeeDeveloperCommunication>) employeeDeveloperCommunicationRepository.findAll();
    }

    @Override
    public EmployeeDeveloperCommunication readById(BigInteger id) {
        return employeeDeveloperCommunicationRepository.findById(id).get();
    }

    @Override
    public List<EmployeeDeveloperCommunication> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<EmployeeDeveloperCommunication> readAllByHqlQuery(String sql) {
        return null;
    }
}
