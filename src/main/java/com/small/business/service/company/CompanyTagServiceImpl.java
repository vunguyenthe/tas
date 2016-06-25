package com.small.business.service.company;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.company.CompanyTagDao;
import com.small.business.model.company.CompanyTag;

@Service("CompanyTagService")
public class CompanyTagServiceImpl implements CompanyTagService {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyTagServiceImpl.class);
    private static List<CompanyTag> companyTagList = new ArrayList<CompanyTag>();
    private static Long id = 0L;

    @Autowired
    CompanyTagDao companyTagDao;

    public List<CompanyTag> getAllCompanyTag() {

        List<CompanyTag> companyTagList = companyTagDao.getAllCompanyTag();
        return companyTagList;
    }

    public CompanyTag getCompanyTagByCompanyId(Long companyId) {

        return companyTagDao.getCompanyTagByCompanyId(companyId);
    }

    public CompanyTag getCompanyTagById(Long id) {

        return companyTagDao.getCompanyTagById(id);
    }

    public boolean addCompanyTag(CompanyTag companyJournal) {

        companyJournal.setId(++id);
        return companyTagDao.addCompanyTag(companyJournal);
    }

    public boolean deleteCompanyTagById(Long id) {

        boolean ret = false;
        ret = companyTagDao.deleteCompanyTagById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyTagList.clear();
        id = 0L;
        return companyTagDao.deleteAll();
    }

    public boolean updateListCompanyTag(List<CompanyTag> listCompanyTag) {

        return companyTagDao.updateListCompanyTag(listCompanyTag);
    }

    public boolean addListCompanyTag(List<CompanyTag> listCompanyTag) {

        return companyTagDao.addListCompanyTag(listCompanyTag);
    }

    public boolean updateCompanyTag(CompanyTag companyHistory) {

        CompanyTag foundCompanyTag = getCompanyTagById(companyHistory.getId());
        if (foundCompanyTag != null) {
            companyTagList.remove(foundCompanyTag);
            companyTagList.add(companyHistory);
        }
        return companyTagDao.updateCompanyTag(companyHistory);

    }

}
