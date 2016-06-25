package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.PeopleEducation;

public interface PeopleEducationDao {

    public List<PeopleEducation> getAllPeopleEducation();

    public PeopleEducation getPeopleEducationById(Long id);

    public boolean addPeopleEducation(PeopleEducation peopleEducation);

    public boolean addListPeopleEducation(List<PeopleEducation> listPeopleEducation);

    public List<PeopleEducation> getPeopleEducationByPeopleId(Long peopleId);

    public boolean updateListPeopleEducation(List<PeopleEducation> listPeopleEducation);

    public boolean deletePeopleEducationById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleEducation(PeopleEducation peopleEducation);
}
