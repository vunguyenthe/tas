package com.small.business.service.people;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.small.business.model.people.People;

public interface PeopleService {

    public List<People> getAllPeople();

    public List<People> getAllClient();

    public List<People> getAllCandidate();

    public People getPeopleById(Long id);

    public Long getNextPeopleId();

    public boolean addPeople(People People);

    public boolean deletePeopleById(Long id);

    public boolean deleteAll();

    public boolean updatePeople(People People);

    public boolean uploadFilePostMethod(MultipartFile file,
            String targetFile);

}
