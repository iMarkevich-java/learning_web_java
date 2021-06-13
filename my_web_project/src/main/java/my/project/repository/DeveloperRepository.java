package my.project.repository;

import my.project.entity.Developer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, BigInteger> {
    @Modifying
    @Query(value = "Update Developer developer SET developer = ?1 WHERE developer.developerId = ?2", nativeQuery = true)
    public void updateDeveloper(Developer developer, BigInteger developerId);
}
