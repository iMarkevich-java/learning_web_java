package my.project.repository;

import my.project.entity.Developer;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface DeveloperRepository extends CrudRepository<Developer, BigInteger> {
}
