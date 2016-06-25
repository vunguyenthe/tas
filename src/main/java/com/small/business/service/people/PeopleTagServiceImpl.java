package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.PeopleTagDao;
import com.small.business.model.people.PeopleTag;

@Service("PeopleTagService")
public class PeopleTagServiceImpl implements PeopleTagService {

    private static final Logger logger = LoggerFactory
            .getLogger(PeopleTagServiceImpl.class);
    private static List<PeopleTag> peopleTagList = new ArrayList<PeopleTag>();
    private static Long id = 0L;

    @Autowired
    PeopleTagDao peopleTagDao;

    public List<PeopleTag> getAllPeopleTag() {

        List<PeopleTag> peopleTagList = peopleTagDao.getAllPeopleTag();
        return peopleTagList;
    }

    public PeopleTag getPeopleTagByPeopleId(Long peopleId) {

        return peopleTagDao.getPeopleTagByPeopleId(peopleId);
    }

    public PeopleTag getPeopleTagById(Long id) {

        return peopleTagDao.getPeopleTagById(id);
    }

    public boolean addPeopleTag(PeopleTag peopleJournal) {

        peopleJournal.setId(++id);
        return peopleTagDao.addPeopleTag(peopleJournal);
    }

    public boolean deletePeopleTagById(Long id) {

        boolean ret = false;
        ret = peopleTagDao.deletePeopleTagById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleTagList.clear();
        id = 0L;
        return peopleTagDao.deleteAll();
    }

    public boolean updateListPeopleTag(List<PeopleTag> listPeopleTag) {

        return peopleTagDao.updateListPeopleTag(listPeopleTag);
    }

    public boolean addListPeopleTag(List<PeopleTag> listPeopleTag) {

        return peopleTagDao.addListPeopleTag(listPeopleTag);
    }

    public boolean updatePeopleTag(PeopleTag peopleHistory) {

        PeopleTag foundPeopleTag = getPeopleTagById(peopleHistory.getId());
        if (foundPeopleTag != null) {
            peopleTagList.remove(foundPeopleTag);
            peopleTagList.add(peopleHistory);
        }
        return peopleTagDao.updatePeopleTag(peopleHistory);

    }

}
