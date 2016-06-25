package com.small.business.service.company;

import java.util.List;

import com.small.business.model.company.CompanyNotepad;

public interface CompanyNotepadService {

    public List<CompanyNotepad> getAllCompanyNotepad();

    public CompanyNotepad getCompanyNotepadById(Long id);

    public boolean addCompanyNotepad(CompanyNotepad companyJournal);

    public boolean deleteCompanyNotepadById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyNotepad(CompanyNotepad companyJournal);

    public boolean addListCompanyNotepad(List<CompanyNotepad> listCompanyNotepad);

    public boolean updateListCompanyNotepad(List<CompanyNotepad> listCompanyNotepad);

    public CompanyNotepad getCompanyNotepadByCompanyId(Long assignmentId);
}
