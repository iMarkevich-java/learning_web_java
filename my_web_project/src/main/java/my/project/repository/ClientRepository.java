package my.project.repository;

import my.project.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ClientRepository extends CrudRepository<Client, BigInteger> {
}
