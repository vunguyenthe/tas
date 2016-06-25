package com.small.business.dao.assignment;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.assignment.AssignmentTagRowMapper;
import com.small.business.model.assignment.AssignmentTag;

public class AssignmentTagDaoImpl implements AssignmentTagDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentTagDaoImpl.class);

    public List<AssignmentTag> getAllAssignmentTag() {

        List<AssignmentTag> assignmentTagList = new ArrayList();

        String sql = "select * from AssignmentTag";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentTagList = jdbcTemplate.query(sql, new AssignmentTagRowMapper());
        return assignmentTagList;
    }

    public AssignmentTag getAssignmentTagByAssignmentId(Long assignmentId) {

        AssignmentTag assignment = new AssignmentTag();
        List<AssignmentTag> assignmentTagList = new ArrayList<AssignmentTag>();
        String sql = "select * from AssignmentTag where assignmentId= " + assignmentId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentTagList = jdbcTemplate.query(sql, new AssignmentTagRowMapper());
        if (assignmentTagList.size() > 0) {
            return assignmentTagList.get(0);
        }
        return assignment;
    }

    public AssignmentTag getAssignmentTagById(Long id) {

        AssignmentTag assignment = new AssignmentTag();
        List<AssignmentTag> assignmentTagList = new ArrayList<AssignmentTag>();
        String sql = "select * from AssignmentTag where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentTagList = jdbcTemplate.query(sql, new AssignmentTagRowMapper());
        if (assignmentTagList.size() > 0) {
            return assignmentTagList.get(0);
        }
        return assignment;
    }

    public boolean addAssignmentTag(AssignmentTag assignmentTag) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO AssignmentTag "
                    + "(assignmentId, industryId, locationId, positionFunId, positionLevelId,  languageId) "
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            assignmentTag.getAssignmentId(),
                            assignmentTag.getIndustryId(),
                            assignmentTag.getLocationId(),
                            assignmentTag.getPositionFunId(),
                            assignmentTag.getPositionLevelId(),
                            assignmentTag.getLanguageId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addAssignmentTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteAssignmentTagById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from AssignmentTag where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAssignmentTagById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from AssignmentTag";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public boolean updateListAssignmentTag(List<AssignmentTag> listAssignmentTag) {

        boolean ret = true;
        try {
            if (listAssignmentTag.size() > 0) {
                for (AssignmentTag obj : listAssignmentTag) {
                    updateAssignmentTag(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListAssignmentTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListAssignmentTag(List<AssignmentTag> listAssignmentTag) {

        System.out.println("->addListAssignmentTag");
        boolean ret = true;
        try {
            if (listAssignmentTag.size() > 0) {
                for (AssignmentTag obj : listAssignmentTag) {
                    addAssignmentTag(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListAssignmentTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateAssignmentTag(AssignmentTag assignmentTag) {

        boolean ret = true;
        try {
            String sql = "update AssignmentTag set assignmentId = ?, industryId = ?, locationId = ?, positionFunId = ?, positionLevelId = ?,  languageId = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("Id = " + assignmentTag.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            assignmentTag.getAssignmentId(),
                            assignmentTag.getIndustryId(),
                            assignmentTag.getLocationId(),
                            assignmentTag.getPositionFunId(),
                            assignmentTag.getPositionLevelId(),
                            assignmentTag.getLanguageId(),
                            assignmentTag.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updateAssignmentTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
