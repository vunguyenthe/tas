package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.user.User;

public class UserExtractor implements ResultSetExtractor {

    public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        User user = new User();
        int id = 1;
        user.setId(resultSet.getLong(id++));
        user.setName(resultSet.getString(id++));
        user.setPassword(resultSet.getString(id++));
        user.setRoleId(resultSet.getLong(id++));
        user.setRoleName(resultSet.getString(id++));
        user.setConsultantId(resultSet.getLong(id++));
        user.setConsultantName(resultSet.getString(id++));
        user.setEmail(resultSet.getString(id++));
        user.setEmailPassword(resultSet.getString(id++));
        user.setStmpServer(resultSet.getString(id++));
        user.setPopServer(resultSet.getString(id++));
        user.setImapServer(resultSet.getString(id++));
        return user;
    }
}
