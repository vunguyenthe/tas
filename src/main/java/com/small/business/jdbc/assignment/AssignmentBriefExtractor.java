package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.assignment.AssignmentBrief;

public class AssignmentBriefExtractor implements ResultSetExtractor {

    public AssignmentBrief extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        AssignmentBrief assignment = new AssignmentBrief();
        int id = 1;
        assignment.setId(resultSet.getLong(id++));
        assignment.setAssignmentId(resultSet.getLong(id++));
        assignment.setContent(resultSet.getString(id++));
        return assignment;
    }
}
