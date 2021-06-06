package my.project.repository;

import my.project.entity.QaEngineer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface QAEngineerRepository extends CrudRepository<QaEngineer, BigInteger> {
}
