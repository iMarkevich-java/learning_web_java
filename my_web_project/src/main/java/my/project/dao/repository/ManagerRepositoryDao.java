package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.Manager;
import my.project.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class ManagerRepositoryDao implements Dao<Manager> {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public void create(Manager manager) {
        managerRepository.save(manager);
    }

    @Override
    public void update(Manager manager) {
        managerRepository.updateManager(manager.getManagerId(), manager.getManagerDepartment(), manager.getManagerExperience());
    }

    @Override
    public void delete(BigInteger managerId) {
        managerRepository.deleteManager(managerId);
    }

    @Override
    public List<Manager> readAll() {
        return (List<Manager>) managerRepository.findAll();
    }

    @Override
    public Manager readById(BigInteger id) {
        return managerRepository.findById(id).get();
    }

    @Override
    public List<Manager> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<Manager> readAllByHqlQuery(String sql) {
        return null;
    }
}
