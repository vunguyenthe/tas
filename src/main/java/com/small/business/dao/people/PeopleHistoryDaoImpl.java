package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.PeopleHistoryRowMapper;
import com.small.business.model.people.PeopleHistory;

public class PeopleHistoryDaoImpl implements PeopleHistoryDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(PeopleHistoryDaoImpl.class);

    public List<PeopleHistory> getAllPeopleHistory() {

        List<PeopleHistory> peopleHistoryList = new ArrayList();

        String sql = "select * from PeopleHistory";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleHistoryList = jdbcTemplate.query(sql, new PeopleHistoryRowMapper());
        return peopleHistoryList;
    }

    public List<PeopleHistory> getPeopleHistoryByPeopleId(Long peopleId) {

        List<PeopleHistory> peopleHistoryList = new ArrayList<PeopleHistory>();
        String sql = "select * from PeopleHistory where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleHistoryList = jdbcTemplate.query(sql, new PeopleHistoryRowMapper());
        return peopleHistoryList;
    }

    public PeopleHistory getPeopleHistoryById(Long id) {

        PeopleHistory assignment = new PeopleHistory();
        List<PeopleHistory> peopleHistoryList = new ArrayList<PeopleHistory>();
        String sql = "select * from PeopleHistory where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleHistoryList = jdbcTemplate.query(sql, new PeopleHistoryRowMapper());
        if (peopleHistoryList.size() > 0) {
            return peopleHistoryList.get(0);
        }
        return assignment;
    }

    public boolean updateListPeopleHistory(List<PeopleHistory> listPeopleHistory) {

        boolean ret = true;
        try {
            if (listPeopleHistory.size() > 0) {
                for (PeopleHistory obj : listPeopleHistory) {
                    updatePeopleHistory(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updatePeopleHistory got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListPeopleHistory(List<PeopleHistory> listPeopleHistory) {

        System.out.println("->addListPeopleHistory");
        boolean ret = true;
        try {
            if (listPeopleHistory.size() > 0) {
                for (PeopleHistory obj : listPeopleHistory) {
                    addPeopleHistory(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListaddPeopleHistory got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addPeopleHistory(PeopleHistory peopleHistory) {

        if (peopleHistory.getYearStarted() == null)
            return true;

        boolean ret = true;
        try {
            String sql = "INSERT INTO PeopleHistory "
                    + "(peopleId, jobTitle, companyId, "
                    + "institution, yearStarted, yearEnd, companyName) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleHistory.getPeopleId(),
                            peopleHistory.getJobTitle(),
                            peopleHistory.getCompanyId(),
                            peopleHistory.getInstitution(),
                            peopleHistory.getYearStarted(),
                            peopleHistory.getYearEnd(),
                            peopleHistory.getCompanyName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addPeopleHistory got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deletePeopleHistoryById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from PeopleHistory where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.error("deletePeopleHistoryById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from PeopleHistory";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.error("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updatePeopleHistory(PeopleHistory peopleHistory) {

        boolean ret = true;
        try {
            String sql = "update PeopleHistory set peopleId = ?, jobTitle = ?, companyId = ?, institution = ?, yearStarted = ?, yearEnd = ?, companyName = ?"
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("assignmentId = " + peopleHistory.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleHistory.getPeopleId(),
                            peopleHistory.getJobTitle(),
                            peopleHistory.getCompanyId(),
                            peopleHistory.getInstitution(),
                            peopleHistory.getYearStarted(),
                            peopleHistory.getYearEnd(),
                            peopleHistory.getCompanyName(),
                            peopleHistory.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updatePeopleHistory got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
