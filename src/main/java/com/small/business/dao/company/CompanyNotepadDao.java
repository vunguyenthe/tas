package com.small.business.dao.company;

import java.util.List;

import com.small.business.model.company.CompanyNotepad;

public interface CompanyNotepadDao {

    public List<CompanyNotepad> getAllCompanyNotepad();

    public CompanyNotepad getCompanyNotepadById(Long id);

    public boolean addCompanyNotepad(CompanyNotepad companyPeople);

    public boolean deleteCompanyNotepadById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyNotepad(CompanyNotepad companyPeople);

    public boolean addListCompanyNotepad(List<CompanyNotepad> listCompanyNotepad);

    public boolean updateListCompanyNotepad(List<CompanyNotepad> listCompanyNotepad);

    public CompanyNotepad getCompanyNotepadByCompanyId(Long assignmentId);
}
