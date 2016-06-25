package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.assignment.Assignment;

public class AssignmentExtractor implements ResultSetExtractor {

    public Assignment extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        Assignment assignment = new Assignment();
        int id = 1;
        assignment.setId(resultSet.getLong(id++));
        assignment.setAssignment(resultSet.getString(id++));
        assignment.setLanguage(resultSet.getString(id++));
        assignment.setIndustry(resultSet.getString(id++));
        assignment.setAssignmenetSt(resultSet.getString(id++));
        assignment.setEngagement(resultSet.getString(id++));
        assignment.setClientId(resultSet.getLong(id++));
        assignment.setLocation(resultSet.getString(id++));
        assignment.setDepartment(resultSet.getString(id++));
        assignment.setPrimaryContactId(resultSet.getLong(id++));
        assignment.setOtherContactId(resultSet.getLong(id++));
        assignment.setSignedContract(resultSet.getString(id++));
        assignment.setClientName(resultSet.getString(id++));
        assignment.setPrimaryContactName(resultSet.getString(id++));
        assignment.setOtherContactName(resultSet.getString(id++));
        return assignment;
    }
}
