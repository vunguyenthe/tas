package com.small.business.jdbc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.assignment.AssignmentNotepad;

public class AssignmentNotepadRowMapper implements RowMapper {

    public AssignmentNotepad mapRow(ResultSet resultSet, int line) throws SQLException {

        AssignmentNotepadExtractor userExtractor = new AssignmentNotepadExtractor();
        return userExtractor.extractData(resultSet);
    }

}