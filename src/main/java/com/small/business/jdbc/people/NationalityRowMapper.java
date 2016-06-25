package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.Nationality;

public class NationalityRowMapper implements RowMapper {

    public Nationality mapRow(ResultSet resultSet, int line) throws SQLException {

        NationalityExtractor userExtractor = new NationalityExtractor();
        return userExtractor.extractData(resultSet);
    }

}