package com.small.business.service.people;

import java.util.List;

import com.small.business.model.people.PeopleDocument;

public interface PeopleDocumentService {

    public List<PeopleDocument> getAllPeopleDocument();

    public PeopleDocument getPeopleDocumentById(Long id);

    public boolean addPeopleDocument(PeopleDocument peopleDocument);

    public boolean addListPeopleDocument(List<PeopleDocument> listPeopleDocument);

    public List<PeopleDocument> getPeopleDocumentByPeopleId(Long peopleId);

    public boolean updateListPeopleDocument(List<PeopleDocument> listPeopleDocument);

    public boolean deletePeopleDocumentById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleDocument(PeopleDocument peopleDocument);
}