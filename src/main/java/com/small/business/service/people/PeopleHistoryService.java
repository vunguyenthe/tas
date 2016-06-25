package com.small.business.service.people;

import java.util.List;

import com.small.business.model.people.PeopleHistory;

public interface PeopleHistoryService {

    public List<PeopleHistory> getAllPeopleHistory();

    public PeopleHistory getPeopleHistoryById(Long id);

    public boolean addPeopleHistory(PeopleHistory peopleHistory);

    public boolean addListPeopleHistory(List<PeopleHistory> listPeopleHistory);

    public List<PeopleHistory> getPeopleHistoryByPeopleId(Long peopleId);

    public boolean updateListPeopleHistory(List<PeopleHistory> listPeopleHistory);

    public boolean deletePeopleHistoryById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleHistory(PeopleHistory peopleHistory);
}
