package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.PeopleNotepad;

public class PeopleNotepadRowMapper implements RowMapper {

    public PeopleNotepad mapRow(ResultSet resultSet, int line) throws SQLException {

        PeopleNotepadExtractor userExtractor = new PeopleNotepadExtractor();
        return userExtractor.extractData(resultSet);
    }

}