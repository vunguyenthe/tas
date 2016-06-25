package com.small.business.dao.assignment;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.assignment.AssignmentBriefRowMapper;
import com.small.business.model.assignment.AssignmentBrief;

public class AssignmentBriefDaoImpl implements AssignmentBriefDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentBriefDaoImpl.class);

    public List<AssignmentBrief> getAllAssignmentBrief() {

        List<AssignmentBrief> assignmentBriefList = new ArrayList();

        String sql = "select * from AssignmentBrief";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentBriefList = jdbcTemplate.query(sql, new AssignmentBriefRowMapper());
        return assignmentBriefList;
    }

    public AssignmentBrief getAssignmentBriefById(Long id) {

        AssignmentBrief assignment = new AssignmentBrief();
        List<AssignmentBrief> assignmentBriefList = new ArrayList<AssignmentBrief>();
        String sql = "select * from AssignmentBrief where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentBriefList = jdbcTemplate.query(sql, new AssignmentBriefRowMapper());
        if (assignmentBriefList.size() > 0) {
            return assignmentBriefList.get(0);
        }
        return assignment;
    }

    public boolean addAssignmentBrief(AssignmentBrief assignmentBrief) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO AssignmentBrief "
                    + "(assignmentId, content) "
                    + " VALUES (?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            assignmentBrief.getAssignmentId(),
                            assignmentBrief.getContent()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addAssignmentBrief got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteAssignmentBriefById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from AssignmentBrief where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAssignmentBriefById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from AssignmentBrief";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateAssignmentBrief(AssignmentBrief assignmentBrief) {

        boolean ret = true;
        try {
            String sql = "update AssignmentBrief set assignmentId = ?, content = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("AssignmentBrief Id = " + assignmentBrief.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            assignmentBrief.getAssignmentId(),
                            assignmentBrief.getContent(),
                            assignmentBrief.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateAssignmentBrief got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListAssignmentBrief(List<AssignmentBrief> listAssignmentBrief) {

        System.out.println("->addListAssignmentBrief");
        boolean ret = true;
        try {
            if (listAssignmentBrief.size() > 0) {
                for (AssignmentBrief obj : listAssignmentBrief) {
                    addAssignmentBrief(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListAssignmentBrief got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListAssignmentBrief(List<AssignmentBrief> listAssignmentBrief) {

        boolean ret = true;
        try {
            if (listAssignmentBrief.size() > 0) {
                for (AssignmentBrief obj : listAssignmentBrief) {
                    updateAssignmentBrief(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListAssignmentBrief got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public List<AssignmentBrief> getListAssignmentBriefByAssignmentId(Long assignmentId) {

        List<AssignmentBrief> assignmentBriefList = new ArrayList<AssignmentBrief>();
        String sql = "select * from AssignmentBrief where assignmentId= " + assignmentId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentBriefList = jdbcTemplate.query(sql, new AssignmentBriefRowMapper());
        return assignmentBriefList;
    }

}
