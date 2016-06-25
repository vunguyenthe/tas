package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.company.CompanyNotepad;

public class CompanyNotepadRowMapper implements RowMapper {

    public CompanyNotepad mapRow(ResultSet resultSet, int line) throws SQLException {

        CompanyNotepadExtractor userExtractor = new CompanyNotepadExtractor();
        return userExtractor.extractData(resultSet);
    }

}