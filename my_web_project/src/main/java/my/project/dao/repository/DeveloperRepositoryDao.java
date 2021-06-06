package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.Developer;
import my.project.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class DeveloperRepositoryDao implements Dao<Developer> {

    @Autowired
    DeveloperRepository developerRepository;

    @Override
    public void create(Developer developer) {
        developerRepository.save(developer);
    }

    @Override
    public void update(Developer developer) {
        developerRepository.save(developer);
    }

    @Override
    public void delete(BigInteger id) {
        developerRepository.deleteById(id);
    }

    @Override
    public List<Developer> readAll() {
        return (List<Developer>) developerRepository.findAll();
    }

    @Override
    public Developer readById(BigInteger id) {
        return developerRepository.findById(id).get();
    }

    @Override
    public List<Developer> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<Developer> readAllByHqlQuery(String sql) {
        return null;
    }
}
