package com.small.business.service.assignment;

import java.util.List;

import com.small.business.model.assignment.Assignment;

public interface AssignmentService {

    public List<Assignment> getAllAssignment();

    public Assignment getAssignmentById(Long id);

    public boolean addAssignment(Assignment assignment);

    public boolean deleteAssignmentById(Long id);

    public Long getNextAssignmentId();

    public boolean deleteAll();

    public boolean updateAssignment(Assignment assignment);

}
