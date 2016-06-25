package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.CurrentBenefit;

public class CurrentBenefitExtractor implements ResultSetExtractor {

    public CurrentBenefit extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CurrentBenefit currentBenefit = new CurrentBenefit();
        int id = 1;
        currentBenefit.setId(resultSet.getLong(id++));
        currentBenefit.setPeopleId(resultSet.getLong(id++));
        currentBenefit.setBenefit(resultSet.getString(id++));
        return currentBenefit;
    }
}
