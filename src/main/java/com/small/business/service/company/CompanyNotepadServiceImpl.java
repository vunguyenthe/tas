package com.small.business.service.company;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.company.CompanyNotepadDao;
import com.small.business.model.company.CompanyNotepad;

@Service("CompanyNotepadService")
public class CompanyNotepadServiceImpl implements CompanyNotepadService {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyNotepadServiceImpl.class);
    private static List<CompanyNotepad> companyNotepadList = new ArrayList<CompanyNotepad>();
    private static Long id = 0L;

    @Autowired
    CompanyNotepadDao companyNotepadDao;

    public List<CompanyNotepad> getAllCompanyNotepad() {

        List<CompanyNotepad> companyNotepadList = companyNotepadDao.getAllCompanyNotepad();
        return companyNotepadList;
    }

    public CompanyNotepad getCompanyNotepadById(Long id) {

        return companyNotepadDao.getCompanyNotepadById(id);
    }

    public boolean addCompanyNotepad(CompanyNotepad peopleJournal) {

        peopleJournal.setId(++id);
        return companyNotepadDao.addCompanyNotepad(peopleJournal);
    }

    public boolean deleteCompanyNotepadById(Long id) {

        boolean ret = false;
        ret = companyNotepadDao.deleteCompanyNotepadById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyNotepadList.clear();
        id = 0L;
        return companyNotepadDao.deleteAll();
    }

    public boolean updateCompanyNotepad(CompanyNotepad companyNotepad) {

        CompanyNotepad foundCompanyNotepad = getCompanyNotepadById(companyNotepad.getId());
        if (foundCompanyNotepad != null) {
            companyNotepadList.remove(foundCompanyNotepad);
            companyNotepadList.add(companyNotepad);
        }
        return companyNotepadDao.updateCompanyNotepad(companyNotepad);
    }

    public CompanyNotepad getCompanyNotepadByCompanyId(Long companyId) {

        return companyNotepadDao.getCompanyNotepadByCompanyId(companyId);
    }

    public boolean addListCompanyNotepad(List<CompanyNotepad> listCompanyNotepad) {

        return companyNotepadDao.addListCompanyNotepad(listCompanyNotepad);
    }

    public boolean updateListCompanyNotepad(List<CompanyNotepad> listCompanyNotepad) {

        return companyNotepadDao.updateListCompanyNotepad(listCompanyNotepad);
    }
}
