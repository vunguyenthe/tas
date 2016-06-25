package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.PeopleJournal;

public class PeopleJournalRowMapper implements RowMapper {

    public PeopleJournal mapRow(ResultSet resultSet, int line) throws SQLException {

        PeopleJournalExtractor userExtractor = new PeopleJournalExtractor();
        return userExtractor.extractData(resultSet);
    }

}