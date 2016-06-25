package com.small.business.dao.company;

import java.util.List;

import com.small.business.model.company.CompanyLocation;

public interface CompanyLocationDao {

    public List<CompanyLocation> getAllCompanyLocation();

    public CompanyLocation getCompanyLocationById(Long id);

    public boolean addCompanyLocation(CompanyLocation companyPeople);

    public boolean deleteCompanyLocationById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyLocation(CompanyLocation companyPeople);

    public boolean addListCompanyLocation(List<CompanyLocation> listCompanyLocation);

    public boolean updateListCompanyLocation(List<CompanyLocation> listCompanyLocation);

    public List<CompanyLocation> getListCompanyLocationByCompanyId(Long companyId);
}
