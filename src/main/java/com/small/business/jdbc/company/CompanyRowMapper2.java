package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.company.Company;

public class CompanyRowMapper2 implements RowMapper {

    public Company mapRow(ResultSet resultSet, int line) throws SQLException {

        CompanyExtractor2 userExtractor = new CompanyExtractor2();
        return userExtractor.extractData(resultSet);
    }

}