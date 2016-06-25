package com.small.business.service.company;

import java.util.List;

import com.small.business.model.company.CompanyProfile;

public interface CompanyProfileService {

    public List<CompanyProfile> getAllCompanyProfile();

    public CompanyProfile getCompanyProfileById(Long id);

    public boolean addCompanyProfile(CompanyProfile companyJournal);

    public boolean deleteCompanyProfileById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyProfile(CompanyProfile companyJournal);

    public boolean addListCompanyProfile(List<CompanyProfile> listCompanyProfile);

    public boolean updateListCompanyProfile(List<CompanyProfile> listCompanyProfile);

    public CompanyProfile getCompanyProfileByCompanyId(Long assignmentId);
}
