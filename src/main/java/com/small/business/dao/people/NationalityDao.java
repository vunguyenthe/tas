package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.Nationality;

public interface NationalityDao {

    public List<Nationality> getAllNationality();

    public Nationality getNationalityById(Long id);

    public boolean addListNationality(List<Nationality> listNationality);

    public boolean updateListNationality(List<Nationality> listNationality);

    public boolean addNationality(Nationality nationality);

    public boolean deleteNationalityById(Long id);

    public boolean deleteAll();

    public boolean updateNationality(Nationality nationality);
}
