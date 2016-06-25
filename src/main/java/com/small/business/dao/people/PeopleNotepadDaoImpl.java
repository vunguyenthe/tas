package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.PeopleNotepadRowMapper;
import com.small.business.model.people.PeopleNotepad;

public class PeopleNotepadDaoImpl implements PeopleNotepadDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(PeopleNotepadDaoImpl.class);

    public List<PeopleNotepad> getAllPeopleNotepad() {

        List<PeopleNotepad> peopleBriefList = new ArrayList();

        String sql = "select * from peoplenotepad";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleBriefList = jdbcTemplate.query(sql, new PeopleNotepadRowMapper());
        return peopleBriefList;
    }

    public PeopleNotepad getPeopleNotepadById(Long id) {

        PeopleNotepad people = new PeopleNotepad();
        List<PeopleNotepad> peopleBriefList = new ArrayList<PeopleNotepad>();
        String sql = "select * from peoplenotepad where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleBriefList = jdbcTemplate.query(sql, new PeopleNotepadRowMapper());
        if (peopleBriefList.size() > 0) {
            return peopleBriefList.get(0);
        }
        return people;
    }

    public boolean addPeopleNotepad(PeopleNotepad peopleBrief) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO peoplenotepad "
                    + "(peopleId, content) "
                    + " VALUES (?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleBrief.getPeopleId(),
                            peopleBrief.getContent()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("peoplenodepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deletePeopleNotepadById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from peoplenotepad where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deletePeopleNotepadById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from peoplenotepad";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updatePeopleNotepad(PeopleNotepad peopleBrief) {

        boolean ret = true;
        try {
            String sql = "update peoplenotepad set peopleId = ?, content = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("PeopleNotepad Id = " + peopleBrief.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleBrief.getPeopleId(),
                            peopleBrief.getContent(),
                            peopleBrief.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updatePeopleNotepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListPeopleNotepad(List<PeopleNotepad> listPeopleNotepad) {

        System.out.println("->addListPeopleNotepad");
        boolean ret = true;
        try {
            if (listPeopleNotepad.size() > 0) {
                for (PeopleNotepad obj : listPeopleNotepad) {
                    addPeopleNotepad(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListPeopleNotepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListPeopleNotepad(List<PeopleNotepad> listPeopleNotepad) {

        boolean ret = true;
        try {
            if (listPeopleNotepad.size() > 0) {
                for (PeopleNotepad obj : listPeopleNotepad) {
                    updatePeopleNotepad(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListPeopleNotepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public PeopleNotepad getListPeopleNotepadByPeopleId(Long peopleId) {

        PeopleNotepad peopleNotepad = new PeopleNotepad();
        List<PeopleNotepad> peopleNotepadList = new ArrayList<PeopleNotepad>();
        String sql = "select * from peoplenotepad where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleNotepadList = jdbcTemplate.query(sql, new PeopleNotepadRowMapper());
        if (peopleNotepadList.size() > 0) {
            return peopleNotepadList.get(0);
        }
        return peopleNotepad;
    }

}
