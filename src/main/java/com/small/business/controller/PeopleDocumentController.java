package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.people.PeopleDocument;
import com.small.business.service.people.PeopleDocumentService;

@Controller
@RequestMapping("/api")
public class PeopleDocumentController {

    @Autowired
    private PeopleDocumentService peopleDocumentService;

    @RequestMapping(value = "/peopleDocument/{id}", method = RequestMethod.GET)
    public @ResponseBody PeopleDocument getPeopleDocument(@PathVariable long id) {

        return peopleDocumentService.getPeopleDocumentById(id);
    }

    @RequestMapping(value = "/peopleDocument", method = RequestMethod.GET)
    public @ResponseBody List<PeopleDocument> getPeopleDocumentList() {

        return peopleDocumentService.getAllPeopleDocument();
    }

    @RequestMapping(value = "/peopleDocument", method = RequestMethod.POST)
    public @ResponseBody boolean addPeopleDocument(@RequestBody PeopleDocument PeopleDocument) {

        return peopleDocumentService.addPeopleDocument(PeopleDocument);
    }

    @RequestMapping(value = "/peopleDocument", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePeopleDocument(@RequestBody PeopleDocument PeopleDocument) {

        return peopleDocumentService.updatePeopleDocument(PeopleDocument);
    }

    @RequestMapping(value = "/peopleDocument/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removePeopleDocument(@PathVariable("id") Long id) {

        return peopleDocumentService.deletePeopleDocumentById(id);
    }

    @RequestMapping(value = "/removeAllPeopleDocument", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllPeopleDocument() {

        return peopleDocumentService.deleteAll();
    }
}
