package com.small.business.dao.assignment;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.assignment.AssignmentRowMapper;
import com.small.business.jdbc.people.PeopleRowMapper;
import com.small.business.model.assignment.Assignment;
import com.small.business.model.people.People;

public class AssignmentDaoImpl implements AssignmentDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(AssignmentDaoImpl.class);

    public Long getNextAssignmentId() {

        String sql = "select max(id) as assignmentId from assignment";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long maxId = (long) jdbcTemplate.queryForInt(sql);
        if (maxId == 0)
            maxId = 1L;
        System.out.println("maxId -> " + maxId);
        return maxId;
    }

    @SuppressWarnings("unchecked")
    public List<Assignment> getFullAssignment() {

        List<Assignment> assignmentList = new ArrayList<>();
        String sql = "select *from Assignment";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentList = jdbcTemplate.query(sql, new AssignmentRowMapper());
        return assignmentList;
    }

    @SuppressWarnings("unchecked")
    public List<Assignment> getAllAssignment() {

        List<Assignment> assignmentList = new ArrayList<>();
        String sql = "select * from Assignment";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentList = jdbcTemplate.query(sql, new AssignmentRowMapper());
        return assignmentList;
    }

    @SuppressWarnings("unchecked")
    private People getPeopleById(Long id) {

        People people = new People();
        List<People> peopleList = new ArrayList<People>();
        String sql = "select * from People where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleList = jdbcTemplate.query(sql, new PeopleRowMapper());
        if (peopleList.size() > 0) {
            return peopleList.get(0);
        }
        return people;
    }

    @SuppressWarnings("unchecked")
    public Assignment getAssignmentById(Long id) {

        Assignment assignment = new Assignment();
        List<Assignment> assignmentList = new ArrayList<>();
        String sql = "select * from Assignment where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        assignmentList = jdbcTemplate.query(sql, new AssignmentRowMapper());
        if (assignmentList.size() > 0) {
            assignment = assignmentList.get(0);
            if (assignment.getClientId() > 0) {
                People p = getPeopleById(assignment.getClientId());
                if (p.getFullName() != null && p.getFullName().length() > 0) {
                    assignment.setClientName(p.getFullName());
                }
                p = getPeopleById(assignment.getPrimaryContactId());
                if (p.getFullName() != null && p.getFullName().length() > 0) {
                    assignment.setPrimaryContactName(p.getFullName());
                }
                p = getPeopleById(assignment.getOtherContactId());
                if (p.getFullName() != null && p.getFullName().length() > 0) {
                    assignment.setPrimaryContactName(p.getFullName());
                }
            }
        }
        return assignment;
    }

    public boolean addAssignment(Assignment assignment) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO Assignment "
                    + "(assignment, language, industry, "
                    + "assignmenetSt, engagement, clientId, location,"
                    + "department, primaryContactId, otherContactId, signedContract,"
                    + "clientName, primaryContactName, otherContactName) "
                    + "VALUES (?, ?, ?,"
                    + " ?, ?, ?, ?,"
                    + "?, ?, ?, ?,"
                    + "?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            assignment.getAssignment(),
                            assignment.getLanguage(),
                            assignment.getIndustry(),
                            assignment.getAssignmenetSt(),
                            assignment.getEngagement(),
                            assignment.getClientId(),
                            assignment.getLocation(),
                            assignment.getDepartment(),
                            assignment.getPrimaryContactId(),
                            assignment.getOtherContactId(),
                            assignment.getSignedContract(),
                            assignment.getClientName(),
                            assignment.getPrimaryContactName(),
                            assignment.getOtherContactName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addAssignment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteAssignmentById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from Assignment where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAssignmentById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from Assignment";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateAssignment(Assignment assignment) {

        boolean ret = true;
        try {
            String sql = "update Assignment set assignment = ?, language = ?, industry = ?, assignmenetSt = ?, "
                    + " engagement = ?, clientId = ?, location = ?, department = ?, "
                    + " primaryContactId = ?, otherContactId = ?, signedContract = ?, "
                    + " clientName = ?, primaryContactName = ?, otherContactName = ? where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("assignmentId = " + assignment.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            assignment.getAssignment(),
                            assignment.getLanguage(),
                            assignment.getIndustry(),
                            assignment.getAssignmenetSt(),
                            assignment.getEngagement(),
                            assignment.getClientId(),
                            assignment.getLocation(),
                            assignment.getDepartment(),
                            assignment.getPrimaryContactId(),
                            assignment.getOtherContactId(),
                            assignment.getSignedContract(),
                            assignment.getClientName(),
                            assignment.getPrimaryContactName(),
                            assignment.getOtherContactName(),
                            assignment.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateAssignment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
