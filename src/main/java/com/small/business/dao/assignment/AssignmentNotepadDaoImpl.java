package com.small.business.dao.assignment;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.assignment.AssignmentNotepadRowMapper;
import com.small.business.model.assignment.AssignmentNotepad;

public class AssignmentNotepadDaoImpl implements AssignmentNotepadDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentNotepadDaoImpl.class);

    public List<AssignmentNotepad> getAllAssignmentNotepad() {

        List<AssignmentNotepad> assignmentBriefList = new ArrayList();

        String sql = "select * from assignmentnotepad";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentBriefList = jdbcTemplate.query(sql, new AssignmentNotepadRowMapper());
        return assignmentBriefList;
    }

    public AssignmentNotepad getAssignmentNotepadById(Long id) {

        AssignmentNotepad assignment = new AssignmentNotepad();
        List<AssignmentNotepad> assignmentBriefList = new ArrayList<AssignmentNotepad>();
        String sql = "select * from assignmentnotepad where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentBriefList = jdbcTemplate.query(sql, new AssignmentNotepadRowMapper());
        if (assignmentBriefList.size() > 0) {
            return assignmentBriefList.get(0);
        }
        return assignment;
    }

    public boolean addAssignmentNotepad(AssignmentNotepad assignmentBrief) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO assignmentnotepad "
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
            logger.debug("assignmentnodepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteAssignmentNotepadById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from assignmentnotepad where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAssignmentNotepadById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from assignmentnotepad";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateAssignmentNotepad(AssignmentNotepad assignmentBrief) {

        boolean ret = true;
        try {
            String sql = "update assignmentnotepad set assignmentId = ?, content = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("AssignmentNotepad Id = " + assignmentBrief.getId());
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
            logger.debug("updateAssignmentNotepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListAssignmentNotepad(List<AssignmentNotepad> listAssignmentNotepad) {

        System.out.println("->addListAssignmentNotepad");
        boolean ret = true;
        try {
            if (listAssignmentNotepad.size() > 0) {
                for (AssignmentNotepad obj : listAssignmentNotepad) {
                    addAssignmentNotepad(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListAssignmentNotepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListAssignmentNotepad(List<AssignmentNotepad> listAssignmentNotepad) {

        boolean ret = true;
        try {
            if (listAssignmentNotepad.size() > 0) {
                for (AssignmentNotepad obj : listAssignmentNotepad) {
                    updateAssignmentNotepad(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListAssignmentNotepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public List<AssignmentNotepad> getListAssignmentNotepadByAssignmentId(Long assignmentId) {

        List<AssignmentNotepad> assignmentBriefList = new ArrayList<AssignmentNotepad>();
        String sql = "select * from assignmentnotepad where assignmentId= " + assignmentId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentBriefList = jdbcTemplate.query(sql, new AssignmentNotepadRowMapper());
        return assignmentBriefList;
    }

}
