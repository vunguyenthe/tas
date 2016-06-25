package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.PeopleTag;

public class PeopleTagRowMapper implements RowMapper {

    public PeopleTag mapRow(ResultSet resultSet, int line) throws SQLException {

        PeopleTagExtractor peopleTagExtractor = new PeopleTagExtractor();
        return peopleTagExtractor.extractData(resultSet);
    }

}