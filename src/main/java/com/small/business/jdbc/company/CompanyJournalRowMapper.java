package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.company.CompanyJournal;

public class CompanyJournalRowMapper implements RowMapper {

    public CompanyJournal mapRow(ResultSet resultSet, int line) throws SQLException {

        CompanyJournalExtractor userExtractor = new CompanyJournalExtractor();
        return userExtractor.extractData(resultSet);
    }

}