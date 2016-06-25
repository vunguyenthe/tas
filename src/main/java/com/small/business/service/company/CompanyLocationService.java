package com.small.business.service.company;

import java.util.List;

import com.small.business.model.company.CompanyLocation;

public interface CompanyLocationService {

    public List<CompanyLocation> getAllCompanyLocation();

    public CompanyLocation getCompanyLocationById(Long id);

    public boolean addCompanyLocation(CompanyLocation companyJournal);

    public boolean deleteCompanyLocationById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyLocation(CompanyLocation companyJournal);

    public boolean addListCompanyLocation(List<CompanyLocation> listCompanyLocation);

    public boolean updateListCompanyLocation(List<CompanyLocation> listCompanyLocation);

    public List<CompanyLocation> getListCompanyLocationByCompanyId(Long companyId);
}
