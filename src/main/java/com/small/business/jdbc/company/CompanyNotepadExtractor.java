package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.company.CompanyNotepad;

public class CompanyNotepadExtractor implements ResultSetExtractor {

    public CompanyNotepad extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CompanyNotepad companyNotepad = new CompanyNotepad();
        int id = 1;
        companyNotepad.setId(resultSet.getLong(id++));
        companyNotepad.setCompanyId(resultSet.getLong(id++));
        companyNotepad.setContent(resultSet.getString(id++));
        return companyNotepad;
    }
}
