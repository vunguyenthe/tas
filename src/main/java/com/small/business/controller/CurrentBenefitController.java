package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.people.CurrentBenefit;
import com.small.business.service.people.CurrentBenefitService;

@Controller
@RequestMapping("/api")
public class CurrentBenefitController {

    @Autowired
    private CurrentBenefitService currentBenefitService;

    @RequestMapping(value = "/currentBenefit/{id}", method = RequestMethod.GET)
    public @ResponseBody CurrentBenefit getCurrentBenefit(@PathVariable long id) {

        return currentBenefitService.getCurrentBenefitById(id);
    }

    @RequestMapping(value = "/currentBenefit", method = RequestMethod.GET)
    public @ResponseBody List<CurrentBenefit> getCurrentBenefitList() {

        return currentBenefitService.getAllCurrentBenefit();
    }

    @RequestMapping(value = "/currentBenefit", method = RequestMethod.POST)
    public @ResponseBody boolean addCurrentBenefit(@RequestBody CurrentBenefit CurrentBenefit) {

        return currentBenefitService.addCurrentBenefit(CurrentBenefit);
    }

    @RequestMapping(value = "/currentBenefit", method = RequestMethod.PUT)
    public @ResponseBody boolean updateCurrentBenefit(@RequestBody CurrentBenefit CurrentBenefit) {

        return currentBenefitService.updateCurrentBenefit(CurrentBenefit);
    }

    @RequestMapping(value = "/currentBenefit/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeCurrentBenefit(@PathVariable("id") Long id) {

        return currentBenefitService.deleteCurrentBenefitById(id);
    }

    @RequestMapping(value = "/removeAllCurrentBenefit", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllCurrentBenefit() {

        return currentBenefitService.deleteAll();
    }
}
