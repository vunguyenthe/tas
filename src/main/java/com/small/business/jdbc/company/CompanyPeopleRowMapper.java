package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.company.CompanyPeople;

public class CompanyPeopleRowMapper implements RowMapper {

    public CompanyPeople mapRow(ResultSet resultSet, int line) throws SQLException {

        CompanyPeopleExtractor userExtractor = new CompanyPeopleExtractor();
        return userExtractor.extractData(resultSet);
    }

}