package com.small.business.service.company;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.company.CompanyDepartmentDao;
import com.small.business.model.company.CompanyDepartment;

@Service("CompanyDepartmentService")
public class CompanyDepartmentServiceImpl implements CompanyDepartmentService {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyDepartmentServiceImpl.class);
    private static List<CompanyDepartment> companyDepartmentList = new ArrayList<CompanyDepartment>();
    private static Long id = 0L;

    @Autowired
    CompanyDepartmentDao companyDepartmentDao;

    public List<CompanyDepartment> getAllCompanyDepartment() {

        List<CompanyDepartment> companyDepartmentList = companyDepartmentDao.getAllCompanyDepartment();
        return companyDepartmentList;
    }

    public CompanyDepartment getCompanyDepartmentById(Long id) {

        return companyDepartmentDao.getCompanyDepartmentById(id);
    }

    public boolean addCompanyDepartment(CompanyDepartment peopleJournal) {

        peopleJournal.setId(++id);
        return companyDepartmentDao.addCompanyDepartment(peopleJournal);
    }

    public boolean deleteCompanyDepartmentById(Long id) {

        boolean ret = false;
        ret = companyDepartmentDao.deleteCompanyDepartmentById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyDepartmentList.clear();
        id = 0L;
        return companyDepartmentDao.deleteAll();
    }

    public boolean updateCompanyDepartment(CompanyDepartment companyDepartment) {

        CompanyDepartment foundCompanyDepartment = getCompanyDepartmentById(companyDepartment.getId());
        if (foundCompanyDepartment != null) {
            companyDepartmentList.remove(foundCompanyDepartment);
            companyDepartmentList.add(companyDepartment);
        }
        return companyDepartmentDao.updateCompanyDepartment(companyDepartment);

    }

    public List<CompanyDepartment> getListCompanyDepartmentByCompanyId(Long companyId) {

        return companyDepartmentDao.getListCompanyDepartmentByCompanyId(companyId);
    }

    public boolean addListCompanyDepartment(List<CompanyDepartment> listCompanyDepartment) {

        return companyDepartmentDao.addListCompanyDepartment(listCompanyDepartment);
    }

    public boolean updateListCompanyDepartment(List<CompanyDepartment> listCompanyDepartment) {

        return companyDepartmentDao.updateListCompanyDepartment(listCompanyDepartment);
    }
}
