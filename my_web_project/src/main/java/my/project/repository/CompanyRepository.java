package my.project.repository;

import my.project.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CompanyRepository extends CrudRepository<Company, BigInteger> {
}
