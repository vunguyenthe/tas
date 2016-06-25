package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.assignment.AssignmentCandidate;

public class AssignmentCandidateExtractor implements ResultSetExtractor {

    public AssignmentCandidate extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        AssignmentCandidate assignmentCandidate = new AssignmentCandidate();
        int id = 1;
        assignmentCandidate.setId(resultSet.getLong(id++));
        assignmentCandidate.setAssignmentId(resultSet.getLong(id++));
        assignmentCandidate.setUserId(resultSet.getLong(id++));
        assignmentCandidate.setCandidateId(resultSet.getLong(id++));
        assignmentCandidate.setCandidateName(resultSet.getString(id++));
        assignmentCandidate.setDetails(resultSet.getString(id++));
        assignmentCandidate.setDateCreated(resultSet.getString(id++));
        return assignmentCandidate;
    }
}
