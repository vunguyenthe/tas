package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.company.CompanyDepartment;

public class CompanyDepartmentExtractor implements ResultSetExtractor {

    public CompanyDepartment extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        CompanyDepartment companyDepartment = new CompanyDepartment();
        int id = 1;
        companyDepartment.setId(resultSet.getLong(id++));
        companyDepartment.setCompanyId(resultSet.getLong(id++));
        companyDepartment.setName(resultSet.getString(id++));
        companyDepartment.setHeadId(resultSet.getLong(id++));
        companyDepartment.setHeadName(resultSet.getString(id++));
        companyDepartment.setLocationId(resultSet.getLong(id++));
        companyDepartment.setLocationName(resultSet.getString(id++));
        return companyDepartment;
    }
}
