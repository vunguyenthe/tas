package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.company.Company;

public class CompanyExtractor2 implements ResultSetExtractor {

    public Company extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        Company company = new Company();
        int id = 1;
        company.setId(resultSet.getLong(id++));
        company.setName(resultSet.getString(id++));
        company.setPhoneNumber(resultSet.getString(id++));
        company.setFax(resultSet.getString(id++));
        company.setPrimaryContact(resultSet.getLong(id++));
        company.setWebLink(resultSet.getString(id++));
        company.setLinkedInLink(resultSet.getString(id++));
        company.setClient(resultSet.getBoolean(id++));
        company.setPartner(resultSet.getBoolean(id++));
        company.setProspect(resultSet.getBoolean(id++));
        company.setSupplier(resultSet.getBoolean(id++));
        company.setDoNotContact(resultSet.getBoolean(id++));
        company.setDoNotMass(resultSet.getBoolean(id++));
        company.setEmail(resultSet.getString(id++));
        id++;
        company.setPrimaryContactName(resultSet.getString(id++));
        System.out.print(company.getPrimaryContactName());
        return company;
    }
}
