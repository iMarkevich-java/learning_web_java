package my.project.repository;

import my.project.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProjectRepository extends CrudRepository<Project, BigInteger> {
}
