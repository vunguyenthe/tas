package com.small.business.service.assignment;

import java.util.List;

import com.small.business.model.assignment.AssignmentNotepad;

public interface AssignmentNotepadService {

    public List<AssignmentNotepad> getAllAssignmentNotepad();

    public AssignmentNotepad getAssignmentNotepadById(Long id);

    public boolean addAssignmentNotepad(AssignmentNotepad companyJournal);

    public boolean deleteAssignmentNotepadById(Long id);

    public boolean deleteAll();

    public boolean updateAssignmentNotepad(AssignmentNotepad companyJournal);

    public boolean addListAssignmentNotepad(List<AssignmentNotepad> listAssignmentNotepad);

    public boolean updateListAssignmentNotepad(List<AssignmentNotepad> listAssignmentNotepad);

    public List<AssignmentNotepad> getListAssignmentNotepadByAssignmentId(Long assignmentId);
}
