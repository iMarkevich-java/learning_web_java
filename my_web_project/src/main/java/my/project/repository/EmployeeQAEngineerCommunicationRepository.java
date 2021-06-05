package my.project.repository;

import my.project.entity.EmployeeQAEngineerCommunication;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface EmployeeQAEngineerCommunicationRepository extends CrudRepository<EmployeeQAEngineerCommunication, BigInteger> {
}
