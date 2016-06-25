package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.company.CompanyTag;

public class CompanyTagExtractor implements ResultSetExtractor {

    public CompanyTag extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CompanyTag companyTag = new CompanyTag();
        int id = 1;
        companyTag.setId(resultSet.getLong(id++));
        companyTag.setCompanyId(resultSet.getLong(id++));
        companyTag.setIndustryId(resultSet.getLong(id++));
        companyTag.setLocationId(resultSet.getLong(id++));
        companyTag.setPositionFunId(resultSet.getLong(id++));
        companyTag.setPositionLevelId(resultSet.getLong(id++));
        companyTag.setLanguageId(resultSet.getLong(id++));
        return companyTag;
    }
}
