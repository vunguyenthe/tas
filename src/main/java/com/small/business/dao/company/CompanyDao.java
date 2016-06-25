package com.small.business.dao.company;

import java.util.List;

import com.small.business.model.company.Company;

public interface CompanyDao {

    public List<Company> getAllCompany();

    public List<Company> getFullCompany();

    public Company getCompanyById(Long id);

    public boolean addCompany(Company Company);

    public Long getNextCompanyId();

    public boolean deleteCompanyById(Long id);

    public boolean deleteAll();

    public boolean updateCompany(Company Company);
}
