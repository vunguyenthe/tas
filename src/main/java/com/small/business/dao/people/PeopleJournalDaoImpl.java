package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.PeopleJournalRowMapper;
import com.small.business.model.people.PeopleJournal;

public class PeopleJournalDaoImpl implements PeopleJournalDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(PeopleJournalDaoImpl.class);

    public List<PeopleJournal> getAllPeopleJournal() {

        List<PeopleJournal> peopleJournalList = new ArrayList();

        String sql = "select * from PeopleJournal";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleJournalList = jdbcTemplate.query(sql, new PeopleJournalRowMapper());
        return peopleJournalList;
    }

    public List<PeopleJournal> getPeopleJournalByPeopleId(Long peopleId) {

        List<PeopleJournal> peopleJournalList = new ArrayList<PeopleJournal>();
        String sql = "select * from PeopleJournal where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleJournalList = jdbcTemplate.query(sql, new PeopleJournalRowMapper());
        return peopleJournalList;

    }

    public PeopleJournal getPeopleJournalById(Long id) {

        PeopleJournal assignment = new PeopleJournal();
        List<PeopleJournal> peopleJournalList = new ArrayList<PeopleJournal>();
        String sql = "select * from PeopleJournal where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleJournalList = jdbcTemplate.query(sql, new PeopleJournalRowMapper());
        if (peopleJournalList.size() > 0) {
            return peopleJournalList.get(0);
        }
        return assignment;
    }

    public boolean addListPeopleJournal(List<PeopleJournal> listPeopleJournal) {

        System.out.println("->addListPeopleJournal");
        boolean ret = true;
        try {
            if (listPeopleJournal.size() > 0) {
                for (PeopleJournal obj : listPeopleJournal) {
                    addPeopleJournal(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListPeopleJournal got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListPeopleJournal(List<PeopleJournal> listPeopleJournal) {

        boolean ret = true;
        try {
            if (listPeopleJournal.size() > 0) {
                for (PeopleJournal obj : listPeopleJournal) {
                    updatePeopleJournal(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListPeopleJournal got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addPeopleJournal(PeopleJournal peopleJournal) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO PeopleJournal "
                    + "(peopleId, journaType, userId, "
                    + "notes, userName) "
                    + "VALUES (?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleJournal.getPeopleId(),
                            peopleJournal.getJournaType(),
                            peopleJournal.getUserId(),
                            peopleJournal.getNotes(),
                            peopleJournal.getUserName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addPeopleJournal got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deletePeopleJournalById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from PeopleJournal where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deletePeopleJournalById got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from PeopleJournal";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updatePeopleJournal(PeopleJournal peopleJournal) {

        boolean ret = true;
        try {
            String sql = "update PeopleJournal set peopleId = ?, journaType = ?, userId = ?, notes = ?, userName = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("assignmentId = " + peopleJournal.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleJournal.getPeopleId(),
                            peopleJournal.getJournaType(),
                            peopleJournal.getUserId(),
                            peopleJournal.getNotes(),
                            peopleJournal.getUserName(),
                            peopleJournal.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updatePeopleJournal got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
