package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.people.Nationality;
import com.small.business.service.people.NationalityService;

@Controller
@RequestMapping("/api")
public class NationalityController {

    @Autowired
    private NationalityService nationalityService;

    @RequestMapping(value = "/nationality/{id}", method = RequestMethod.GET)
    public @ResponseBody Nationality getNationality(@PathVariable long id) {

        return nationalityService.getNationalityById(id);
    }

    @RequestMapping(value = "/nationality", method = RequestMethod.GET)
    public @ResponseBody List<Nationality> getNationalityList() {

        return nationalityService.getAllNationality();
    }

    @RequestMapping(value = "/nationality", method = RequestMethod.POST)
    public @ResponseBody boolean addNationality(@RequestBody Nationality nationality) {

        return nationalityService.addNationality(nationality);
    }

    @RequestMapping(value = "/nationality", method = RequestMethod.PUT)
    public @ResponseBody boolean updateNationality(@RequestBody Nationality nationality) {

        return nationalityService.updateNationality(nationality);
    }

    @RequestMapping(value = "/nationality/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeNationality(@PathVariable("id") Long id) {

        return nationalityService.deleteNationalityById(id);
    }

    @RequestMapping(value = "/removeAllNationality", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllNationality() {

        return nationalityService.deleteAll();
    }
}
