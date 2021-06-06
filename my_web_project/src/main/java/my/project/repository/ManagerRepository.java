package my.project.repository;

import my.project.entity.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, BigInteger> {
}
