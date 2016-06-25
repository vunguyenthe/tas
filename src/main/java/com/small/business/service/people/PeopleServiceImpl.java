package com.small.business.service.people;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.small.business.dao.people.PeopleDao;
import com.small.business.model.people.People;

@Service("PeopleService")
public class PeopleServiceImpl implements PeopleService {

    private static List<People> peopleList = new ArrayList<People>();
    private static Long id = 0L;
    private static final Logger logger = LoggerFactory.getLogger(PeopleServiceImpl.class);

    @Autowired
    PeopleDao peopleDao;

    public List<People> getAllPeople() {

        List<People> peopleList = peopleDao.getAllPeople();
        return peopleList;
    }

    public List<People> getAllCandidate() {

        List<People> peopleList = peopleDao.getAllCandidate();
        return peopleList;
    }

    public List<People> getAllClient() {

        List<People> peopleList = peopleDao.getAllClient();
        return peopleList;
    }

    public Long getNextPeopleId() {

        return peopleDao.getNextPeopleId();
    }

    public People getPeopleById(Long id) {

        return peopleDao.getPeopleById(id);
    }

    public boolean addPeople(People people) {

        people.setId(++id);
        return peopleDao.addPeople(people);
    }

    public boolean deletePeopleById(Long id) {

        boolean ret = false;
        ret = peopleDao.deletePeopleById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleList.clear();
        id = 0L;
        return peopleDao.deleteAll();
    }

    public boolean uploadFilePostMethod(MultipartFile file, String targetFile) {

        System.out.println("Upload file - post method");
        if (file != null) {

            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null)
                    System.out.println("File inputstream is null");
                File upload = new File(targetFile);
                file.transferTo(upload);
                System.out.println("imagePath ->" + targetFile);
                IOUtils.closeQuietly(inputStream);

            } catch (IOException ex) {
                logger.debug("uploadFilePostMethod got error: " + ex.getMessage());
                return false;
            }
        }

        return true;

    }

    public boolean updatePeople(People people) {

        People foundPeople = findPeopleById(people.getId());
        if (foundPeople != null) {
            peopleList.remove(foundPeople);
            peopleList.add(people);
        }
        return peopleDao.updatePeople(people);

    }

    private People findPeopleById(Long id) {

        return peopleDao.getPeopleById(id);
    }
}
