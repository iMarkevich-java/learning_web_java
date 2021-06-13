package my.project.repository;

import my.project.entity.Manager;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, BigInteger> {
    @Modifying
    @Query(value = "Update Manager manager SET manager = ?1 WHERE manager.managerId = ?2", nativeQuery = true)
    public void updateManager(Manager manager, BigInteger managerId);
}
