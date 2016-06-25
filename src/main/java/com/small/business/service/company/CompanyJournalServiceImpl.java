package com.small.business.service.company;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.company.CompanyJournalDao;
import com.small.business.model.company.CompanyJournal;

@Service("CompanyJournalService")
public class CompanyJournalServiceImpl implements CompanyJournalService {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyJournalServiceImpl.class);
    private static List<CompanyJournal> companyJournalList = new ArrayList<CompanyJournal>();
    private static Long id = 0L;

    @Autowired
    CompanyJournalDao companyJournalDao;

    public List<CompanyJournal> getAllCompanyJournal() {

        List<CompanyJournal> companyJournalList = companyJournalDao.getAllCompanyJournal();
        return companyJournalList;
    }

    public CompanyJournal getCompanyJournalById(Long id) {

        return companyJournalDao.getCompanyJournalById(id);
    }

    public boolean addCompanyJournal(CompanyJournal peopleJournal) {

        peopleJournal.setId(++id);
        return companyJournalDao.addCompanyJournal(peopleJournal);
    }

    public boolean deleteCompanyJournalById(Long id) {

        boolean ret = false;
        ret = companyJournalDao.deleteCompanyJournalById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyJournalList.clear();
        id = 0L;
        return companyJournalDao.deleteAll();
    }

    public boolean updateCompanyJournal(CompanyJournal companyJournal) {

        CompanyJournal foundCompanyJournal = getCompanyJournalById(companyJournal.getId());
        if (foundCompanyJournal != null) {
            companyJournalList.remove(foundCompanyJournal);
            companyJournalList.add(companyJournal);
        }
        return companyJournalDao.updateCompanyJournal(companyJournal);

    }

    public List<CompanyJournal> getListCompanyJournalByCompanyId(Long companyId) {

        return companyJournalDao.getListCompanyJournalByCompanyId(companyId);
    }

    public boolean addListCompanyJournal(List<CompanyJournal> listCompanyJournal) {

        return companyJournalDao.addListCompanyJournal(listCompanyJournal);
    }

    public boolean updateListCompanyJournal(List<CompanyJournal> listCompanyJournal) {

        return companyJournalDao.updateListCompanyJournal(listCompanyJournal);
    }
}
