package com.small.business.service.company;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.company.CompanyPeopleDao;
import com.small.business.model.company.CompanyPeople;

@Service("CompanyPeopleService")
public class CompanyPeopleServiceImpl implements CompanyPeopleService {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyPeopleServiceImpl.class);
    private static List<CompanyPeople> companyPeopleList = new ArrayList<CompanyPeople>();
    private static Long id = 0L;

    @Autowired
    CompanyPeopleDao companyPeopleDao;

    public List<CompanyPeople> getAllCompanyPeople() {

        List<CompanyPeople> companyPeopleList = companyPeopleDao.getAllCompanyPeople();
        return companyPeopleList;
    }

    public CompanyPeople getCompanyPeopleById(Long id) {

        return companyPeopleDao.getCompanyPeopleById(id);
    }

    public boolean addCompanyPeople(CompanyPeople companyPeople) {

        companyPeople.setId(++id);
        return companyPeopleDao.addCompanyPeople(companyPeople);
    }

    public boolean deleteCompanyPeopleById(Long id) {

        boolean ret = false;
        ret = companyPeopleDao.deleteCompanyPeopleById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyPeopleList.clear();
        id = 0L;
        return companyPeopleDao.deleteAll();
    }

    public boolean updateCompanyPeople(CompanyPeople companyPeople) {

        CompanyPeople foundCompanyPeople = getCompanyPeopleById(companyPeople.getId());
        if (foundCompanyPeople != null) {
            companyPeopleList.remove(foundCompanyPeople);
            companyPeopleList.add(companyPeople);
        }
        return companyPeopleDao.updateCompanyPeople(companyPeople);

    }

    public List<CompanyPeople> getListCompanyPeopleByCompanyId(Long companyId) {

        return companyPeopleDao.getListCompanyPeopleByCompanyId(companyId);
    }

    public boolean addListCompanyPeople(List<CompanyPeople> listCompanyPeople) {

        return companyPeopleDao.addListCompanyPeople(listCompanyPeople);
    }

    public boolean updateListCompanyPeople(List<CompanyPeople> listCompanyPeople) {

        return companyPeopleDao.updateListCompanyPeople(listCompanyPeople);
    }

}
