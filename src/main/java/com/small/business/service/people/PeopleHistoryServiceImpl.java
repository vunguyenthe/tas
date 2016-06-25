package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.PeopleHistoryDao;
import com.small.business.model.people.PeopleHistory;

@Service("PeopleHistoryService")
public class PeopleHistoryServiceImpl implements PeopleHistoryService {

    private static final Logger logger = LoggerFactory
            .getLogger(PeopleHistoryServiceImpl.class);
    private static List<PeopleHistory> peopleHistoryList = new ArrayList<PeopleHistory>();
    private static Long id = 0L;

    @Autowired
    PeopleHistoryDao peopleHistoryDao;

    public List<PeopleHistory> getAllPeopleHistory() {

        List<PeopleHistory> peopleHistoryList = peopleHistoryDao.getAllPeopleHistory();
        return peopleHistoryList;
    }

    public PeopleHistory getPeopleHistoryById(Long id) {

        return peopleHistoryDao.getPeopleHistoryById(id);
    }

    public List<PeopleHistory> getPeopleHistoryByPeopleId(Long peopleId) {

        return peopleHistoryDao.getPeopleHistoryByPeopleId(peopleId);
    }

    public boolean addListPeopleHistory(List<PeopleHistory> listPeopleHistory) {

        return peopleHistoryDao.addListPeopleHistory(listPeopleHistory);
    }

    public boolean updateListPeopleHistory(List<PeopleHistory> listPeopleHistory) {

        return peopleHistoryDao.updateListPeopleHistory(listPeopleHistory);
    }

    public boolean addPeopleHistory(PeopleHistory peopleJournal) {

        peopleJournal.setId(++id);
        return peopleHistoryDao.addPeopleHistory(peopleJournal);
    }

    public boolean deletePeopleHistoryById(Long id) {

        boolean ret = false;
        ret = peopleHistoryDao.deletePeopleHistoryById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleHistoryList.clear();
        id = 0L;
        return peopleHistoryDao.deleteAll();
    }

    public boolean updatePeopleHistory(PeopleHistory peopleHistory) {

        PeopleHistory foundPeopleHistory = getPeopleHistoryById(peopleHistory.getId());
        if (foundPeopleHistory != null) {
            peopleHistoryList.remove(foundPeopleHistory);
            peopleHistoryList.add(peopleHistory);
        }
        return peopleHistoryDao.updatePeopleHistory(peopleHistory);

    }

}
