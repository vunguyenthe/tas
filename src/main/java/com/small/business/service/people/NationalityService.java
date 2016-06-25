package com.small.business.service.people;

import java.util.List;

import com.small.business.model.people.Nationality;

public interface NationalityService {

    public List<Nationality> getAllNationality();

    public Nationality getNationalityById(Long id);

    public boolean addNationality(Nationality peopleDocument);

    public boolean addListNationality(List<Nationality> listNationality);

    public boolean updateListNationality(List<Nationality> listNationality);

    public boolean deleteNationalityById(Long id);

    public boolean deleteAll();

    public boolean updateNationality(Nationality peopleDocument);
}
