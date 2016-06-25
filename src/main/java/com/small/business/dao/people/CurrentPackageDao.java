package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.CurrentPackage;

public interface CurrentPackageDao {

    public List<CurrentPackage> getAllCurrentPackage();

    public CurrentPackage getCurrentPackageById(Long id);

    public boolean addCurrentPackage(CurrentPackage CurrentPackage);

    public boolean addListCurrentPackage(List<CurrentPackage> listCurrentPackage);

    public List<CurrentPackage> getCurrentPackageByPeopleId(Long peopleId);

    public boolean updateListCurrentPackage(List<CurrentPackage> listCurrentPackage);

    public boolean deleteCurrentPackageById(Long id);

    public boolean deleteAll();

    public boolean updateCurrentPackage(CurrentPackage CurrentPackage);
}
