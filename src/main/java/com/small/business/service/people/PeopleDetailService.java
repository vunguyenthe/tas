package com.small.business.service.people;

import java.util.List;

import com.small.business.model.people.PeopleDetail;

public interface PeopleDetailService {

    public List<PeopleDetail> getAllPeopleDetail();

    public PeopleDetail getPeopleDetailById(Long id);

    public boolean addPeopleDetail(PeopleDetail PeopleDetail);

    public boolean addListPeopleDetail(List<PeopleDetail> listPeopleDetail);

    public PeopleDetail getPeopleDetailByPeopleId(Long peopleId);

    public Long getNextPeopleId();

    public boolean updateListPeopleDetail(List<PeopleDetail> listPeopleDetail);

    public boolean deletePeopleDetailById(Long id);

    public boolean deleteAll();

    public boolean updatePeopleDetail(PeopleDetail PeopleDetail);
}
