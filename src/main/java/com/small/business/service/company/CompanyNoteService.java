package com.small.business.service.company;

import java.util.List;

import com.small.business.model.company.CompanyNote;

public interface CompanyNoteService {

    public List<CompanyNote> getAllCompanyNote();

    public CompanyNote getCompanyNoteById(Long id);

    public boolean addCompanyNote(CompanyNote companyJournal);

    public boolean deleteCompanyNoteById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyNote(CompanyNote companyJournal);

    public boolean addListCompanyNote(List<CompanyNote> listCompanyNote);

    public boolean updateListCompanyNote(List<CompanyNote> listCompanyNote);

    public List<CompanyNote> getListCompanyNoteByCompanyId(Long companyId);
}
