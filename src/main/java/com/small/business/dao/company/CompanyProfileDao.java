package com.small.business.dao.company;

import java.util.List;

import com.small.business.model.company.CompanyProfile;

public interface CompanyProfileDao {

    public List<CompanyProfile> getAllCompanyProfile();

    public CompanyProfile getCompanyProfileById(Long id);

    public boolean addCompanyProfile(CompanyProfile companyPeople);

    public boolean deleteCompanyProfileById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyProfile(CompanyProfile companyPeople);

    public boolean addListCompanyProfile(List<CompanyProfile> listCompanyProfile);

    public boolean updateListCompanyProfile(List<CompanyProfile> listCompanyProfile);

    public CompanyProfile getCompanyProfileByCompanyId(Long companyId);
}
