package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.assignment.AssignmentTag;

public class AssignmentTagRowMapper implements RowMapper {

    public AssignmentTag mapRow(ResultSet resultSet, int line) throws SQLException {

        AssignmentTagExtractor assignmentTagExtractor = new AssignmentTagExtractor();
        return assignmentTagExtractor.extractData(resultSet);
    }

}