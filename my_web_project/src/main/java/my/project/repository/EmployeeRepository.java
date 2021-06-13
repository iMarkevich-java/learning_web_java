package my.project.repository;

import my.project.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Date;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, BigInteger> {

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("UPDATE Employee employee SET employee.photo = ?2, employee.employeeFirstName = ?3, employee.employeeSurname = ?4, employee.employeeDateOfBorn = ?5, employee.employeePosition = ?6 WHERE employee.employeeId = ?1")
    void updateEmployee(BigInteger employeeId, Blob photo, String firstName, String employeeSurname,
                        Date dateOfBorn, String employeePosition);

}
