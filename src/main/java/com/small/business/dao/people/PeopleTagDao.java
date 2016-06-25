package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.PeopleTag;

public interface PeopleTagDao {

    public List<PeopleTag> getAllPeopleTag();

    public PeopleTag getPeopleTagById(Long id);

    public boolean addListPeopleTag(List<PeopleTag> listPeopleTag);

    public PeopleTag getPeopleTagByPeopleId(Long peopleId);

    public boolean updateListPeopleTag(List<PeopleTag> listPeopleTag);

    public boolean addPeopleTag(PeopleTag peopleTag);

    public boolean deletePeopleTagById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleTag(PeopleTag peopleTag);
}
