package com.small.business.dao.assignment;

import java.util.List;

import com.small.business.model.assignment.AssignmentTag;

public interface AssignmentTagDao {

    public List<AssignmentTag> getAllAssignmentTag();

    public AssignmentTag getAssignmentTagById(Long id);

    public boolean addListAssignmentTag(List<AssignmentTag> listAssignmentTag);

    public AssignmentTag getAssignmentTagByAssignmentId(Long assignmentId);

    public boolean updateListAssignmentTag(List<AssignmentTag> listAssignmentTag);

    public boolean addAssignmentTag(AssignmentTag assignmentTag);

    public boolean deleteAssignmentTagById(Long id);

    public boolean deleteAll();

    public boolean updateAssignmentTag(AssignmentTag assignmentTag);
}
