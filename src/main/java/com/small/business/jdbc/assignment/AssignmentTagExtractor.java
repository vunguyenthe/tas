package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.assignment.AssignmentTag;

public class AssignmentTagExtractor implements ResultSetExtractor {

    public AssignmentTag extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        AssignmentTag assignmentTag = new AssignmentTag();
        int id = 1;
        assignmentTag.setId(resultSet.getLong(id++));
        assignmentTag.setAssignmentId(resultSet.getLong(id++));
        assignmentTag.setIndustryId(resultSet.getLong(id++));
        assignmentTag.setLocationId(resultSet.getLong(id++));
        assignmentTag.setPositionFunId(resultSet.getLong(id++));
        assignmentTag.setPositionLevelId(resultSet.getLong(id++));
        assignmentTag.setLanguageId(resultSet.getLong(id++));
        return assignmentTag;
    }
}
