package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.PeopleEducationRowMapper;
import com.small.business.model.people.PeopleEducation;

public class PeopleEducationDaoImpl implements PeopleEducationDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(PeopleEducationDaoImpl.class);

    public List<PeopleEducation> getAllPeopleEducation() {

        List<PeopleEducation> peopleEducationList = new ArrayList();

        String sql = "select * from PeopleEducation";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleEducationList = jdbcTemplate.query(sql, new PeopleEducationRowMapper());
        return peopleEducationList;
    }

    public PeopleEducation getPeopleEducationById(Long id) {

        PeopleEducation assignment = new PeopleEducation();
        List<PeopleEducation> peopleEducationList = new ArrayList<PeopleEducation>();
        String sql = "select * from PeopleEducation where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleEducationList = jdbcTemplate.query(sql, new PeopleEducationRowMapper());
        if (peopleEducationList.size() > 0) {
            return peopleEducationList.get(0);
        }
        return assignment;
    }

    public List<PeopleEducation> getPeopleEducationByPeopleId(Long peopleId) {

        List<PeopleEducation> peopleEducationList = new ArrayList<PeopleEducation>();
        String sql = "select * from PeopleEducation where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleEducationList = jdbcTemplate.query(sql, new PeopleEducationRowMapper());
        return peopleEducationList;
    }

    public boolean addListPeopleEducation(List<PeopleEducation> listPeopleEducation) {

        System.out.println("->addListPeopleEducation");
        boolean ret = true;
        try {
            if (listPeopleEducation.size() > 0) {
                for (PeopleEducation obj : listPeopleEducation) {
                    addPeopleEducation(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListPeopleEducation got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addPeopleEducation(PeopleEducation peopleEducation) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO PeopleEducation "
                    + "(peopleId, journaType, qualification, "
                    + "institution, yearStarted, yearEnd, journalName) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleEducation.getPeopleId(),
                            peopleEducation.getJournaType(),
                            peopleEducation.getQualification(),
                            peopleEducation.getInstitution(),
                            peopleEducation.getYearStarted(),
                            peopleEducation.getYearEnd(),
                            peopleEducation.getJournalName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("addPeopleEducation got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deletePeopleEducationById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from PeopleEducation where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deletePeopleEducationById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from PeopleEducation";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.error("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateListPeopleEducation(List<PeopleEducation> listPeopleEducation) {

        boolean ret = true;
        try {
            if (listPeopleEducation.size() > 0) {
                for (PeopleEducation obj : listPeopleEducation) {
                    updatePeopleEducation(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListPeopleEducation got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updatePeopleEducation(PeopleEducation peopleEducation) {

        boolean ret = true;
        try {
            String sql = "update PeopleEducation set peopleId = ?, journaType = ?, qualification = ?, institution = ?, yearStarted = ?, yearEnd = ?, journalName = ?"
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("assignmentId = " + peopleEducation.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleEducation.getPeopleId(),
                            peopleEducation.getJournaType(),
                            peopleEducation.getQualification(),
                            peopleEducation.getInstitution(),
                            peopleEducation.getYearStarted(),
                            peopleEducation.getYearEnd(),
                            peopleEducation.getJournalName(),
                            peopleEducation.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updatePeopleEducation got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
