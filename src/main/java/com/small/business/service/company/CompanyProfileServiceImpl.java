package com.small.business.service.company;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.company.CompanyProfileDao;
import com.small.business.model.company.CompanyProfile;

@Service("CompanyProfileService")
public class CompanyProfileServiceImpl implements CompanyProfileService {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyProfileServiceImpl.class);
    private static List<CompanyProfile> companyProfileList = new ArrayList<CompanyProfile>();
    private static Long id = 0L;

    @Autowired
    CompanyProfileDao companyProfileDao;

    public List<CompanyProfile> getAllCompanyProfile() {

        List<CompanyProfile> companyProfileList = companyProfileDao.getAllCompanyProfile();
        return companyProfileList;
    }

    public CompanyProfile getCompanyProfileById(Long id) {

        return companyProfileDao.getCompanyProfileById(id);
    }

    public boolean addCompanyProfile(CompanyProfile peopleJournal) {

        peopleJournal.setId(++id);
        return companyProfileDao.addCompanyProfile(peopleJournal);
    }

    public boolean deleteCompanyProfileById(Long id) {

        boolean ret = false;
        ret = companyProfileDao.deleteCompanyProfileById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyProfileList.clear();
        id = 0L;
        return companyProfileDao.deleteAll();
    }

    public boolean updateCompanyProfile(CompanyProfile companyProfile) {

        CompanyProfile foundCompanyProfile = getCompanyProfileById(companyProfile.getId());
        if (foundCompanyProfile != null) {
            companyProfileList.remove(foundCompanyProfile);
            companyProfileList.add(companyProfile);
        }
        return companyProfileDao.updateCompanyProfile(companyProfile);
    }

    public CompanyProfile getCompanyProfileByCompanyId(Long companyId) {

        return companyProfileDao.getCompanyProfileByCompanyId(companyId);
    }

    public boolean addListCompanyProfile(List<CompanyProfile> listCompanyProfile) {

        return companyProfileDao.addListCompanyProfile(listCompanyProfile);
    }

    public boolean updateListCompanyProfile(List<CompanyProfile> listCompanyProfile) {

        return companyProfileDao.updateListCompanyProfile(listCompanyProfile);
    }
}
