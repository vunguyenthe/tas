package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.PeopleTag;

public class PeopleTagExtractor implements ResultSetExtractor {

    public PeopleTag extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        PeopleTag peopleTag = new PeopleTag();
        int id = 1;
        peopleTag.setId(resultSet.getLong(id++));
        peopleTag.setPeopleId(resultSet.getLong(id++));
        peopleTag.setIndustryId(resultSet.getLong(id++));
        peopleTag.setLocationId(resultSet.getLong(id++));
        peopleTag.setPositionFunId(resultSet.getLong(id++));
        peopleTag.setPositionLevelId(resultSet.getLong(id++));
        peopleTag.setLanguageId(resultSet.getLong(id++));
        return peopleTag;
    }
}
