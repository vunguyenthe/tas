package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.assignment.AssignmentNotepad;

public class AssignmentNotepadExtractor implements ResultSetExtractor {

    public AssignmentNotepad extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        AssignmentNotepad assignmentNotepad = new AssignmentNotepad();
        int id = 1;
        assignmentNotepad.setId(resultSet.getLong(id++));
        assignmentNotepad.setAssignmentId(resultSet.getLong(id++));
        assignmentNotepad.setContent(resultSet.getString(id++));
        return assignmentNotepad;
    }
}
