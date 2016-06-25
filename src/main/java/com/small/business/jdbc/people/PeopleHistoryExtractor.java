package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.PeopleHistory;

public class PeopleHistoryExtractor implements ResultSetExtractor {

    public PeopleHistory extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        PeopleHistory peopleHistory = new PeopleHistory();
        int id = 1;
        peopleHistory.setId(resultSet.getLong(id++));
        peopleHistory.setPeopleId(resultSet.getLong(id++));
        peopleHistory.setJobTitle(resultSet.getString(id++));
        peopleHistory.setCompanyId(resultSet.getLong(id++));
        peopleHistory.setInstitution(resultSet.getString(id++));
        peopleHistory.setYearStarted(resultSet.getLong(id++));
        peopleHistory.setYearEnd(resultSet.getLong(id++));
        peopleHistory.setCompanyName(resultSet.getString(id++));
        return peopleHistory;
    }
}
