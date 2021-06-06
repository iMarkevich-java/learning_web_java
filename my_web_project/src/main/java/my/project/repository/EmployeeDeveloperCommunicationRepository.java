package my.project.repository;

import my.project.entity.EmployeeDeveloperCommunication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EmployeeDeveloperCommunicationRepository extends CrudRepository<EmployeeDeveloperCommunication, BigInteger> {
}
