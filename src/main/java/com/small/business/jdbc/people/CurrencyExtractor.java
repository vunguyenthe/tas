package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.Currency;

public class CurrencyExtractor implements ResultSetExtractor {

    public Currency extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        Currency currency = new Currency();
        int id = 1;
        currency.setId(resultSet.getLong(id++));
        currency.setName(resultSet.getString(id++));

        return currency;
    }
}
