package my.project.repository;

import my.project.entity.Developer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, BigInteger> {

    @Transactional
    @Modifying
    @Query(value = "Update Developer developer SET developer.developerDepartment = ?2, developer.developerExperience = ?3 WHERE developer.developerId = ?1")
    void updateDeveloper(BigInteger developerId, String developerDepartment, int developerExperience);

    @Transactional
    @Modifying
    @Query("DELETE Developer developer WHERE developer.developerId = ?1")
    void deleteDeveloper(BigInteger developerId);
}
