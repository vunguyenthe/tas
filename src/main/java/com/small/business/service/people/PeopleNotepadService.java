package com.small.business.service.people;

import java.util.List;

import com.small.business.model.people.PeopleNotepad;

public interface PeopleNotepadService {

    public List<PeopleNotepad> getAllPeopleNotepad();

    public PeopleNotepad getPeopleNotepadById(Long id);

    public boolean addPeopleNotepad(PeopleNotepad peopleNotepad);

    public boolean deletePeopleNotepadById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleNotepad(PeopleNotepad peopleNotepad);

    public boolean addListPeopleNotepad(List<PeopleNotepad> listPeopleNotepad);

    public boolean updateListPeopleNotepad(List<PeopleNotepad> listPeopleNotepad);

    public PeopleNotepad getListPeopleNotepadByPeopleId(Long peopleId);
}
