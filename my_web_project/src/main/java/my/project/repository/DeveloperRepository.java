package my.project.repository;

import my.project.entity.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, BigInteger> {
}
