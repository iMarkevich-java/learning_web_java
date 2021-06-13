package my.project.repository;

import my.project.entity.QaEngineer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Repository
public interface QAEngineerRepository extends CrudRepository<QaEngineer, BigInteger> {

    @Transactional
    @Modifying
    @Query("UPDATE QaEngineer qaEngineer SET qaEngineer.qaEngineerDepartment = ?2, qaEngineer.qaEngineerExperience = ?3 WHERE qaEngineer.qaEngineerId = ?1")
    void updateQaEngineer(BigInteger qaEngineerId, String qaEngineerDepartment, int qaEngineerExperience);

    @Transactional
    @Modifying
    @Query("DELETE QaEngineer qaEngineer WHERE qaEngineer.qaEngineerId = ?1")
    void deleteQaEngineer(BigInteger managerId);
}
