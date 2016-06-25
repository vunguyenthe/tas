package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.PeopleJournalDao;
import com.small.business.model.people.PeopleJournal;

@Service("PeopleJournalService")
public class PeopleJournalServiceImpl implements PeopleJournalService {

    private static final Logger logger = LoggerFactory
            .getLogger(PeopleJournalServiceImpl.class);
    private static List<PeopleJournal> peopleJournalList = new ArrayList<PeopleJournal>();
    private static Long id = 0L;

    @Autowired
    PeopleJournalDao peopleJournalDao;

    public List<PeopleJournal> getAllPeopleJournal() {

        List<PeopleJournal> peopleJournalList = peopleJournalDao.getAllPeopleJournal();
        return peopleJournalList;
    }

    public PeopleJournal getPeopleJournalById(Long id) {

        return peopleJournalDao.getPeopleJournalById(id);
    }

    public boolean addPeopleJournal(PeopleJournal peopleJournal) {

        peopleJournal.setId(++id);
        return peopleJournalDao.addPeopleJournal(peopleJournal);
    }

    public List<PeopleJournal> getPeopleJournalByPeopleId(Long peopleId) {

        return peopleJournalDao.getPeopleJournalByPeopleId(peopleId);
    }

    public boolean addListPeopleJournal(List<PeopleJournal> listPeopleJournal) {

        return peopleJournalDao.addListPeopleJournal(listPeopleJournal);
    }

    public boolean updateListPeopleJournal(List<PeopleJournal> listPeopleJournal) {

        return peopleJournalDao.updateListPeopleJournal(listPeopleJournal);
    }

    public boolean deletePeopleJournalById(Long id) {

        boolean ret = false;
        ret = peopleJournalDao.deletePeopleJournalById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleJournalList.clear();
        id = 0L;
        return peopleJournalDao.deleteAll();
    }

    public boolean updatePeopleJournal(PeopleJournal peopleJournal) {

        PeopleJournal foundPeopleJournal = getPeopleJournalById(peopleJournal.getId());
        if (foundPeopleJournal != null) {
            peopleJournalList.remove(foundPeopleJournal);
            peopleJournalList.add(peopleJournal);
        }
        return peopleJournalDao.updatePeopleJournal(peopleJournal);

    }

}
