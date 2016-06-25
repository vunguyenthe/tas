package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.PeopleJournal;

public class PeopleJournalExtractor implements ResultSetExtractor {

    public PeopleJournal extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        PeopleJournal peopleJournal = new PeopleJournal();
        int id = 1;
        peopleJournal.setId(resultSet.getLong(id++));
        peopleJournal.setPeopleId(resultSet.getLong(id++));
        peopleJournal.setJournaType(resultSet.getLong(id++));
        peopleJournal.setUserId(resultSet.getLong(id++));
        peopleJournal.setNotes(resultSet.getString(id++));
        peopleJournal.setUserName(resultSet.getString(id++));
        peopleJournal.setDate(resultSet.getString(id++));
        return peopleJournal;
    }
}
