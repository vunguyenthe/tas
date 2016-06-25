package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.PeopleDocumentDao;
import com.small.business.model.people.PeopleDocument;

@Service("PeopleDocumentService")
public class PeopleDocumentServiceImpl implements PeopleDocumentService {

    private static final Logger logger = LoggerFactory
            .getLogger(PeopleDocumentServiceImpl.class);
    private static List<PeopleDocument> peopleDocumentList = new ArrayList<PeopleDocument>();
    private static Long id = 0L;

    @Autowired
    PeopleDocumentDao peopleDocumentDao;

    public List<PeopleDocument> getAllPeopleDocument() {

        List<PeopleDocument> peopleDocumentList = peopleDocumentDao.getAllPeopleDocument();
        return peopleDocumentList;
    }

    public List<PeopleDocument> getPeopleDocumentByPeopleId(Long peopleId) {

        return peopleDocumentDao.getPeopleDocumentByPeopleId(peopleId);
    }

    public PeopleDocument getPeopleDocumentById(Long id) {

        return peopleDocumentDao.getPeopleDocumentById(id);
    }

    public boolean addPeopleDocument(PeopleDocument peopleJournal) {

        peopleJournal.setId(++id);
        return peopleDocumentDao.addPeopleDocument(peopleJournal);
    }

    public boolean deletePeopleDocumentById(Long id) {

        boolean ret = false;
        ret = peopleDocumentDao.deletePeopleDocumentById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleDocumentList.clear();
        id = 0L;
        return peopleDocumentDao.deleteAll();
    }

    public boolean updateListPeopleDocument(List<PeopleDocument> listPeopleDocument) {

        return peopleDocumentDao.updateListPeopleDocument(listPeopleDocument);
    }

    public boolean addListPeopleDocument(List<PeopleDocument> listPeopleDocument) {

        return peopleDocumentDao.addListPeopleDocument(listPeopleDocument);
    }

    public boolean updatePeopleDocument(PeopleDocument peopleHistory) {

        PeopleDocument foundPeopleDocument = getPeopleDocumentById(peopleHistory.getId());
        if (foundPeopleDocument != null) {
            peopleDocumentList.remove(foundPeopleDocument);
            peopleDocumentList.add(peopleHistory);
        }
        return peopleDocumentDao.updatePeopleDocument(peopleHistory);

    }

}
