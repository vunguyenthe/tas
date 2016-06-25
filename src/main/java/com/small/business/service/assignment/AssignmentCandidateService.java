package com.small.business.service.assignment;

import java.util.List;

import com.small.business.model.assignment.AssignmentCandidate;

public interface AssignmentCandidateService {

    public List<AssignmentCandidate> getAllAssignmentCandidate();

    public AssignmentCandidate getAssignmentCandidateById(Long id);

    public boolean addAssignmentCandidate(AssignmentCandidate companyJournal);

    public boolean deleteAssignmentCandidateById(Long id);

    public boolean deleteAll();

    public boolean updateAssignmentCandidate(AssignmentCandidate companyJournal);

    public boolean addListAssignmentCandidate(List<AssignmentCandidate> listAssignmentCandidate);

    public boolean updateListAssignmentCandidate(List<AssignmentCandidate> listAssignmentCandidate);

    public List<AssignmentCandidate> getListAssignmentCandidateByAssignmentId(Long assignmentId);
}
