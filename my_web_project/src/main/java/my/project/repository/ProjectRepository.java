package my.project.repository;

import my.project.entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface ProjectRepository extends CrudRepository<Project, BigInteger> {
}
