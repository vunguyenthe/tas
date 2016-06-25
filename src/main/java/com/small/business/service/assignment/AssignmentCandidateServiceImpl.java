package com.small.business.service.assignment;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.assignment.AssignmentCandidateDao;
import com.small.business.model.assignment.AssignmentCandidate;

@Service("AssignmentCandidateService")
public class AssignmentCandidateServiceImpl implements AssignmentCandidateService {

    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentCandidateServiceImpl.class);
    private static List<AssignmentCandidate> assignmentCandidateList = new ArrayList<AssignmentCandidate>();
    private static Long id = 0L;

    @Autowired
    AssignmentCandidateDao assignmentCandidateDao;

    public List<AssignmentCandidate> getAllAssignmentCandidate() {

        List<AssignmentCandidate> assignmentCandidateList = assignmentCandidateDao.getAllAssignmentCandidate();
        return assignmentCandidateList;
    }

    public AssignmentCandidate getAssignmentCandidateById(Long id) {

        return assignmentCandidateDao.getAssignmentCandidateById(id);
    }

    public boolean addAssignmentCandidate(AssignmentCandidate peopleJournal) {

        peopleJournal.setId(++id);
        return assignmentCandidateDao.addAssignmentCandidate(peopleJournal);
    }

    public boolean deleteAssignmentCandidateById(Long id) {

        boolean ret = false;
        ret = assignmentCandidateDao.deleteAssignmentCandidateById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        assignmentCandidateList.clear();
        id = 0L;
        return assignmentCandidateDao.deleteAll();
    }

    public boolean updateAssignmentCandidate(AssignmentCandidate assignmentCandidate) {

        AssignmentCandidate foundAssignmentCandidate = getAssignmentCandidateById(assignmentCandidate.getId());
        if (foundAssignmentCandidate != null) {
            assignmentCandidateList.remove(foundAssignmentCandidate);
            assignmentCandidateList.add(assignmentCandidate);
        }
        return assignmentCandidateDao.updateAssignmentCandidate(assignmentCandidate);

    }

    public List<AssignmentCandidate> getListAssignmentCandidateByAssignmentId(Long assignmentId) {

        return assignmentCandidateDao.getListAssignmentCandidateByAssignmentId(assignmentId);
    }

    public boolean addListAssignmentCandidate(List<AssignmentCandidate> listAssignmentCandidate) {

        return assignmentCandidateDao.addListAssignmentCandidate(listAssignmentCandidate);
    }

    public boolean updateListAssignmentCandidate(List<AssignmentCandidate> listAssignmentCandidate) {

        return assignmentCandidateDao.updateListAssignmentCandidate(listAssignmentCandidate);
    }
}
