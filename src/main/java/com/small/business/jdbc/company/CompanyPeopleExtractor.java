package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.company.CompanyPeople;

public class CompanyPeopleExtractor implements ResultSetExtractor {

    public CompanyPeople extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CompanyPeople companyPeople = new CompanyPeople();
        int id = 1;
        companyPeople.setId(resultSet.getLong(id++));
        companyPeople.setCompanyId(resultSet.getLong(id++));
        companyPeople.setPeopleId(resultSet.getLong(id++));
        companyPeople.setCompanyName(resultSet.getString(id++));
        companyPeople.setPeopleName(resultSet.getString(id++));
        return companyPeople;
    }
}
