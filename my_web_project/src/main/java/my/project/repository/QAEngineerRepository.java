package my.project.repository;

import my.project.entity.QAEngineer;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface QAEngineerRepository extends CrudRepository<QAEngineer, BigInteger> {
}
