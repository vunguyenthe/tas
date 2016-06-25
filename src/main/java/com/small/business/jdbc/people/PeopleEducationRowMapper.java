package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.PeopleEducation;

public class PeopleEducationRowMapper implements RowMapper {

    public PeopleEducation mapRow(ResultSet resultSet, int line) throws SQLException {

        PeopleEducationExtractor userExtractor = new PeopleEducationExtractor();
        return userExtractor.extractData(resultSet);
    }

}