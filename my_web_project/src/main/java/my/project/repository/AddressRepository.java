package my.project.repository;

import my.project.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface AddressRepository extends CrudRepository<Address, BigInteger> {

}
