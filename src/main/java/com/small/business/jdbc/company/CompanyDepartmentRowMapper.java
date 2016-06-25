package com.small.business.jdbc.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.company.CompanyDepartment;

public class CompanyDepartmentRowMapper implements RowMapper {

    public CompanyDepartment mapRow(ResultSet resultSet, int line) throws SQLException {

        CompanyDepartmentExtractor userExtractor = new CompanyDepartmentExtractor();
        return userExtractor.extractData(resultSet);
    }

}