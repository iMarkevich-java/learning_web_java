package my.project.repository;

import my.project.entity.EmployeeAddressCommunication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
public interface EmployeeAddressCommunicationRepository extends CrudRepository<EmployeeAddressCommunication, BigInteger> {

    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeAddressCommunication communication WHERE communication.employeeIdFk = ?1")
    void deleteCommunicationByEmployeeId(BigInteger employeeIdFk);

}
