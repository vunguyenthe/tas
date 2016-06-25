package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.PeopleAssignmentDao;
import com.small.business.model.people.PeopleAssignment;

@Service("PeopleAssignmentService")
public class PeopleAssignmentServiceImpl implements PeopleAssignmentService {

    private static final Logger logger = LoggerFactory
            .getLogger(PeopleAssignmentServiceImpl.class);
    private static List<PeopleAssignment> peopleAssignmentList = new ArrayList<PeopleAssignment>();
    private static Long id = 0L;

    @Autowired
    PeopleAssignmentDao peopleAssignmentDao;

    public List<PeopleAssignment> getAllPeopleAssignment() {

        List<PeopleAssignment> peopleAssignmentList = peopleAssignmentDao.getAllPeopleAssignment();
        return peopleAssignmentList;
    }

    public PeopleAssignment getPeopleAssignmentById(Long id) {

        return peopleAssignmentDao.getPeopleAssignmentById(id);
    }

    public List<PeopleAssignment> getPeopleAssignmentByPeopleId(Long peopleId) {

        return peopleAssignmentDao.getPeopleAssignmentByPeopleId(peopleId);
    }

    public boolean addPeopleAssignment(PeopleAssignment peopleJournal) {

        peopleJournal.setId(++id);
        return peopleAssignmentDao.addPeopleAssignment(peopleJournal);
    }

    public boolean deletePeopleAssignmentById(Long id) {

        boolean ret = false;
        ret = peopleAssignmentDao.deletePeopleAssignmentById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleAssignmentList.clear();
        id = 0L;
        return peopleAssignmentDao.deleteAll();
    }

    public boolean updatePeopleAssignment(PeopleAssignment peopleHistory) {

        PeopleAssignment foundPeopleAssignment = getPeopleAssignmentById(peopleHistory.getId());
        if (foundPeopleAssignment != null) {
            peopleAssignmentList.remove(foundPeopleAssignment);
            peopleAssignmentList.add(peopleHistory);
        }
        return peopleAssignmentDao.updatePeopleAssignment(peopleHistory);

    }

    public boolean updateListPeopleAssignment(List<PeopleAssignment> listPeopleAssignment) {

        return peopleAssignmentDao.updateListPeopleAssignment(listPeopleAssignment);
    }

    public boolean addListPeopleAssignment(List<PeopleAssignment> listPeopleAssignment) {

        return peopleAssignmentDao.addListPeopleAssignment(listPeopleAssignment);
    }

}
