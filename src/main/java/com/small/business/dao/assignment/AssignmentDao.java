package com.small.business.dao.assignment;

import java.util.List;

import com.small.business.model.assignment.Assignment;

public interface AssignmentDao {

    public List<Assignment> getAllAssignment();

    public Assignment getAssignmentById(Long id);

    public boolean addAssignment(Assignment assignment);

    public Long getNextAssignmentId();

    public boolean deleteAssignmentById(Long id);

    public boolean deleteAll();

    public boolean updateAssignment(Assignment assignment);
}
