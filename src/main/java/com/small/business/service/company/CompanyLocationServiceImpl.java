package com.small.business.service.company;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.company.CompanyLocationDao;
import com.small.business.model.company.CompanyLocation;

@Service("CompanyLocationService")
public class CompanyLocationServiceImpl implements CompanyLocationService {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyLocationServiceImpl.class);
    private static List<CompanyLocation> companyLocationList = new ArrayList<CompanyLocation>();
    private static Long id = 0L;

    @Autowired
    CompanyLocationDao companyLocationDao;

    public List<CompanyLocation> getAllCompanyLocation() {

        List<CompanyLocation> companyLocationList = companyLocationDao.getAllCompanyLocation();
        return companyLocationList;
    }

    public CompanyLocation getCompanyLocationById(Long id) {

        return companyLocationDao.getCompanyLocationById(id);
    }

    public boolean addCompanyLocation(CompanyLocation peopleJournal) {

        peopleJournal.setId(++id);
        return companyLocationDao.addCompanyLocation(peopleJournal);
    }

    public boolean deleteCompanyLocationById(Long id) {

        boolean ret = false;
        ret = companyLocationDao.deleteCompanyLocationById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyLocationList.clear();
        id = 0L;
        return companyLocationDao.deleteAll();
    }

    public boolean updateCompanyLocation(CompanyLocation companyLocation) {

        CompanyLocation foundCompanyLocation = getCompanyLocationById(companyLocation.getId());
        if (foundCompanyLocation != null) {
            companyLocationList.remove(foundCompanyLocation);
            companyLocationList.add(companyLocation);
        }
        return companyLocationDao.updateCompanyLocation(companyLocation);

    }

    public List<CompanyLocation> getListCompanyLocationByCompanyId(Long companyId) {

        return companyLocationDao.getListCompanyLocationByCompanyId(companyId);
    }

    public boolean addListCompanyLocation(List<CompanyLocation> listCompanyLocation) {

        return companyLocationDao.addListCompanyLocation(listCompanyLocation);
    }

    public boolean updateListCompanyLocation(List<CompanyLocation> listCompanyLocation) {

        return companyLocationDao.updateListCompanyLocation(listCompanyLocation);
    }
}
