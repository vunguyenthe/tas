package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.PeopleJournal;

public interface PeopleJournalDao {

    public List<PeopleJournal> getAllPeopleJournal();

    public PeopleJournal getPeopleJournalById(Long id);

    public List<PeopleJournal> getPeopleJournalByPeopleId(Long peopleId);

    public boolean addPeopleJournal(PeopleJournal peopleJournal);

    public boolean addListPeopleJournal(List<PeopleJournal> listPeopleJournal);

    public boolean updateListPeopleJournal(List<PeopleJournal> listPeopleJournal);

    public boolean deletePeopleJournalById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleJournal(PeopleJournal peopleJournal);
}
