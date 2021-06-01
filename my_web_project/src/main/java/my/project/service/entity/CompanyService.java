package my.project.service.entity;

import my.project.dao.Dao;
import my.project.dao.hibernate.entity.CompanyHibernateDao;
import my.project.entity.Company;
import my.project.exceptions.CompanyWebException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    private Dao dao;

    public CompanyService() {
        dao = new CompanyHibernateDao();
    }

    public void createCompany(String companyNameParam, String companyActivityParam) {
        ArrayList<String> errorList = new ArrayList<>();
        if (companyNameParam.isEmpty() || companyActivityParam.isEmpty()) {
            String errorMessage = "All fields can't be empty";
            errorList.add(errorMessage);
            throw new CompanyWebException(errorList);
        }

        Company company = new Company(companyNameParam, companyActivityParam);
        dao.create(company);
    }

    public void updateCompanyById(String updateCompanyIdParam, String updateCompanyNameParam, String updateCompanyActivityParam) {
        ArrayList<String> errorList = new ArrayList<>();
        if (updateCompanyIdParam.isEmpty() || updateCompanyNameParam.isEmpty() || updateCompanyActivityParam.isEmpty()) {
            String errorMessage = "All fields can't be empty";
            errorList.add(errorMessage);
            throw new CompanyWebException(errorList);
        }

        int id = Integer.parseInt(updateCompanyIdParam);
        Company company = new Company(id, updateCompanyNameParam, updateCompanyActivityParam);
        dao.update(company);
    }

    public void deleteCompanyById(String deleteCompanyIdParam) {
        BigInteger deleteCompanyId = new BigInteger(deleteCompanyIdParam);
        dao.delete(deleteCompanyId);
    }

    public Company readCompanyById(BigInteger addressId) {
        Company company = (Company) dao.readById(addressId);
        return company;
    }

    public List<Company> readAllCompany() {
        List<Company> companies = dao.readAll();
        return companies;
    }
}
