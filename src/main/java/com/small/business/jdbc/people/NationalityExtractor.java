package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.Nationality;

public class NationalityExtractor implements ResultSetExtractor {

    public Nationality extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        Nationality nationality = new Nationality();
        int id = 1;
        nationality.setId(resultSet.getLong(id++));
        nationality.setName(resultSet.getString(id++));

        return nationality;
    }
}
