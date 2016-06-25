package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.CurrentPackage;

public class CurrentPackageRowMapper implements RowMapper {

    public CurrentPackage mapRow(ResultSet resultSet, int line) throws SQLException {

        CurrentPackageExtractor userExtractor = new CurrentPackageExtractor();
        return userExtractor.extractData(resultSet);
    }

}