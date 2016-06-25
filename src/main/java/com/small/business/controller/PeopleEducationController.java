package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.people.PeopleEducation;
import com.small.business.service.people.PeopleEducationService;

@Controller
@RequestMapping("/api")
public class PeopleEducationController {

    @Autowired
    private PeopleEducationService peopleEducationService;

    @RequestMapping(value = "/peopleEducation/{id}", method = RequestMethod.GET)
    public @ResponseBody PeopleEducation getPeopleEducation(@PathVariable long id) {

        return peopleEducationService.getPeopleEducationById(id);
    }

    @RequestMapping(value = "/peopleEducation", method = RequestMethod.GET)
    public @ResponseBody List<PeopleEducation> getPeopleEducationList() {

        return peopleEducationService.getAllPeopleEducation();
    }

    @RequestMapping(value = "/peopleEducation", method = RequestMethod.POST)
    public @ResponseBody boolean addPeopleEducation(@RequestBody PeopleEducation PeopleEducation) {

        return peopleEducationService.addPeopleEducation(PeopleEducation);
    }

    @RequestMapping(value = "/peopleEducation", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePeopleEducation(@RequestBody PeopleEducation PeopleEducation) {

        return peopleEducationService.updatePeopleEducation(PeopleEducation);
    }

    @RequestMapping(value = "/peopleEducation/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removePeopleEducation(@PathVariable("id") Long id) {

        return peopleEducationService.deletePeopleEducationById(id);
    }

    @RequestMapping(value = "/removeAllPeopleEducation", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllPeopleEducation() {

        return peopleEducationService.deleteAll();
    }
}
