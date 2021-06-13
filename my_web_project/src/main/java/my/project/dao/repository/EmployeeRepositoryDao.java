package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.Employee;
import my.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class EmployeeRepositoryDao implements Dao<Employee> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.updateEmployee(employee.getEmployeeId(), employee.getPhoto(), employee.getEmployeeFirstName(),
                employee.getEmployeeSurname(), employee.getEmployeeDateOfBorn(), employee.getEmployeePosition());
    }

    @Override
    public void delete(BigInteger id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> readAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee readById(BigInteger id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<Employee> readAllByHqlQuery(String sql) {
        return null;
    }
}
