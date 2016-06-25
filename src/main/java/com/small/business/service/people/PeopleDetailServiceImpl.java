package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.PeopleDetailDao;
import com.small.business.model.people.PeopleDetail;

@Service("PeopleDetailService")
public class PeopleDetailServiceImpl implements PeopleDetailService {

    private static final Logger logger = LoggerFactory
            .getLogger(PeopleDetailServiceImpl.class);
    private static List<PeopleDetail> peopleDetailList = new ArrayList<PeopleDetail>();
    private static Long id = 0L;

    @Autowired
    PeopleDetailDao peopleDetailDao;

    public List<PeopleDetail> getAllPeopleDetail() {

        List<PeopleDetail> peopleDetailList = peopleDetailDao.getAllPeopleDetail();
        return peopleDetailList;
    }

    public Long getNextPeopleId() {

        return peopleDetailDao.getNextPeopleId();
    }

    public PeopleDetail getPeopleDetailByPeopleId(Long peopleId) {

        return peopleDetailDao.getPeopleDetailByPeopleId(peopleId);
    }

    public PeopleDetail getPeopleDetailById(Long id) {

        return peopleDetailDao.getPeopleDetailById(id);
    }

    public boolean addPeopleDetail(PeopleDetail peopleJournal) {

        peopleJournal.setId(++id);
        return peopleDetailDao.addPeopleDetail(peopleJournal);
    }

    public boolean deletePeopleDetailById(Long id) {

        boolean ret = false;
        ret = peopleDetailDao.deletePeopleDetailById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleDetailList.clear();
        id = 0L;
        return peopleDetailDao.deleteAll();
    }

    public boolean updateListPeopleDetail(List<PeopleDetail> listPeopleDetail) {

        return peopleDetailDao.updateListPeopleDetail(listPeopleDetail);
    }

    public boolean addListPeopleDetail(List<PeopleDetail> listPeopleDetail) {

        return peopleDetailDao.addListPeopleDetail(listPeopleDetail);
    }

    public boolean updatePeopleDetail(PeopleDetail peopleDetail) {

        PeopleDetail foundPeopleDetail = getPeopleDetailByPeopleId(peopleDetail.getPeopleId());
        if (foundPeopleDetail != null) {
            peopleDetailList.remove(foundPeopleDetail);
            peopleDetailList.add(peopleDetail);
        }
        return peopleDetailDao.updatePeopleDetail(peopleDetail);

    }

}
