package my.project.repository;

import my.project.entity.EmployeeQAEngineerCommunication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EmployeeQAEngineerCommunicationRepository extends CrudRepository<EmployeeQAEngineerCommunication, BigInteger> {
}
