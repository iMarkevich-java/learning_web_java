package my.project.repository;

import my.project.entity.EmployeeAddressCommunication;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface EmployeeAddressCommunicationRepository extends CrudRepository<EmployeeAddressCommunication, BigInteger> {
}
