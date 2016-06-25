package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.PeopleEducation;

public class PeopleEducationExtractor implements ResultSetExtractor {

    public PeopleEducation extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        PeopleEducation peopleEducation = new PeopleEducation();
        int id = 1;
        peopleEducation.setId(resultSet.getLong(id++));
        peopleEducation.setPeopleId(resultSet.getLong(id++));
        peopleEducation.setJournaType(resultSet.getLong(id++));
        peopleEducation.setQualification(resultSet.getString(id++));
        peopleEducation.setInstitution(resultSet.getString(id++));
        peopleEducation.setYearStarted(resultSet.getLong(id++));
        peopleEducation.setYearEnd(resultSet.getLong(id++));
        peopleEducation.setJournalName(resultSet.getString(id++));
        return peopleEducation;
    }
}
