package my.project.repository;

import my.project.entity.EmployeeManagerCommunication;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface EmployeeManagerCommunicationRepository extends CrudRepository<EmployeeManagerCommunication, BigInteger> {
}
