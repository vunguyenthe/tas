package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.People;

public class PeopleExtractor implements ResultSetExtractor {

    public People extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        People people = new People();

        int id = 1;
        people.setId(resultSet.getLong(id++));
        people.setFullName(resultSet.getString(id++));
        people.setEmail(resultSet.getString(id++));
        people.setPhoneNumber(resultSet.getString(id++));
        people.setMobilePhone(resultSet.getString(id++));
        people.setCompanyId(resultSet.getLong(id++));
        people.setJobTitle(resultSet.getString(id++));
        people.setBusinessPhone(resultSet.getString(id++));
        people.setBusinessFax(resultSet.getString(id++));
        people.setLinkedIn(resultSet.getString(id++));
        people.setAddress(resultSet.getString(id++));
        people.setCv(resultSet.getString(id++));
        people.setWebLink(resultSet.getString(id++));
        people.setSkypeID(resultSet.getString(id++));
        people.setClient(resultSet.getBoolean(id++));
        people.setCandidate(resultSet.getBoolean(id++));
        people.setPartner(resultSet.getBoolean(id++));
        people.setContact(resultSet.getBoolean(id++));
        people.setDoNotMass(resultSet.getBoolean(id++));
        people.setVip(resultSet.getBoolean(id++));
        people.setSupplier(resultSet.getBoolean(id++));
        people.setPhoto(resultSet.getString(id++));
        people.setCreateBy(resultSet.getString(id++));
        people.setCompanyName(resultSet.getString(id++));
        return people;
    }
}
