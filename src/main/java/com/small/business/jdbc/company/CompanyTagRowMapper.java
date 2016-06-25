package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.company.CompanyTag;

public class CompanyTagRowMapper implements RowMapper {

    public CompanyTag mapRow(ResultSet resultSet, int line) throws SQLException {

        CompanyTagExtractor companyTagExtractor = new CompanyTagExtractor();
        return companyTagExtractor.extractData(resultSet);
    }

}