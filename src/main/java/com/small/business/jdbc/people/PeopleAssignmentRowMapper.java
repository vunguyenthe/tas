package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.PeopleAssignment;

public class PeopleAssignmentRowMapper implements RowMapper {

    public PeopleAssignment mapRow(ResultSet resultSet, int line) throws SQLException {

        PeopleAssignmentExtractor userExtractor = new PeopleAssignmentExtractor();
        return userExtractor.extractData(resultSet);
    }

}