package com.small.business.service.people;

import java.util.List;

import com.small.business.model.people.PeopleAssignment;

public interface PeopleAssignmentService {

    public List<PeopleAssignment> getAllPeopleAssignment();

    public PeopleAssignment getPeopleAssignmentById(Long id);

    public boolean addPeopleAssignment(PeopleAssignment peopleAssignment);

    public boolean addListPeopleAssignment(List<PeopleAssignment> listPeopleAssignment);

    public List<PeopleAssignment> getPeopleAssignmentByPeopleId(Long peopleId);

    public boolean updateListPeopleAssignment(List<PeopleAssignment> listPeopleAssignment);

    public boolean deletePeopleAssignmentById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleAssignment(PeopleAssignment peopleAssignment);
}
