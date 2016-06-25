package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.company.CompanyProfile;

public class CompanyProfileExtractor implements ResultSetExtractor {

    public CompanyProfile extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CompanyProfile companyProfile = new CompanyProfile();
        int id = 1;
        companyProfile.setId(resultSet.getLong(id++));
        companyProfile.setCompanyId(resultSet.getLong(id++));
        companyProfile.setContent(resultSet.getString(id++));
        return companyProfile;
    }
}
