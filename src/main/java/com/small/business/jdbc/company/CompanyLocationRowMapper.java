package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.company.CompanyLocation;

public class CompanyLocationRowMapper implements RowMapper {

    public CompanyLocation mapRow(ResultSet resultSet, int line) throws SQLException {

        CompanyLocationExtractor userExtractor = new CompanyLocationExtractor();
        return userExtractor.extractData(resultSet);
    }

}