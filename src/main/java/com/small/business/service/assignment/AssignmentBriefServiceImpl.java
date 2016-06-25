package com.small.business.service.assignment;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.assignment.AssignmentBriefDao;
import com.small.business.model.assignment.AssignmentBrief;

@Service("AssignmentBriefService")
public class AssignmentBriefServiceImpl implements AssignmentBriefService {

    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentBriefServiceImpl.class);
    private static List<AssignmentBrief> assignmentBriefList = new ArrayList<AssignmentBrief>();
    private static Long id = 0L;

    @Autowired
    AssignmentBriefDao assignmentBriefDao;

    public List<AssignmentBrief> getAllAssignmentBrief() {

        List<AssignmentBrief> assignmentBriefList = assignmentBriefDao.getAllAssignmentBrief();
        return assignmentBriefList;
    }

    public AssignmentBrief getAssignmentBriefById(Long id) {

        return assignmentBriefDao.getAssignmentBriefById(id);
    }

    public boolean addAssignmentBrief(AssignmentBrief peopleJournal) {

        peopleJournal.setId(++id);
        return assignmentBriefDao.addAssignmentBrief(peopleJournal);
    }

    public boolean deleteAssignmentBriefById(Long id) {

        boolean ret = false;
        ret = assignmentBriefDao.deleteAssignmentBriefById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        assignmentBriefList.clear();
        id = 0L;
        return assignmentBriefDao.deleteAll();
    }

    public boolean updateAssignmentBrief(AssignmentBrief assignmentBrief) {

        AssignmentBrief foundAssignmentBrief = getAssignmentBriefById(assignmentBrief.getId());
        if (foundAssignmentBrief != null) {
            assignmentBriefList.remove(foundAssignmentBrief);
            assignmentBriefList.add(assignmentBrief);
        }
        return assignmentBriefDao.updateAssignmentBrief(assignmentBrief);

    }

    public List<AssignmentBrief> getListAssignmentBriefByAssignmentId(Long assignmentId) {

        return assignmentBriefDao.getListAssignmentBriefByAssignmentId(assignmentId);
    }

    public boolean addListAssignmentBrief(List<AssignmentBrief> listAssignmentBrief) {

        return assignmentBriefDao.addListAssignmentBrief(listAssignmentBrief);
    }

    public boolean updateListAssignmentBrief(List<AssignmentBrief> listAssignmentBrief) {

        return assignmentBriefDao.updateListAssignmentBrief(listAssignmentBrief);
    }
}
