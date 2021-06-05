package my.project.repository;

import my.project.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface ClientRepository extends CrudRepository<Client, BigInteger> {
}
