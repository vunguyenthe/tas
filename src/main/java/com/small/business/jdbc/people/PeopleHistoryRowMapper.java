package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.PeopleHistory;

public class PeopleHistoryRowMapper implements RowMapper {

    public PeopleHistory mapRow(ResultSet resultSet, int line) throws SQLException {

        PeopleHistoryExtractor userExtractor = new PeopleHistoryExtractor();
        return userExtractor.extractData(resultSet);
    }

}