package com.small.business.dao.company;

import java.util.List;

import com.small.business.model.company.CompanyNote;

public interface CompanyNoteDao {

    public List<CompanyNote> getAllCompanyNote();

    public CompanyNote getCompanyNoteById(Long id);

    public boolean addCompanyNote(CompanyNote companyPeople);

    public boolean deleteCompanyNoteById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyNote(CompanyNote companyPeople);

    public boolean addListCompanyNote(List<CompanyNote> listCompanyNote);

    public boolean updateListCompanyNote(List<CompanyNote> listCompanyNote);

    public List<CompanyNote> getListCompanyNoteByCompanyId(Long companyId);
}
