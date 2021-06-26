package my.project.service.employee.entity;

import my.project.dao.hibernate.entity.CompanyHibernateDao;
import my.project.dao.repository.CompanyRepositoryDao;
import my.project.entity.Company;
import my.project.exceptions.CompanyWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    private final CompanyHibernateDao dao;
    @Autowired
    CompanyRepositoryDao companyRepositoryDao;

    public CompanyService() {
        dao = new CompanyHibernateDao();
    }

    public BigInteger createCompany(String companyNameParam, String companyActivityParam) {
        checkAllParameterOnException(companyNameParam, companyActivityParam);
        Company company = new Company(companyNameParam, companyActivityParam);
//        dao.create(company);
        companyRepositoryDao.create(company);
        return company.getCompanyId();
    }

    public void updateCompanyById(String updateCompanyIdParam, String updateCompanyNameParam, String updateCompanyActivityParam) {
        checkAllParameterOnException(updateCompanyIdParam, updateCompanyNameParam, updateCompanyActivityParam);
        BigInteger id = new BigInteger(updateCompanyIdParam);
        Company company = new Company(id, updateCompanyNameParam, updateCompanyActivityParam);
//        dao.update(company);
        companyRepositoryDao.update(company);
    }

    public void deleteCompanyById(String deleteCompanyIdParam) {
        BigInteger deleteCompanyId = new BigInteger(deleteCompanyIdParam);
//        dao.delete(deleteCompanyId);
        companyRepositoryDao.delete(deleteCompanyId);
    }

    public Company readCompanyById(BigInteger companyId) {
//        dao.readById(addressId)
        return companyRepositoryDao.readById(companyId);
    }

    public List<Company> readAllCompany() {
//        dao.readAll()
        return companyRepositoryDao.readAll();
    }

    private void checkAllParameterOnException(String companyNameParam, String companyActivityParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (companyNameParam.isEmpty()) {
            String errorMessage = "Company name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (companyActivityParam.isEmpty()) {
            String errorMessage = "Company activity can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new CompanyWebException(errorList);
        }
    }

    private void checkAllParameterOnException(String companyId, String companyNameParam, String companyActivityParam) {
        boolean flag = false;
        ArrayList<String> errorList = new ArrayList<>();
        if (companyId.isEmpty()) {
            String errorMessage = "Company id can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (companyNameParam.isEmpty()) {
            String errorMessage = "Company name can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (companyActivityParam.isEmpty()) {
            String errorMessage = "Company activity can't be empty!!!";
            errorList.add(errorMessage);
            flag = true;
        }
        if (flag) {
            throw new CompanyWebException(errorList);
        }
    }
}
