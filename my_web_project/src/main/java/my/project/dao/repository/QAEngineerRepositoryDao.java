package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.QaEngineer;
import my.project.repository.QAEngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class QAEngineerRepositoryDao implements Dao<QaEngineer> {

    @Autowired
    QAEngineerRepository qaEngineerRepository;

    @Override
    public void create(QaEngineer qaEngineer) {
        qaEngineerRepository.save(qaEngineer);
    }

    @Override
    public void update(QaEngineer qaEngineer) {
        qaEngineerRepository.updateQaEngineer(qaEngineer.getQaEngineerId(), qaEngineer.getQaEngineerDepartment(), qaEngineer.getQaEngineerExperience());
    }

    @Override
    public void delete(BigInteger qaEngineerId) {
        qaEngineerRepository.deleteQaEngineer(qaEngineerId);
    }

    @Override
    public List<QaEngineer> readAll() {
        return (List<QaEngineer>) qaEngineerRepository.findAll();
    }

    @Override
    public QaEngineer readById(BigInteger id) {
        return qaEngineerRepository.findById(id).get();
    }

    @Override
    public List<QaEngineer> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<QaEngineer> readAllByHqlQuery(String sql) {
        return null;
    }
}
