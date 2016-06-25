package com.small.business.dao.assignment;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.assignment.AssignmentCandidateRowMapper;
import com.small.business.model.assignment.AssignmentCandidate;

public class AssignmentCandidateDaoImpl implements AssignmentCandidateDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentCandidateDaoImpl.class);

    public List<AssignmentCandidate> getAllAssignmentCandidate() {

        List<AssignmentCandidate> assignmentCandidateList = new ArrayList();

        String sql = "select * from AssignmentCandidate";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentCandidateList = jdbcTemplate.query(sql, new AssignmentCandidateRowMapper());
        return assignmentCandidateList;
    }

    public AssignmentCandidate getAssignmentCandidateById(Long id) {

        AssignmentCandidate assignment = new AssignmentCandidate();
        List<AssignmentCandidate> assignmentCandidateList = new ArrayList<AssignmentCandidate>();
        String sql = "select * from AssignmentCandidate where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentCandidateList = jdbcTemplate.query(sql, new AssignmentCandidateRowMapper());
        if (assignmentCandidateList.size() > 0) {
            return assignmentCandidateList.get(0);
        }
        return assignment;
    }

    public boolean addAssignmentCandidate(AssignmentCandidate assignmentCandidate) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO AssignmentCandidate "
                    + "(assignmentId, userId, candidateId, candidateName, "
                    + "details) "
                    + " VALUES (?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            assignmentCandidate.getAssignmentId(),
                            assignmentCandidate.getUserId(),
                            assignmentCandidate.getCandidateId(),
                            assignmentCandidate.getCandidateName(),
                            assignmentCandidate.getDetails()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addAssignmentCandidate got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteAssignmentCandidateById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from AssignmentCandidate where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAssignmentCandidateById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from AssignmentCandidate";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateAssignmentCandidate(AssignmentCandidate assignmentCandidate) {

        boolean ret = true;
        try {
            String sql = "update AssignmentCandidate set assignmentId = ?, userId = ?, candidateId = ?,"
                    + " candidateName = ?, details = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("AssignmentCandidate Id = " + assignmentCandidate.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            assignmentCandidate.getAssignmentId(),
                            assignmentCandidate.getUserId(),
                            assignmentCandidate.getCandidateId(),
                            assignmentCandidate.getCandidateName(),
                            assignmentCandidate.getDetails(),
                            assignmentCandidate.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateAssignmentCandidate got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListAssignmentCandidate(List<AssignmentCandidate> listAssignmentCandidate) {

        System.out.println("->addListAssignmentCandidate");
        boolean ret = true;
        try {
            if (listAssignmentCandidate.size() > 0) {
                for (AssignmentCandidate obj : listAssignmentCandidate) {
                    addAssignmentCandidate(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListAssignmentCandidate got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListAssignmentCandidate(List<AssignmentCandidate> listAssignmentCandidate) {

        boolean ret = true;
        try {
            if (listAssignmentCandidate.size() > 0) {
                for (AssignmentCandidate obj : listAssignmentCandidate) {
                    updateAssignmentCandidate(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListAssignmentCandidate got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public List<AssignmentCandidate> getListAssignmentCandidateByAssignmentId(Long assignmentId) {

        List<AssignmentCandidate> assignmentCandidateList = new ArrayList<AssignmentCandidate>();
        String sql = "select * from AssignmentCandidate where assignmentId= " + assignmentId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentCandidateList = jdbcTemplate.query(sql, new AssignmentCandidateRowMapper());
        return assignmentCandidateList;
    }

}
