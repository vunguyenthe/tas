package com.small.business.service.assignment;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.assignment.AssignmentNotepadDao;
import com.small.business.model.assignment.AssignmentNotepad;

@Service("AssignmentNotepadService")
public class AssignmentNotepadServiceImpl implements AssignmentNotepadService {

    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentNotepadServiceImpl.class);
    private static List<AssignmentNotepad> assignmentNotepadList = new ArrayList<AssignmentNotepad>();
    private static Long id = 0L;

    @Autowired
    AssignmentNotepadDao assignmentNotepadDao;

    public List<AssignmentNotepad> getAllAssignmentNotepad() {

        List<AssignmentNotepad> assignmentNotepadList = assignmentNotepadDao.getAllAssignmentNotepad();
        return assignmentNotepadList;
    }

    public AssignmentNotepad getAssignmentNotepadById(Long id) {

        return assignmentNotepadDao.getAssignmentNotepadById(id);
    }

    public boolean addAssignmentNotepad(AssignmentNotepad peopleJournal) {

        peopleJournal.setId(++id);
        return assignmentNotepadDao.addAssignmentNotepad(peopleJournal);
    }

    public boolean deleteAssignmentNotepadById(Long id) {

        boolean ret = false;
        ret = assignmentNotepadDao.deleteAssignmentNotepadById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        assignmentNotepadList.clear();
        id = 0L;
        return assignmentNotepadDao.deleteAll();
    }

    public boolean updateAssignmentNotepad(AssignmentNotepad assignmentNotepad) {

        AssignmentNotepad foundAssignmentNotepad = getAssignmentNotepadById(assignmentNotepad.getId());
        if (foundAssignmentNotepad != null) {
            assignmentNotepadList.remove(foundAssignmentNotepad);
            assignmentNotepadList.add(assignmentNotepad);
        }
        return assignmentNotepadDao.updateAssignmentNotepad(assignmentNotepad);

    }

    public List<AssignmentNotepad> getListAssignmentNotepadByAssignmentId(Long assignmentId) {

        return assignmentNotepadDao.getListAssignmentNotepadByAssignmentId(assignmentId);
    }

    public boolean addListAssignmentNotepad(List<AssignmentNotepad> listAssignmentNotepad) {

        return assignmentNotepadDao.addListAssignmentNotepad(listAssignmentNotepad);
    }

    public boolean updateListAssignmentNotepad(List<AssignmentNotepad> listAssignmentNotepad) {

        return assignmentNotepadDao.updateListAssignmentNotepad(listAssignmentNotepad);
    }
}
