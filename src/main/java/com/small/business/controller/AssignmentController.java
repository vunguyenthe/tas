package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.assignment.Assignment;
import com.small.business.model.assignment.AssignmentBrief;
import com.small.business.model.assignment.AssignmentCandidate;
import com.small.business.model.assignment.AssignmentNotepad;
import com.small.business.model.assignment.AssignmentTag;
import com.small.business.service.assignment.AssignmentBriefService;
import com.small.business.service.assignment.AssignmentCandidateService;
import com.small.business.service.assignment.AssignmentNotepadService;
import com.small.business.service.assignment.AssignmentService;
import com.small.business.service.assignment.AssignmentTagService;

@Controller
@RequestMapping("/api")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private AssignmentBriefService assignmentBriefService;

    @Autowired
    private AssignmentCandidateService assignmentCandidateService;

    @Autowired
    private AssignmentNotepadService assignmentNotepadService;

    @Autowired
    private AssignmentTagService assignmentTagService;

    @RequestMapping(value = "/assignment/{assignmentId}", method = RequestMethod.GET)
    public @ResponseBody Assignment getCompany(@PathVariable long assignmentId) {

        Assignment assignment = assignmentService.getAssignmentById(assignmentId);
        if (assignment.getId() > 0) {
            List<AssignmentBrief> listAssignmentBrief = assignmentBriefService.getListAssignmentBriefByAssignmentId(assignmentId);
            List<AssignmentNotepad> listAssignmentNotepad = assignmentNotepadService.getListAssignmentNotepadByAssignmentId(assignmentId);
            List<AssignmentCandidate> listAssignmentCandidate = assignmentCandidateService.getListAssignmentCandidateByAssignmentId(assignmentId);
            AssignmentTag assignmentTag = assignmentTagService.getAssignmentTagByAssignmentId(assignmentId);
            assignment.setBriefs(listAssignmentBrief);
            assignment.setNotepads(listAssignmentNotepad);
            assignment.setCandidates(listAssignmentCandidate);
            assignment.setAssignmentTag(assignmentTag);
        }
        return assignment;
    }

    @RequestMapping(value = "/assignment", method = RequestMethod.GET)
    public @ResponseBody List<Assignment> getAssignmentList() {

        return assignmentService.getAllAssignment();
    }

    @RequestMapping(value = "/assignment", method = RequestMethod.POST)
    public @ResponseBody boolean addAssignment(@RequestBody Assignment assignment) {

        boolean ret = true;
        ret = assignmentService.addAssignment(assignment);
        if (ret) {
            Long assignmentId = assignmentService.getNextAssignmentId();
            List<AssignmentBrief> listAssignmentBrief = assignment.getBriefs();
            if (listAssignmentBrief.size() > 0) {
                for (AssignmentBrief obj : listAssignmentBrief) {
                    if (obj.getId() == 0L || obj.getAssignmentId() != assignmentId) {
                        obj.setAssignmentId(assignmentId);
                    }
                }
                ret &= assignmentBriefService.addListAssignmentBrief(listAssignmentBrief);
            }

            List<AssignmentCandidate> listAssignmentCandidate = assignment.getCandidates();
            if (listAssignmentCandidate.size() > 0) {
                for (AssignmentCandidate obj : listAssignmentCandidate) {
                    if (obj.getId() == 0L || obj.getAssignmentId() != assignmentId) {
                        obj.setAssignmentId(assignmentId);
                    }
                }
                ret &= assignmentCandidateService.addListAssignmentCandidate(listAssignmentCandidate);
            }

            List<AssignmentNotepad> listAssignmentNotepad = assignment.getNotepads();
            if (listAssignmentCandidate.size() > 0) {
                for (AssignmentNotepad obj : listAssignmentNotepad) {
                    if (obj.getId() == 0L || obj.getAssignmentId() != assignmentId) {
                        obj.setAssignmentId(assignmentId);
                    }
                }
                ret &= assignmentNotepadService.addListAssignmentNotepad(listAssignmentNotepad);
            }
            AssignmentTag assignmentTag = assignment.getAssignmentTag();

            if (assignmentTag.getId() == 0L || assignmentTag.getAssignmentId() != assignmentId) {
                assignmentTag.setAssignmentId(assignmentId);
                assignmentTagService.addAssignmentTag(assignmentTag);
            }
        }

        return ret;
    }

    @RequestMapping(value = "/assignment", method = RequestMethod.PUT)
    public @ResponseBody boolean updateAssignment(@RequestBody Assignment assignment) {

        boolean ret = true;
        Long assignmentId = assignment.getId();
        if (assignmentId > 0) {
            List<AssignmentBrief> listAssignmentBrief = assignment.getBriefs();
            if (listAssignmentBrief.size() > 0) {
                for (AssignmentBrief obj : listAssignmentBrief) {
                    if (obj.getId() == 0L) {
                        obj.setAssignmentId(assignmentId);
                        ret &= assignmentBriefService.addAssignmentBrief(obj);
                    } else {
                        ret &= assignmentBriefService.updateAssignmentBrief(obj);
                    }
                }
            }
            List<AssignmentCandidate> listAssignmentCandidate = assignment.getCandidates();
            if (listAssignmentCandidate.size() > 0) {
                for (AssignmentCandidate obj : listAssignmentCandidate) {
                    if (obj.getId() == 0L) {
                        obj.setAssignmentId(assignmentId);
                        ret &= assignmentCandidateService.addAssignmentCandidate(obj);
                    } else {
                        ret &= assignmentCandidateService.updateAssignmentCandidate(obj);
                    }
                }
            }
            List<AssignmentNotepad> listAssignmentNotepad = assignment.getNotepads();
            if (listAssignmentCandidate.size() > 0) {
                for (AssignmentNotepad obj : listAssignmentNotepad) {
                    if (obj.getId() == 0L) {
                        obj.setAssignmentId(assignmentId);
                        ret &= assignmentNotepadService.addAssignmentNotepad(obj);
                    } else {
                        ret &= assignmentNotepadService.updateAssignmentNotepad(obj);
                    }
                }
            }
            AssignmentTag assignmentTag = assignment.getAssignmentTag();
            ret &= assignmentTagService.updateAssignmentTag(assignmentTag);
        }
        ret &= assignmentService.updateAssignment(assignment);
        return ret;
    }

    @RequestMapping(value = "/assignment/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAssignment(@PathVariable("id") Long id) {

        return assignmentService.deleteAssignmentById(id);
    }

    @RequestMapping(value = "/removeAllAssignment", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllAssignment() {

        return assignmentService.deleteAll();
    }

}
