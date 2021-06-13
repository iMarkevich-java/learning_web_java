package my.project.repository;

import my.project.entity.Manager;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, BigInteger> {

    @Transactional
    @Modifying
    @Query("UPDATE Manager manager SET manager.managerDepartment = ?2, manager.managerExperience = ?3 WHERE manager.managerId = ?1")
    void updateManager(BigInteger managerId, String managerDepartment, int managerExperience);

    @Transactional
    @Modifying
    @Query("DELETE Manager manager WHERE manager.managerId = ?1")
    void deleteManager(BigInteger managerId);


}
