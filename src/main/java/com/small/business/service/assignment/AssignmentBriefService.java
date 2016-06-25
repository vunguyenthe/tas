package com.small.business.service.assignment;

import java.util.List;

import com.small.business.model.assignment.AssignmentBrief;

public interface AssignmentBriefService {

    public List<AssignmentBrief> getAllAssignmentBrief();

    public AssignmentBrief getAssignmentBriefById(Long id);

    public boolean addAssignmentBrief(AssignmentBrief companyJournal);

    public boolean deleteAssignmentBriefById(Long id);

    public boolean deleteAll();

    public boolean updateAssignmentBrief(AssignmentBrief companyJournal);

    public boolean addListAssignmentBrief(List<AssignmentBrief> listAssignmentBrief);

    public boolean updateListAssignmentBrief(List<AssignmentBrief> listAssignmentBrief);

    public List<AssignmentBrief> getListAssignmentBriefByAssignmentId(Long assignmentId);
}
