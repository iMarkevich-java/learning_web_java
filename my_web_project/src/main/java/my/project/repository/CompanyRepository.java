package my.project.repository;

import my.project.entity.Company;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface CompanyRepository extends CrudRepository<Company, BigInteger> {
}
