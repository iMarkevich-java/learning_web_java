package my.project.repository;

import my.project.entity.EmployeeQAEngineerCommunication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
public interface EmployeeQAEngineerCommunicationRepository extends CrudRepository<EmployeeQAEngineerCommunication, BigInteger> {
    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeQAEngineerCommunication communication WHERE communication.employeeIdFk = ?1")
    void deleteCommunication(BigInteger employeeIdFk);
}
