package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.PeopleDetail;

public class PeopleDetailExtractor implements ResultSetExtractor {

    public PeopleDetail extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        PeopleDetail peopleDetail = new PeopleDetail();
        int id = 1;
        peopleDetail.setId(resultSet.getLong(id++));
        peopleDetail.setPeopleId(resultSet.getLong(id++));
        peopleDetail.setDateOfBirth(resultSet.getString(id++));
        peopleDetail.setAge(resultSet.getLong(id++));
        peopleDetail.setGender(resultSet.getString(id++));
        peopleDetail.setMatialStatus(resultSet.getString(id++));
        peopleDetail.setNationalityId(resultSet.getLong(id++));
        peopleDetail.setTravel(resultSet.getBoolean(id++));
        peopleDetail.setRelocate(resultSet.getBoolean(id++));
        peopleDetail.setPayrollNo(resultSet.getString(id++));
        peopleDetail.setNiNo(resultSet.getString(id++));
        peopleDetail.setPassPortNo(resultSet.getString(id++));
        peopleDetail.setVisaStatus(resultSet.getString(id++));
        peopleDetail.setNoticePeriod(resultSet.getString(id++));
        peopleDetail.setAvailableDate(resultSet.getString(id++));
        return peopleDetail;
    }
}
