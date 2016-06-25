package com.small.business.service.company;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.company.CompanyNoteDao;
import com.small.business.model.company.CompanyNote;

@Service("CompanyNoteService")
public class CompanyNoteServiceImpl implements CompanyNoteService {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyNoteServiceImpl.class);
    private static List<CompanyNote> companyDepartmentList = new ArrayList<CompanyNote>();
    private static Long id = 0L;

    @Autowired
    CompanyNoteDao companyDepartmentDao;

    public List<CompanyNote> getAllCompanyNote() {

        List<CompanyNote> companyDepartmentList = companyDepartmentDao.getAllCompanyNote();
        return companyDepartmentList;
    }

    public CompanyNote getCompanyNoteById(Long id) {

        return companyDepartmentDao.getCompanyNoteById(id);
    }

    public boolean addCompanyNote(CompanyNote peopleJournal) {

        peopleJournal.setId(++id);
        return companyDepartmentDao.addCompanyNote(peopleJournal);
    }

    public boolean deleteCompanyNoteById(Long id) {

        boolean ret = false;
        ret = companyDepartmentDao.deleteCompanyNoteById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyDepartmentList.clear();
        id = 0L;
        return companyDepartmentDao.deleteAll();
    }

    public boolean updateCompanyNote(CompanyNote companyDepartment) {

        CompanyNote foundCompanyNote = getCompanyNoteById(companyDepartment.getId());
        if (foundCompanyNote != null) {
            companyDepartmentList.remove(foundCompanyNote);
            companyDepartmentList.add(companyDepartment);
        }
        return companyDepartmentDao.updateCompanyNote(companyDepartment);

    }

    public List<CompanyNote> getListCompanyNoteByCompanyId(Long companyId) {

        return companyDepartmentDao.getListCompanyNoteByCompanyId(companyId);
    }

    public boolean addListCompanyNote(List<CompanyNote> listCompanyNote) {

        return companyDepartmentDao.addListCompanyNote(listCompanyNote);
    }

    public boolean updateListCompanyNote(List<CompanyNote> listCompanyNote) {

        return companyDepartmentDao.updateListCompanyNote(listCompanyNote);
    }
}
