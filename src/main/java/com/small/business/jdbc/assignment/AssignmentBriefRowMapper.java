package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.assignment.AssignmentBrief;

public class AssignmentBriefRowMapper implements RowMapper {

    public AssignmentBrief mapRow(ResultSet resultSet, int line) throws SQLException {

        AssignmentBriefExtractor userExtractor = new AssignmentBriefExtractor();
        return userExtractor.extractData(resultSet);
    }

}