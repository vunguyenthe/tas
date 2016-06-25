package com.small.business.service.company;

import java.util.List;

import com.small.business.model.company.CompanyPeople;

public interface CompanyPeopleService {

    public List<CompanyPeople> getAllCompanyPeople();

    public CompanyPeople getCompanyPeopleById(Long id);

    public boolean addCompanyPeople(CompanyPeople companyPeople);

    public boolean deleteCompanyPeopleById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyPeople(CompanyPeople companyPeople);

    public boolean addListCompanyPeople(List<CompanyPeople> listCompanyPeople);

    public boolean updateListCompanyPeople(List<CompanyPeople> listCompanyPeople);

    public List<CompanyPeople> getListCompanyPeopleByCompanyId(Long companyId);

}
