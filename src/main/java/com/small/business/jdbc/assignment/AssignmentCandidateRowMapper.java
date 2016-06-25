package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.assignment.AssignmentCandidate;

public class AssignmentCandidateRowMapper implements RowMapper {

    public AssignmentCandidate mapRow(ResultSet resultSet, int line) throws SQLException {

        AssignmentCandidateExtractor userExtractor = new AssignmentCandidateExtractor();
        return userExtractor.extractData(resultSet);
    }

}