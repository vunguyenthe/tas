package com.small.business.service.company;

import java.util.List;

import com.small.business.model.company.CompanyJournal;

public interface CompanyJournalService {

    public List<CompanyJournal> getAllCompanyJournal();

    public CompanyJournal getCompanyJournalById(Long id);

    public boolean addCompanyJournal(CompanyJournal companyJournal);

    public boolean deleteCompanyJournalById(Long id);

    public boolean deleteAll();

    public boolean updateCompanyJournal(CompanyJournal companyJournal);

    public boolean addListCompanyJournal(List<CompanyJournal> listCompanyJournal);

    public boolean updateListCompanyJournal(List<CompanyJournal> listCompanyJournal);

    public List<CompanyJournal> getListCompanyJournalByCompanyId(Long companyId);
}
