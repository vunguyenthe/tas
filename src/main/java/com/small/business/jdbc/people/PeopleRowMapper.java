package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.People;

public class PeopleRowMapper implements RowMapper {

    public People mapRow(ResultSet resultSet, int line) throws SQLException {

        PeopleExtractor userExtractor = new PeopleExtractor();
        return userExtractor.extractData(resultSet);
    }

}