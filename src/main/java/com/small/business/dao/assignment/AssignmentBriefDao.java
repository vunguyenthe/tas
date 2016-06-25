package com.small.business.dao.assignment;

import java.util.List;

import com.small.business.model.assignment.AssignmentBrief;

public interface AssignmentBriefDao {

    public List<AssignmentBrief> getAllAssignmentBrief();

    public AssignmentBrief getAssignmentBriefById(Long id);

    public boolean addAssignmentBrief(AssignmentBrief companyPeople);

    public boolean deleteAssignmentBriefById(Long id);

    public boolean deleteAll();

    public boolean updateAssignmentBrief(AssignmentBrief companyPeople);

    public boolean addListAssignmentBrief(List<AssignmentBrief> listAssignmentBrief);

    public boolean updateListAssignmentBrief(List<AssignmentBrief> listAssignmentBrief);

    public List<AssignmentBrief> getListAssignmentBriefByAssignmentId(Long assignmentId);
}
