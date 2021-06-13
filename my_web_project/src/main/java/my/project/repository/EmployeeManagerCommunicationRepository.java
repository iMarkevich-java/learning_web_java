package my.project.repository;

import my.project.entity.EmployeeManagerCommunication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
public interface EmployeeManagerCommunicationRepository extends CrudRepository<EmployeeManagerCommunication, BigInteger> {

    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeManagerCommunication communication WHERE communication.employeeIdFk = ?1")
    void deleteCommunication(BigInteger employeeIdFk);
}
