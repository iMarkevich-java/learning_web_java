package my.project.repository;

import my.project.entity.Manager;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface ManagerRepository extends CrudRepository<Manager, BigInteger> {
}
