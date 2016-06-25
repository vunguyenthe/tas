package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.company.CompanyNote;

public class CompanyNoteRowMapper implements RowMapper {

    public CompanyNote mapRow(ResultSet resultSet, int line) throws SQLException {

        CompanyNoteExtractor userExtractor = new CompanyNoteExtractor();
        return userExtractor.extractData(resultSet);
    }

}