package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.PeopleTagRowMapper;
import com.small.business.model.people.PeopleTag;

public class PeopleTagDaoImpl implements PeopleTagDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(PeopleTagDaoImpl.class);

    public List<PeopleTag> getAllPeopleTag() {

        List<PeopleTag> peopleTagList = new ArrayList();

        String sql = "select * from PeopleTag";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleTagList = jdbcTemplate.query(sql, new PeopleTagRowMapper());
        return peopleTagList;
    }

    public PeopleTag getPeopleTagByPeopleId(Long peopleId) {

        List<PeopleTag> peopleTagList = new ArrayList<PeopleTag>();
        PeopleTag peopleTag = new PeopleTag();
        String sql = "select * from PeopleTag where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleTagList = jdbcTemplate.query(sql, new PeopleTagRowMapper());
        if (peopleTagList.size() > 0) {
            return peopleTagList.get(0);
        }
        return peopleTag;
    }

    public PeopleTag getPeopleTagById(Long id) {

        PeopleTag peopleTag = new PeopleTag();
        List<PeopleTag> peopleTagList = new ArrayList<PeopleTag>();
        String sql = "select * from PeopleTag where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleTagList = jdbcTemplate.query(sql, new PeopleTagRowMapper());
        if (peopleTagList.size() > 0) {
            return peopleTagList.get(0);
        }
        return peopleTag;
    }

    public boolean addPeopleTag(PeopleTag peopleTag) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO PeopleTag "
                    + "(peopleId, industryId, locationId, positionFunId, positionLevelId,  languageId) "
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleTag.getPeopleId(),
                            peopleTag.getIndustryId(),
                            peopleTag.getLocationId(),
                            peopleTag.getPositionFunId(),
                            peopleTag.getPositionLevelId(),
                            peopleTag.getLanguageId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addPeopleTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deletePeopleTagById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from PeopleTag where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deletePeopleTagById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from PeopleTag";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public boolean updateListPeopleTag(List<PeopleTag> listPeopleTag) {

        boolean ret = true;
        try {
            if (listPeopleTag.size() > 0) {
                for (PeopleTag obj : listPeopleTag) {
                    updatePeopleTag(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListPeopleTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListPeopleTag(List<PeopleTag> listPeopleTag) {

        System.out.println("->addListPeopleTag");
        boolean ret = true;
        try {
            if (listPeopleTag.size() > 0) {
                for (PeopleTag obj : listPeopleTag) {
                    addPeopleTag(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListPeopleTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updatePeopleTag(PeopleTag peopleTag) {

        boolean ret = true;
        try {
            String sql = "update PeopleTag set peopleId = ?, industryId = ?, locationId = ?, positionFunId = ?, positionLevelId = ?,  languageId = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("Id = " + peopleTag.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleTag.getPeopleId(),
                            peopleTag.getIndustryId(),
                            peopleTag.getLocationId(),
                            peopleTag.getPositionFunId(),
                            peopleTag.getPositionLevelId(),
                            peopleTag.getLanguageId(),
                            peopleTag.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updatePeopleTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
