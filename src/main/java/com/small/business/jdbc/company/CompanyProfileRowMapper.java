package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.company.CompanyProfile;

public class CompanyProfileRowMapper implements RowMapper {

    public CompanyProfile mapRow(ResultSet resultSet, int line) throws SQLException {

        CompanyProfileExtractor userExtractor = new CompanyProfileExtractor();
        return userExtractor.extractData(resultSet);
    }

}