package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.PeopleDetail;

public class PeopleDetailRowMapper implements RowMapper {

    public PeopleDetail mapRow(ResultSet resultSet, int line) throws SQLException {

        PeopleDetailExtractor userExtractor = new PeopleDetailExtractor();
        return userExtractor.extractData(resultSet);
    }

}