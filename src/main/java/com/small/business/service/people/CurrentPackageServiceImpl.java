package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.CurrentPackageDao;
import com.small.business.model.people.CurrentPackage;

@Service("CurrentPackageService")
public class CurrentPackageServiceImpl implements CurrentPackageService {

    private static final Logger logger = LoggerFactory
            .getLogger(CurrentPackageServiceImpl.class);
    private static List<CurrentPackage> currentPackageList = new ArrayList<CurrentPackage>();
    private static Long id = 0L;

    @Autowired
    CurrentPackageDao currentPackageDao;

    public List<CurrentPackage> getAllCurrentPackage() {

        List<CurrentPackage> currentPackageList = currentPackageDao.getAllCurrentPackage();
        return currentPackageList;
    }

    public List<CurrentPackage> getCurrentPackageByPeopleId(Long peopleId) {

        return currentPackageDao.getCurrentPackageByPeopleId(peopleId);
    }

    public CurrentPackage getCurrentPackageById(Long id) {

        return currentPackageDao.getCurrentPackageById(id);
    }

    public boolean addCurrentPackage(CurrentPackage peopleJournal) {

        peopleJournal.setId(++id);
        return currentPackageDao.addCurrentPackage(peopleJournal);
    }

    public boolean deleteCurrentPackageById(Long id) {

        boolean ret = false;
        ret = currentPackageDao.deleteCurrentPackageById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        currentPackageList.clear();
        id = 0L;
        return currentPackageDao.deleteAll();
    }

    public boolean updateListCurrentPackage(List<CurrentPackage> listCurrentPackage) {

        return currentPackageDao.updateListCurrentPackage(listCurrentPackage);
    }

    public boolean addListCurrentPackage(List<CurrentPackage> listCurrentPackage) {

        return currentPackageDao.addListCurrentPackage(listCurrentPackage);
    }

    public boolean updateCurrentPackage(CurrentPackage peopleHistory) {

        CurrentPackage foundCurrentPackage = getCurrentPackageById(peopleHistory.getId());
        if (foundCurrentPackage != null) {
            currentPackageList.remove(foundCurrentPackage);
            currentPackageList.add(peopleHistory);
        }
        return currentPackageDao.updateCurrentPackage(peopleHistory);

    }

}
