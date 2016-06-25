package com.small.business.dao.assignment;

import java.util.List;

import com.small.business.model.assignment.AssignmentNotepad;

public interface AssignmentNotepadDao {

    public List<AssignmentNotepad> getAllAssignmentNotepad();

    public AssignmentNotepad getAssignmentNotepadById(Long id);

    public boolean addAssignmentNotepad(AssignmentNotepad companyPeople);

    public boolean deleteAssignmentNotepadById(Long id);

    public boolean deleteAll();

    public boolean updateAssignmentNotepad(AssignmentNotepad companyPeople);

    public boolean addListAssignmentNotepad(List<AssignmentNotepad> listAssignmentNotepad);

    public boolean updateListAssignmentNotepad(List<AssignmentNotepad> listAssignmentNotepad);

    public List<AssignmentNotepad> getListAssignmentNotepadByAssignmentId(Long assignmentId);
}
