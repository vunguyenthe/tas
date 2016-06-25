package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.company.CompanyLocation;

public class CompanyLocationExtractor implements ResultSetExtractor {

    public CompanyLocation extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CompanyLocation companyLocation = new CompanyLocation();
        int id = 1;
        companyLocation.setId(resultSet.getLong(id++));
        companyLocation.setCompanyId(resultSet.getLong(id++));
        companyLocation.setLocation(resultSet.getString(id++));
        companyLocation.setAddressName(resultSet.getString(id++));
        companyLocation.setAddress(resultSet.getString(id++));
        companyLocation.setPhone(resultSet.getString(id++));
        companyLocation.setFax(resultSet.getString(id++));
        return companyLocation;
    }
}
