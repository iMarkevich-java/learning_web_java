package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.Project;
import my.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class ProjectRepositoryDao implements Dao<Project> {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void create(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void update(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void delete(BigInteger id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> readAll() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project readById(BigInteger id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public List<Project> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<Project> readAllByHqlQuery(String sql) {
        return null;
    }
}
