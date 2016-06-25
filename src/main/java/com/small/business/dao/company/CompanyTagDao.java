package com.small.business.dao.company;

import java.util.List;

import com.small.business.model.company.CompanyTag;

public interface CompanyTagDao {

    public List<CompanyTag> getAllCompanyTag();

    public CompanyTag getCompanyTagById(Long id);

    public boolean addListCompanyTag(List<CompanyTag> listCompanyTag);

    public CompanyTag getCompanyTagByCompanyId(Long companyId);

    public boolean updateListCompanyTag(List<CompanyTag> listCompanyTag);

    public boolean addCompanyTag(CompanyTag companyTag);

    public boolean deleteCompanyTagById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyTag(CompanyTag companyTag);
}
