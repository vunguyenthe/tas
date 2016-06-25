package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.PeopleDocument;

public class PeopleDocumentExtractor implements ResultSetExtractor {

    public PeopleDocument extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        PeopleDocument peopleDocument = new PeopleDocument();
        int id = 1;
        peopleDocument.setId(resultSet.getLong(id++));
        peopleDocument.setPeopleId(resultSet.getLong(id++));
        peopleDocument.setDocumentName(resultSet.getString(id++));
        peopleDocument.setDocumentPath(resultSet.getString(id++));
        peopleDocument.setNotes(resultSet.getString(id++));
        peopleDocument.setCreateBy(resultSet.getString(id++));
        peopleDocument.setDateCreated(resultSet.getString(id++));
        return peopleDocument;
    }
}
