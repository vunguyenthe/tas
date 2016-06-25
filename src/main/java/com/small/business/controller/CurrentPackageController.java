package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.people.CurrentPackage;
import com.small.business.service.people.CurrentPackageService;

@Controller
@RequestMapping("/api")
public class CurrentPackageController {

    @Autowired
    private CurrentPackageService currentPackageService;

    @RequestMapping(value = "/currentPackage/{id}", method = RequestMethod.GET)
    public @ResponseBody CurrentPackage getCurrentPackage(@PathVariable long id) {

        return currentPackageService.getCurrentPackageById(id);
    }

    @RequestMapping(value = "/currentPackage", method = RequestMethod.GET)
    public @ResponseBody List<CurrentPackage> getCurrentPackageList() {

        return currentPackageService.getAllCurrentPackage();
    }

    @RequestMapping(value = "/currentPackage", method = RequestMethod.POST)
    public @ResponseBody boolean addCurrentPackage(@RequestBody CurrentPackage CurrentPackage) {

        return currentPackageService.addCurrentPackage(CurrentPackage);
    }

    @RequestMapping(value = "/currentPackage", method = RequestMethod.PUT)
    public @ResponseBody boolean updateCurrentPackage(@RequestBody CurrentPackage CurrentPackage) {

        return currentPackageService.updateCurrentPackage(CurrentPackage);
    }

    @RequestMapping(value = "/currentPackage/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeCurrentPackage(@PathVariable("id") Long id) {

        return currentPackageService.deleteCurrentPackageById(id);
    }

    @RequestMapping(value = "/removeAllCurrentPackage", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllCurrentPackage() {

        return currentPackageService.deleteAll();
    }
}
