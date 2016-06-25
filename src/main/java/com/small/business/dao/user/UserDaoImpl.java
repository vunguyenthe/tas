package com.small.business.dao.user;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.user.UserRowMapper;
import com.small.business.model.user.User;

public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory
            .getLogger(UserDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<User> getAllUser() {

        // TODO Auto-generated method stub
        List userList = new ArrayList();

        String sql = "select * from User";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new UserRowMapper());
        return userList;
    }

    public User getUserById(Long id) {

        User user = new User();
        List<User> userList = new ArrayList<User>();
        String sql = "select * from User where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new UserRowMapper());
        if (userList.size() > 0) {
            return userList.get(0);
        }
        return user;
    }

    public boolean addUser(User user) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO User "
                    + "(name, password, roleId, roleName,"
                    + "consultantId, consultantName, email,"
                    + "emailPassword, stmpServer, popServer, imapServer) "
                    + "VALUES (?, ?, ?, ?,"
                    + "?, ?, ?, ? , ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            user.getName(),
                            user.getPassword(),
                            user.getRoleId(),
                            user.getRoleName(),
                            user.getConsultantId(),
                            user.getConsultantName(),
                            user.getEmail(),
                            user.getEmailPassword(),
                            user.getStmpServer(),
                            user.getPopServer(),
                            user.getImapServer()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addUser got error: " + ex.getMessage());
        }
        return ret;
    }

    public String encodeMD5(String p_str) {

        String ret = DigestUtils.md5Hex(p_str);
        return p_str;
    }

    public boolean validateUser(String user, String password) {

        boolean ret = false;

        try {
            if (user == null || user == "" || user.length() == 0)
                return false;
            if (password == null || password == "" || password.length() == 0)
                return false;

            List<User> userList = new ArrayList<User>();
            String sql = "select * from user where name = '" + user + "' and password = '" + password + "'";
            // System.out.println("sql->" + sql);
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            userList = jdbcTemplate.query(sql, new UserRowMapper());
            if (userList.size() > 0) {
                ret = true;
            }
            System.out.println("ret->" + ret);
            return ret;
        } catch (Exception ex) {
            logger.debug("validateUser got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteUserById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from User where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            logger.debug("deleteUserById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from User";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateUser(User user) {

        boolean ret = true;
        try {
            String sql = "update User set name = ?, password = ?, roleId = ?, "
                    + " roleName = ?, consultantId = ?, consultantName = ?, email = ?, "
                    + " emailPassword = ?, stmpServer = ?, popServer = ?, imapServer = ?"
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            System.out.println("companyId = " + user.getId());
            System.out.println("company() = " + user.toString());
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            user.getName(),
                            user.getPassword(),
                            user.getRoleId(),
                            user.getRoleName(),
                            user.getConsultantId(),
                            user.getConsultantName(),
                            user.getEmail(),
                            user.getEmailPassword(),
                            user.getStmpServer(),
                            user.getPopServer(),
                            user.getImapServer(),
                            user.getId()
                    });
        } catch (Exception ex) {
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;

    }

}
