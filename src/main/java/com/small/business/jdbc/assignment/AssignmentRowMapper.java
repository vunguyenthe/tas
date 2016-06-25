package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.assignment.Assignment;

public class AssignmentRowMapper implements RowMapper {

    public Assignment mapRow(ResultSet resultSet, int line) throws SQLException {

        AssignmentExtractor userExtractor = new AssignmentExtractor();
        return userExtractor.extractData(resultSet);
    }

}