package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.CurrentBenefit;

public interface CurrentBenefitDao {

    public List<CurrentBenefit> getAllCurrentBenefit();

    public CurrentBenefit getCurrentBenefitById(Long id);

    public boolean addCurrentBenefit(CurrentBenefit CurrentBenefit);

    public boolean addListCurrentBenefit(List<CurrentBenefit> listCurrentBenefit);

    public List<CurrentBenefit> getCurrentBenefitByPeopleId(Long peopleId);

    public boolean updateListCurrentBenefit(List<CurrentBenefit> listCurrentBenefit);

    public boolean deleteCurrentBenefitById(Long id);

    public boolean deleteAll();

    public boolean updateCurrentBenefit(CurrentBenefit CurrentBenefit);
}
