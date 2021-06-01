package my.project.repository;

import my.project.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface EmployeeRepository extends CrudRepository<Employee, BigInteger> {

}
