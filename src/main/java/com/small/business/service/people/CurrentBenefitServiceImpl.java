package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.CurrentBenefitDao;
import com.small.business.model.people.CurrentBenefit;

@Service("CurrentBenefitService")
public class CurrentBenefitServiceImpl implements CurrentBenefitService {

    private static final Logger logger = LoggerFactory
            .getLogger(CurrentBenefitServiceImpl.class);
    private static List<CurrentBenefit> currentBenefitList = new ArrayList<CurrentBenefit>();
    private static Long id = 0L;

    @Autowired
    CurrentBenefitDao currentBenefitDao;

    public List<CurrentBenefit> getAllCurrentBenefit() {

        List<CurrentBenefit> currentBenefitList = currentBenefitDao.getAllCurrentBenefit();
        return currentBenefitList;
    }

    public List<CurrentBenefit> getCurrentBenefitByPeopleId(Long peopleId) {

        return currentBenefitDao.getCurrentBenefitByPeopleId(peopleId);
    }

    public CurrentBenefit getCurrentBenefitById(Long id) {

        return currentBenefitDao.getCurrentBenefitById(id);
    }

    public boolean addCurrentBenefit(CurrentBenefit peopleJournal) {

        peopleJournal.setId(++id);
        return currentBenefitDao.addCurrentBenefit(peopleJournal);
    }

    public boolean deleteCurrentBenefitById(Long id) {

        boolean ret = false;
        ret = currentBenefitDao.deleteCurrentBenefitById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        currentBenefitList.clear();
        id = 0L;
        return currentBenefitDao.deleteAll();
    }

    public boolean updateListCurrentBenefit(List<CurrentBenefit> listCurrentBenefit) {

        return currentBenefitDao.updateListCurrentBenefit(listCurrentBenefit);
    }

    public boolean addListCurrentBenefit(List<CurrentBenefit> listCurrentBenefit) {

        return currentBenefitDao.addListCurrentBenefit(listCurrentBenefit);
    }

    public boolean updateCurrentBenefit(CurrentBenefit peopleHistory) {

        CurrentBenefit foundCurrentBenefit = getCurrentBenefitById(peopleHistory.getId());
        if (foundCurrentBenefit != null) {
            currentBenefitList.remove(foundCurrentBenefit);
            currentBenefitList.add(peopleHistory);
        }
        return currentBenefitDao.updateCurrentBenefit(peopleHistory);

    }

}
