package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.PeopleEducationDao;
import com.small.business.model.people.PeopleEducation;

@Service("PeopleEducationService")
public class PeopleEducationServiceImpl implements PeopleEducationService {

    private static final Logger logger = LoggerFactory
            .getLogger(PeopleEducationServiceImpl.class);
    private static List<PeopleEducation> peopleEducationList = new ArrayList<PeopleEducation>();
    private static Long id = 0L;

    @Autowired
    PeopleEducationDao peopleEducationDao;

    public List<PeopleEducation> getAllPeopleEducation() {

        List<PeopleEducation> peopleEducationList = peopleEducationDao.getAllPeopleEducation();
        return peopleEducationList;
    }

    public List<PeopleEducation> getPeopleEducationByPeopleId(Long peopleId) {

        return peopleEducationDao.getPeopleEducationByPeopleId(peopleId);
    }

    public PeopleEducation getPeopleEducationById(Long id) {

        return peopleEducationDao.getPeopleEducationById(id);
    }

    public boolean addPeopleEducation(PeopleEducation peopleJournal) {

        peopleJournal.setId(++id);
        return peopleEducationDao.addPeopleEducation(peopleJournal);
    }

    public boolean deletePeopleEducationById(Long id) {

        boolean ret = false;
        ret = peopleEducationDao.deletePeopleEducationById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleEducationList.clear();
        id = 0L;
        return peopleEducationDao.deleteAll();
    }

    public boolean addListPeopleEducation(List<PeopleEducation> listPeopleEducation) {

        return peopleEducationDao.addListPeopleEducation(listPeopleEducation);
    }

    public boolean updateListPeopleEducation(List<PeopleEducation> listPeopleEducation) {

        return peopleEducationDao.updateListPeopleEducation(listPeopleEducation);
    }

    public boolean updatePeopleEducation(PeopleEducation peopleEducation) {

        PeopleEducation foundPeopleEducation = getPeopleEducationById(peopleEducation.getId());
        if (foundPeopleEducation != null) {
            peopleEducationList.remove(foundPeopleEducation);
            peopleEducationList.add(peopleEducation);
        }
        return peopleEducationDao.updatePeopleEducation(peopleEducation);

    }

}
