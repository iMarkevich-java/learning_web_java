package my.project.repository;

import my.project.entity.EmployeeAddressCommunication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EmployeeAddressCommunicationRepository extends CrudRepository<EmployeeAddressCommunication, BigInteger> {
}
