package com.small.business.dao.company;

import java.util.List;

import com.small.business.model.company.CompanyDepartment;

public interface CompanyDepartmentDao {

    public List<CompanyDepartment> getAllCompanyDepartment();

    public CompanyDepartment getCompanyDepartmentById(Long id);

    public boolean addCompanyDepartment(CompanyDepartment companyPeople);

    public boolean deleteCompanyDepartmentById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyDepartment(CompanyDepartment companyPeople);

    public boolean addListCompanyDepartment(List<CompanyDepartment> listCompanyDepartment);

    public boolean updateListCompanyDepartment(List<CompanyDepartment> listCompanyDepartment);

    public List<CompanyDepartment> getListCompanyDepartmentByCompanyId(Long companyId);
}
