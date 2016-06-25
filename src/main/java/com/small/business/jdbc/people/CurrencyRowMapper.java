package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.Currency;

public class CurrencyRowMapper implements RowMapper {

    public Currency mapRow(ResultSet resultSet, int line) throws SQLException {

        CurrencyExtractor userExtractor = new CurrencyExtractor();
        return userExtractor.extractData(resultSet);
    }

}