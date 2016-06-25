package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.PeopleAssignmentRowMapper;
import com.small.business.model.people.PeopleAssignment;

public class PeopleAssignmentDaoImpl implements PeopleAssignmentDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(PeopleAssignmentDaoImpl.class);

    public List<PeopleAssignment> getAllPeopleAssignment() {

        List<PeopleAssignment> peopleAssignmentList = new ArrayList();

        String sql = "select * from PeopleAssignment";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleAssignmentList = jdbcTemplate.query(sql, new PeopleAssignmentRowMapper());
        return peopleAssignmentList;
    }

    public List<PeopleAssignment> getPeopleAssignmentByPeopleId(Long peopleId) {

        List<PeopleAssignment> peopleAssignmentList = new ArrayList<PeopleAssignment>();
        String sql = "select * from PeopleAssignment where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleAssignmentList = jdbcTemplate.query(sql, new PeopleAssignmentRowMapper());
        return peopleAssignmentList;
    }

    public PeopleAssignment getPeopleAssignmentById(Long id) {

        PeopleAssignment assignment = new PeopleAssignment();
        List<PeopleAssignment> peopleAssignmentList = new ArrayList<PeopleAssignment>();
        String sql = "select * from PeopleAssignment where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleAssignmentList = jdbcTemplate.query(sql, new PeopleAssignmentRowMapper());
        if (peopleAssignmentList.size() > 0) {
            return peopleAssignmentList.get(0);
        }
        return assignment;
    }

    public boolean addPeopleAssignment(PeopleAssignment peopleAssignment) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO PeopleAssignment "
                    + "(peopleId, assignmentId, companyId, assignmentName, companyName) "
                    + " VALUES (?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleAssignment.getPeopleId(),
                            peopleAssignment.getAssignmentId(),
                            peopleAssignment.getCompanyId(),
                            peopleAssignment.getAssignmentName(),
                            peopleAssignment.getCompanyName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("addPeopleAssignment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deletePeopleAssignmentById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from PeopleAssignment where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.error("deletePeopleAssignmentById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from PeopleAssignment";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.error("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updatePeopleAssignment(PeopleAssignment peopleAssignment) {

        boolean ret = true;
        try {
            String sql = "update PeopleAssignment set peopleId = ?, assignmentId = ?, companyId = ?, assignmentName = ?, companyName = ?"
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("assignmentId = " + peopleAssignment.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleAssignment.getPeopleId(),
                            peopleAssignment.getAssignmentId(),
                            peopleAssignment.getCompanyId(),
                            peopleAssignment.getAssignmentName(),
                            peopleAssignment.getCompanyName(),
                            peopleAssignment.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updatePeopleAssignment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean updateListPeopleAssignment(List<PeopleAssignment> listPeopleAssignment) {

        boolean ret = true;
        try {
            if (listPeopleAssignment.size() > 0) {
                for (PeopleAssignment obj : listPeopleAssignment) {
                    updatePeopleAssignment(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListPeopleAssignment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListPeopleAssignment(List<PeopleAssignment> listPeopleAssignment) {

        System.out.println("->addListPeopleAssignment");
        boolean ret = true;
        try {
            if (listPeopleAssignment.size() > 0) {
                for (PeopleAssignment obj : listPeopleAssignment) {
                    addPeopleAssignment(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListPeopleAssignment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
