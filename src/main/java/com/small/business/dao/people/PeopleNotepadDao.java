package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.PeopleNotepad;

public interface PeopleNotepadDao {

    public List<PeopleNotepad> getAllPeopleNotepad();

    public PeopleNotepad getPeopleNotepadById(Long id);

    public boolean addPeopleNotepad(PeopleNotepad companyPeople);

    public boolean deletePeopleNotepadById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleNotepad(PeopleNotepad companyPeople);

    public boolean addListPeopleNotepad(List<PeopleNotepad> listPeopleNotepad);

    public boolean updateListPeopleNotepad(List<PeopleNotepad> listPeopleNotepad);

    public PeopleNotepad getListPeopleNotepadByPeopleId(Long peopleId);
}
