package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.NationalityDao;
import com.small.business.model.people.Nationality;

@Service("NationalityService")
public class NationalityServiceImpl implements NationalityService {

    private static final Logger logger = LoggerFactory
            .getLogger(NationalityServiceImpl.class);
    private static List<Nationality> nationalityList = new ArrayList<Nationality>();
    private static Long id = 0L;

    @Autowired
    NationalityDao nationalityDao;

    public List<Nationality> getAllNationality() {

        List<Nationality> nationalityList = nationalityDao.getAllNationality();
        return nationalityList;
    }

    public Nationality getNationalityById(Long id) {

        return nationalityDao.getNationalityById(id);
    }

    public boolean addNationality(Nationality peopleJournal) {

        peopleJournal.setId(++id);
        return nationalityDao.addNationality(peopleJournal);
    }

    public boolean deleteNationalityById(Long id) {

        boolean ret = false;
        ret = nationalityDao.deleteNationalityById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        nationalityList.clear();
        id = 0L;
        return nationalityDao.deleteAll();
    }

    public boolean updateListNationality(List<Nationality> listNationality) {

        return nationalityDao.updateListNationality(listNationality);
    }

    public boolean addListNationality(List<Nationality> listNationality) {

        return nationalityDao.addListNationality(listNationality);
    }

    public boolean updateNationality(Nationality peopleHistory) {

        Nationality foundNationality = getNationalityById(peopleHistory.getId());
        if (foundNationality != null) {
            nationalityList.remove(foundNationality);
            nationalityList.add(peopleHistory);
        }
        return nationalityDao.updateNationality(peopleHistory);

    }

}
