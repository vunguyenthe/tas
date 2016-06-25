package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.people.CurrentBenefit;

public class CurrentBenefitRowMapper implements RowMapper {

    public CurrentBenefit mapRow(ResultSet resultSet, int line) throws SQLException {

        CurrentBenefitExtractor userExtractor = new CurrentBenefitExtractor();
        return userExtractor.extractData(resultSet);
    }

}