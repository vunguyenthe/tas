package com.small.business.dao.assignment;

import java.util.List;

import com.small.business.model.assignment.AssignmentCandidate;

public interface AssignmentCandidateDao {

    public List<AssignmentCandidate> getAllAssignmentCandidate();

    public AssignmentCandidate getAssignmentCandidateById(Long id);

    public boolean addAssignmentCandidate(AssignmentCandidate companyPeople);

    public boolean deleteAssignmentCandidateById(Long id);

    public boolean deleteAll();

    public boolean updateAssignmentCandidate(AssignmentCandidate companyPeople);

    public boolean addListAssignmentCandidate(List<AssignmentCandidate> listAssignmentCandidate);

    public boolean updateListAssignmentCandidate(List<AssignmentCandidate> listAssignmentCandidate);

    public List<AssignmentCandidate> getListAssignmentCandidateByAssignmentId(Long assignmentId);
}
