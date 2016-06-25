package com.small.business.service.assignment;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.assignment.AssignmentTagDao;
import com.small.business.model.assignment.AssignmentTag;

@Service("AssignmentTagService")
public class AssignmentTagServiceImpl implements AssignmentTagService {

    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentTagServiceImpl.class);
    private static List<AssignmentTag> assignmentTagList = new ArrayList<AssignmentTag>();
    private static Long id = 0L;

    @Autowired
    AssignmentTagDao assignmentTagDao;

    public List<AssignmentTag> getAllAssignmentTag() {

        List<AssignmentTag> assignmentTagList = assignmentTagDao.getAllAssignmentTag();
        return assignmentTagList;
    }

    public AssignmentTag getAssignmentTagByAssignmentId(Long assignmentId) {

        return assignmentTagDao.getAssignmentTagByAssignmentId(assignmentId);
    }

    public AssignmentTag getAssignmentTagById(Long id) {

        return assignmentTagDao.getAssignmentTagById(id);
    }

    public boolean addAssignmentTag(AssignmentTag assignmentJournal) {

        assignmentJournal.setId(++id);
        return assignmentTagDao.addAssignmentTag(assignmentJournal);
    }

    public boolean deleteAssignmentTagById(Long id) {

        boolean ret = false;
        ret = assignmentTagDao.deleteAssignmentTagById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        assignmentTagList.clear();
        id = 0L;
        return assignmentTagDao.deleteAll();
    }

    public boolean updateListAssignmentTag(List<AssignmentTag> listAssignmentTag) {

        return assignmentTagDao.updateListAssignmentTag(listAssignmentTag);
    }

    public boolean addListAssignmentTag(List<AssignmentTag> listAssignmentTag) {

        return assignmentTagDao.addListAssignmentTag(listAssignmentTag);
    }

    public boolean updateAssignmentTag(AssignmentTag assignmentHistory) {

        AssignmentTag foundAssignmentTag = getAssignmentTagById(assignmentHistory.getId());
        if (foundAssignmentTag != null) {
            assignmentTagList.remove(foundAssignmentTag);
            assignmentTagList.add(assignmentHistory);
        }
        return assignmentTagDao.updateAssignmentTag(assignmentHistory);

    }

}
