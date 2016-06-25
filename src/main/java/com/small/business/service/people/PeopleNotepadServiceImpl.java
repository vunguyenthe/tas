package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.PeopleNotepadDao;
import com.small.business.model.people.PeopleNotepad;

@Service("PeopleNotepadService")
public class PeopleNotepadServiceImpl implements PeopleNotepadService {

    private static final Logger logger = LoggerFactory
            .getLogger(PeopleNotepadServiceImpl.class);
    private static List<PeopleNotepad> peopleNotepadList = new ArrayList<PeopleNotepad>();
    private static Long id = 0L;

    @Autowired
    PeopleNotepadDao peopleNotepadDao;

    public List<PeopleNotepad> getAllPeopleNotepad() {

        List<PeopleNotepad> peopleNotepadList = peopleNotepadDao.getAllPeopleNotepad();
        return peopleNotepadList;
    }

    public PeopleNotepad getPeopleNotepadById(Long id) {

        return peopleNotepadDao.getPeopleNotepadById(id);
    }

    public boolean addPeopleNotepad(PeopleNotepad peopleNotepad) {

        peopleNotepad.setId(++id);
        return peopleNotepadDao.addPeopleNotepad(peopleNotepad);
    }

    public boolean deletePeopleNotepadById(Long id) {

        boolean ret = false;
        ret = peopleNotepadDao.deletePeopleNotepadById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleNotepadList.clear();
        id = 0L;
        return peopleNotepadDao.deleteAll();
    }

    public boolean updatePeopleNotepad(PeopleNotepad peopleNotepad) {

        PeopleNotepad foundPeopleNotepad = getPeopleNotepadById(peopleNotepad.getId());
        if (foundPeopleNotepad != null) {
            peopleNotepadList.remove(foundPeopleNotepad);
            peopleNotepadList.add(peopleNotepad);
        }
        return peopleNotepadDao.updatePeopleNotepad(peopleNotepad);

    }

    public PeopleNotepad getListPeopleNotepadByPeopleId(Long peopleId) {

        return peopleNotepadDao.getListPeopleNotepadByPeopleId(peopleId);
    }

    public boolean addListPeopleNotepad(List<PeopleNotepad> listPeopleNotepad) {

        return peopleNotepadDao.addListPeopleNotepad(listPeopleNotepad);
    }

    public boolean updateListPeopleNotepad(List<PeopleNotepad> listPeopleNotepad) {

        return peopleNotepadDao.updateListPeopleNotepad(listPeopleNotepad);
    }
}
