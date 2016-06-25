package com.small.business.service.assignment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.small.business.dao.assignment.AssignmentDao;
import com.small.business.model.assignment.Assignment;

@Service("AssignmentService")
public class AssignmentServiceImpl implements AssignmentService {

    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentServiceImpl.class);
    private static List<Assignment> companyList = new ArrayList<Assignment>();
    private static Long id = 0L;

    @Autowired
    AssignmentDao assignmentDao;

    public List<Assignment> getAllAssignment() {

        List<Assignment> companyList = assignmentDao.getAllAssignment();
        return companyList;
    }

    public Assignment Assignment(Long id) {

        return assignmentDao.getAssignmentById(id);
    }

    public boolean addAssignment(Assignment company) {

        company.setId(++id);
        return assignmentDao.addAssignment(company);
    }

    public Long getNextAssignmentId() {

        return assignmentDao.getNextAssignmentId();
    }

    public boolean deleteAssignmentById(Long id) {

        boolean ret = false;
        ret = assignmentDao.deleteAssignmentById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyList.clear();
        id = 0L;
        return assignmentDao.deleteAll();
    }

    public String uploadFilePostMethod(MultipartFile file,
            HttpServletRequest request) {

        System.out.println("Upload file - post method");
        if (file != null) {

            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null)
                    System.out.println("File inputstream is null");

                String pathUpDir = request.getSession().getServletContext()
                        .getRealPath("/")
                        + "resources/cv/";

                File upload = new File(pathUpDir + file.getOriginalFilename());
                file.transferTo(upload);
                String imagePath = pathUpDir + file.getOriginalFilename();
                System.out.println("imagePath ->" + imagePath);
                IOUtils.closeQuietly(inputStream);

            } catch (IOException ex) {
                logger.debug("uploadFilePostMethod got error: " + ex.getMessage());
                return "ERROR";
            }
        }

        return "SUCCESS";

    }

    public boolean updateAssignment(Assignment assignment) {

        Assignment foundAssignment = getAssignmentById(assignment.getId());
        if (foundAssignment != null) {
            companyList.remove(foundAssignment);
            companyList.add(assignment);
        }
        return assignmentDao.updateAssignment(assignment);

    }

    public Assignment getAssignmentById(Long id) {

        return assignmentDao.getAssignmentById(id);
    }

}
