package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.People;

public interface PeopleDao {

    public List<People> getAllPeople();

    public List<People> getAllClient();

    public List<People> getAllCandidate();

    public People getPeopleById(Long id);

    public Long getNextPeopleId();

    public boolean addPeople(People People);

    public boolean deletePeopleById(Long id);

    public boolean deleteAll();

    public boolean updatePeople(People people);
}
