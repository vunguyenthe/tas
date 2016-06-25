package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.company.CompanyJournal;

public class CompanyJournalExtractor implements ResultSetExtractor {

    public CompanyJournal extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CompanyJournal companyJournal = new CompanyJournal();
        int id = 1;
        companyJournal.setId(resultSet.getLong(id++));
        companyJournal.setCompanyId(resultSet.getLong(id++));
        companyJournal.setJournaType(resultSet.getLong(id++));
        companyJournal.setUserId(resultSet.getLong(id++));
        companyJournal.setNotes(resultSet.getString(id++));
        companyJournal.setJournalName(resultSet.getString(id++));
        companyJournal.setUserName(resultSet.getString(id++));
        companyJournal.setDateCreated(resultSet.getString(id++));
        return companyJournal;
    }
}
