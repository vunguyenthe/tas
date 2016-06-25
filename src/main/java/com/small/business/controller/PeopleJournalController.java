package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.people.PeopleJournal;
import com.small.business.service.people.PeopleJournalService;

@Controller
@RequestMapping("/api")
public class PeopleJournalController {

    @Autowired
    private PeopleJournalService peopleJournalService;

    @RequestMapping(value = "/peopleJournal/{id}", method = RequestMethod.GET)
    public @ResponseBody PeopleJournal getPeopleJournal(@PathVariable long id) {

        return peopleJournalService.getPeopleJournalById(id);
    }

    @RequestMapping(value = "/listJournal/{peopleId}", method = RequestMethod.GET)
    public @ResponseBody List<PeopleJournal> getListJournalByPeopleId(@PathVariable long peopleId) {

        return peopleJournalService.getPeopleJournalByPeopleId(peopleId);
    }

    @RequestMapping(value = "/peopleJournal", method = RequestMethod.GET)
    public @ResponseBody List<PeopleJournal> getPeopleJournalList() {

        return peopleJournalService.getAllPeopleJournal();
    }

    @RequestMapping(value = "/peopleJournal", method = RequestMethod.POST)
    public @ResponseBody boolean addPeopleJournal(@RequestBody PeopleJournal PeopleJournal) {

        return peopleJournalService.addPeopleJournal(PeopleJournal);
    }

    @RequestMapping(value = "/peopleJournal", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePeopleJournal(@RequestBody PeopleJournal PeopleJournal) {

        return peopleJournalService.updatePeopleJournal(PeopleJournal);
    }

    @RequestMapping(value = "/peopleJournal/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removePeopleJournal(@PathVariable("id") Long id) {

        return peopleJournalService.deletePeopleJournalById(id);
    }

    @RequestMapping(value = "/removeAllPeopleJournal", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllPeopleJournal() {

        return peopleJournalService.deleteAll();
    }
}
