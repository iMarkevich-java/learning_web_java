package my.project.dao.repository;

import my.project.dao.Dao;
import my.project.entity.Company;
import my.project.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class CompanyRepositoryDao implements Dao<Company> {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void create(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void update(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void delete(BigInteger id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> readAll() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Company readById(BigInteger id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public List<Company> readAllByParameterAndValues(String parameter, String values) {
        return null;
    }

    @Override
    public List<Company> readAllByHqlQuery(String sql) {
        return null;
    }
}
