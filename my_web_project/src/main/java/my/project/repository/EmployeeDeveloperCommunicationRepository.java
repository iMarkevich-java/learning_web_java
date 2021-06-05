package my.project.repository;

import my.project.entity.EmployeeDeveloperCommunication;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface EmployeeDeveloperCommunicationRepository extends CrudRepository<EmployeeDeveloperCommunication, BigInteger> {
}
