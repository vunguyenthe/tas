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
import com.small.business.model.people.CurrentPackage;
import com.small.business.model.people.PeopleDetail;
import com.small.business.service.people.CurrentBenefitService;
import com.small.business.service.people.CurrentPackageService;
import com.small.business.service.people.PeopleDetailService;

@Controller
@RequestMapping("/api")
public class PeopleDetailController {

    @Autowired
    private PeopleDetailService peopleDetailService;

    @Autowired
    private CurrentPackageService currentPackageService;

    @Autowired
    private CurrentBenefitService currentBenefitService;

    @RequestMapping(value = "/peopleDetail/{id}", method = RequestMethod.GET)
    public @ResponseBody PeopleDetail getPeopleDetail(@PathVariable long id) {

        PeopleDetail peopleDetail = peopleDetailService.getPeopleDetailById(id);
        Long peopleId = peopleDetail.getPeopleId();
        if (peopleId > 0) {
            List<CurrentPackage> listCurrentPackage = currentPackageService.getAllCurrentPackage();
            List<CurrentBenefit> listCurrentBenefit = currentBenefitService.getAllCurrentBenefit();
            peopleDetail.setCurrentBenefit(listCurrentBenefit);
            peopleDetail.setCurrentPackage(listCurrentPackage);

        }
        return peopleDetail;
    }

    @RequestMapping(value = "/peopleDetailByPeopleId/{peopleId}", method = RequestMethod.GET)
    public @ResponseBody PeopleDetail getPeopleDetailByPeopleId(@PathVariable long peopleId) {

        return peopleDetailService.getPeopleDetailByPeopleId(peopleId);
    }

    @RequestMapping(value = "/peopleDetail", method = RequestMethod.GET)
    public @ResponseBody List<PeopleDetail> getPeopleDetailList() {

        return peopleDetailService.getAllPeopleDetail();
    }

    @RequestMapping(value = "/peopleDetail/{peopleId}", method = RequestMethod.POST)
    public @ResponseBody boolean addPeopleDetail(@RequestBody PeopleDetail peopleDetail) {

        boolean ret = peopleDetailService.addPeopleDetail(peopleDetail);
        Long peopleId = peopleDetail.getPeopleId();
        if (ret) {
            List<CurrentPackage> listCurrentPackage = peopleDetail.getCurrentPackage();
            if (listCurrentPackage.size() > 0) {
                for (CurrentPackage obj : listCurrentPackage) {
                    if (obj.getId() == 0L || obj.getPeopleId() != peopleId) {
                        if (obj.getPackageName() != null)
                            obj.setPeopleId(peopleId);
                    }
                }
                ret = currentPackageService.addListCurrentPackage(listCurrentPackage);
            }
            List<CurrentBenefit> listCurrentBenefit = peopleDetail.getCurrentBenefit();
            if (listCurrentBenefit.size() > 0) {
                for (CurrentBenefit obj : listCurrentBenefit) {
                    if (obj.getId() == 0L || obj.getPeopleId() != peopleId) {
                        if (obj.getBenefit() != null)
                            obj.setPeopleId(peopleId);
                    }
                }
                ret &= currentBenefitService.addListCurrentBenefit(listCurrentBenefit);
            }
        }
        return ret;
    }

    @RequestMapping(value = "/peopleDetail/{peopleId}", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePeopleDetail(@RequestBody PeopleDetail peopleDetail) {

        boolean ret = false;
        Long peopleId = peopleDetail.getPeopleId();
        if (peopleId > 0) {
            List<CurrentPackage> listCurrentPackage = peopleDetail.getCurrentPackage();
            if (listCurrentPackage.size() > 0) {
                for (CurrentPackage obj : listCurrentPackage) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                        ret &= currentPackageService.addCurrentPackage(obj);

                    } else {
                        ret &= currentPackageService.updateCurrentPackage(obj);
                    }

                }

            }
            List<CurrentBenefit> listCurrentBenefit = peopleDetail.getCurrentBenefit();
            if (listCurrentPackage.size() > 0) {
                for (CurrentBenefit obj : listCurrentBenefit) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                        ret &= currentBenefitService.addCurrentBenefit(obj);

                    } else {
                        ret &= currentBenefitService.updateCurrentBenefit(obj);
                    }

                }

            }
            ret &= peopleDetailService.updatePeopleDetail(peopleDetail);
        }
        return ret;

    }

    @RequestMapping(value = "/peopleDetail/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removePeopleDetail(@PathVariable("id") Long id) {

        return peopleDetailService.deletePeopleDetailById(id);
    }

    @RequestMapping(value = "/removeAllPeopleDetail", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllPeopleDetail() {

        return peopleDetailService.deleteAll();
    }
}
