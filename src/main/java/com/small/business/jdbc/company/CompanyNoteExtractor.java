package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.company.CompanyNote;

public class CompanyNoteExtractor implements ResultSetExtractor {

    public CompanyNote extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CompanyNote companyNote = new CompanyNote();
        int id = 1;
        companyNote.setId(resultSet.getLong(id++));
        companyNote.setCompanyId(resultSet.getLong(id++));
        companyNote.setUserId(resultSet.getLong(id++));
        companyNote.setUserName(resultSet.getString(id++));
        companyNote.setTitle(resultSet.getString(id++));
        companyNote.setNotes(resultSet.getString(id++));
        companyNote.setDateCreated(resultSet.getString(id++));
        return companyNote;
    }
}
