package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.PeopleAssignment;

public interface PeopleAssignmentDao {

    public List<PeopleAssignment> getAllPeopleAssignment();

    public PeopleAssignment getPeopleAssignmentById(Long id);

    public boolean addPeopleAssignment(PeopleAssignment peopleAssignment);

    public List<PeopleAssignment> getPeopleAssignmentByPeopleId(Long peopleId);

    public boolean deletePeopleAssignmentById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleAssignment(PeopleAssignment peopleAssignment);

    public boolean addListPeopleAssignment(List<PeopleAssignment> listPeopleAssignment);

    public boolean updateListPeopleAssignment(List<PeopleAssignment> listPeopleAssignment);
}
