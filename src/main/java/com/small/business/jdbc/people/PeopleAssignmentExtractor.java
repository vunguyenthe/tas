package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.PeopleAssignment;

public class PeopleAssignmentExtractor implements ResultSetExtractor {

    public PeopleAssignment extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        PeopleAssignment peopleAssignment = new PeopleAssignment();
        int id = 1;
        peopleAssignment.setId(resultSet.getLong(id++));
        peopleAssignment.setPeopleId(resultSet.getLong(id++));
        peopleAssignment.setAssignmentId(resultSet.getLong(id++));
        peopleAssignment.setCompanyId(resultSet.getLong(id++));
        peopleAssignment.setAssignmentName(resultSet.getString(id++));
        peopleAssignment.setCompanyName(resultSet.getString(id++));
        return peopleAssignment;
    }
}
