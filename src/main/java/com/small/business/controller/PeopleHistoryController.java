package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.people.PeopleHistory;
import com.small.business.service.people.PeopleHistoryService;

@Controller
@RequestMapping("/api")
public class PeopleHistoryController {

    @Autowired
    private PeopleHistoryService peopleHistoryService;

    @RequestMapping(value = "/peopleHistory/{id}", method = RequestMethod.GET)
    public @ResponseBody PeopleHistory getPeopleHistory(@PathVariable long id) {

        return peopleHistoryService.getPeopleHistoryById(id);
    }

    @RequestMapping(value = "/peopleHistory", method = RequestMethod.GET)
    public @ResponseBody List<PeopleHistory> getPeopleHistoryList() {

        return peopleHistoryService.getAllPeopleHistory();
    }

    @RequestMapping(value = "/peopleHistory", method = RequestMethod.POST)
    public @ResponseBody boolean addPeopleHistory(@RequestBody PeopleHistory PeopleHistory) {

        return peopleHistoryService.addPeopleHistory(PeopleHistory);
    }

    @RequestMapping(value = "/peopleHistory", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePeopleHistory(@RequestBody PeopleHistory PeopleHistory) {

        return peopleHistoryService.updatePeopleHistory(PeopleHistory);
    }

    @RequestMapping(value = "/peopleHistory/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removePeopleHistory(@PathVariable("id") Long id) {

        return peopleHistoryService.deletePeopleHistoryById(id);
    }

    @RequestMapping(value = "/removeAllPeopleHistory", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllPeopleHistory() {

        return peopleHistoryService.deleteAll();
    }
}
