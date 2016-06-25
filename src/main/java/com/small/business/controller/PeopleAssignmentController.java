package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.people.PeopleAssignment;
import com.small.business.service.people.PeopleAssignmentService;

@Controller
@RequestMapping("/api")
public class PeopleAssignmentController {

    @Autowired
    private PeopleAssignmentService peopleAssignmentService;

    @RequestMapping(value = "/peopleAssignment/{id}", method = RequestMethod.GET)
    public @ResponseBody PeopleAssignment getPeopleAssignment(@PathVariable long id) {

        return peopleAssignmentService.getPeopleAssignmentById(id);
    }

    @RequestMapping(value = "/peopleAssignment", method = RequestMethod.GET)
    public @ResponseBody List<PeopleAssignment> getPeopleAssignmentList() {

        return peopleAssignmentService.getAllPeopleAssignment();
    }

    @RequestMapping(value = "/peopleAssignment", method = RequestMethod.POST)
    public @ResponseBody boolean addPeopleAssignment(@RequestBody PeopleAssignment PeopleAssignment) {

        return peopleAssignmentService.addPeopleAssignment(PeopleAssignment);
    }

    @RequestMapping(value = "/peopleAssignment", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePeopleAssignment(@RequestBody PeopleAssignment PeopleAssignment) {

        return peopleAssignmentService.updatePeopleAssignment(PeopleAssignment);
    }

    @RequestMapping(value = "/peopleAssignment/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removePeopleAssignment(@PathVariable("id") Long id) {

        return peopleAssignmentService.deletePeopleAssignmentById(id);
    }

    @RequestMapping(value = "/removeAllPeopleAssignment", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllPeopleAssignment() {

        return peopleAssignmentService.deleteAll();
    }
}
