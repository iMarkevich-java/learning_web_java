package my.project.repository;

import my.project.entity.EmployeeManagerCommunication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EmployeeManagerCommunicationRepository extends CrudRepository<EmployeeManagerCommunication, BigInteger> {
}
