package com.small.business.service.company;

import java.util.List;

import com.small.business.model.company.CompanyTag;

public interface CompanyTagService {

    public List<CompanyTag> getAllCompanyTag();

    public CompanyTag getCompanyTagById(Long id);

    public boolean addCompanyTag(CompanyTag companyTag);

    public boolean addListCompanyTag(List<CompanyTag> listCompanyTag);

    public CompanyTag getCompanyTagByCompanyId(Long peopleId);

    public boolean updateListCompanyTag(List<CompanyTag> listCompanyTag);

    public boolean deleteCompanyTagById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyTag(CompanyTag companyTag);
}
