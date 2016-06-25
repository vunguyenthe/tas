package com.small.business.service.company;

import java.util.List;

import com.small.business.model.company.CompanyDepartment;

public interface CompanyDepartmentService {

    public List<CompanyDepartment> getAllCompanyDepartment();

    public CompanyDepartment getCompanyDepartmentById(Long id);

    public boolean addCompanyDepartment(CompanyDepartment companyJournal);

    public boolean deleteCompanyDepartmentById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyDepartment(CompanyDepartment companyJournal);

    public boolean addListCompanyDepartment(List<CompanyDepartment> listCompanyDepartment);

    public boolean updateListCompanyDepartment(List<CompanyDepartment> listCompanyDepartment);

    public List<CompanyDepartment> getListCompanyDepartmentByCompanyId(Long companyId);
}
