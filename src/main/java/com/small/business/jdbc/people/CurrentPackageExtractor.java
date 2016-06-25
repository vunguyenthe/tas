package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.CurrentPackage;

public class CurrentPackageExtractor implements ResultSetExtractor {

    public CurrentPackage extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CurrentPackage currentPackage = new CurrentPackage();
        int id = 1;
        currentPackage.setId(resultSet.getLong(id++));
        currentPackage.setPackageName(resultSet.getString(id++));
        currentPackage.setPeopleId(resultSet.getLong(id++));
        currentPackage.setTotal(resultSet.getString(id++));
        currentPackage.setCurrencyId(resultSet.getLong(id++));
        currentPackage.setPeriod(resultSet.getString(id++));
        currentPackage.setNotes(resultSet.getString(id++));
        return currentPackage;
    }
}
