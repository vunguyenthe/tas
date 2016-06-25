package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.PeopleDocument;

public class PeopleDocumentRowMapper implements RowMapper {

    public PeopleDocument mapRow(ResultSet resultSet, int line) throws SQLException {

        PeopleDocumentExtractor userExtractor = new PeopleDocumentExtractor();
        return userExtractor.extractData(resultSet);
    }

}