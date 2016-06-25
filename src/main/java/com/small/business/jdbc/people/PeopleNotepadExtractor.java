package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.PeopleNotepad;

public class PeopleNotepadExtractor implements ResultSetExtractor {

    public PeopleNotepad extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        PeopleNotepad peopleNotepad = new PeopleNotepad();
        int id = 1;
        peopleNotepad.setId(resultSet.getLong(id++));
        peopleNotepad.setPeopleId(resultSet.getLong(id++));
        peopleNotepad.setContent(resultSet.getString(id++));
        return peopleNotepad;
    }
}
