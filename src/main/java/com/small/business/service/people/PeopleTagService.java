package com.small.business.service.people;

import java.util.List;

import com.small.business.model.people.PeopleTag;

public interface PeopleTagService {

    public List<PeopleTag> getAllPeopleTag();

    public PeopleTag getPeopleTagById(Long id);

    public boolean addPeopleTag(PeopleTag peopleDocument);

    public boolean addListPeopleTag(List<PeopleTag> listPeopleTag);

    public PeopleTag getPeopleTagByPeopleId(Long peopleId);

    public boolean updateListPeopleTag(List<PeopleTag> listPeopleTag);

    public boolean deletePeopleTagById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleTag(PeopleTag peopleDocument);
}
