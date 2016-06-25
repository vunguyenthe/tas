package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.NationalityRowMapper;
import com.small.business.model.people.Nationality;

public class NationalityDaoImpl implements NationalityDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(NationalityDaoImpl.class);

    public List<Nationality> getAllNationality() {

        List<Nationality> currencyList = new ArrayList();

        String sql = "select * from Nationality";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currencyList = jdbcTemplate.query(sql, new NationalityRowMapper());
        return currencyList;
    }

    public Nationality getNationalityById(Long id) {

        Nationality assignment = new Nationality();
        List<Nationality> currencyList = new ArrayList<Nationality>();
        String sql = "select * from Nationality where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currencyList = jdbcTemplate.query(sql, new NationalityRowMapper());
        if (currencyList.size() > 0) {
            return currencyList.get(0);
        }
        return assignment;
    }

    public boolean addNationality(Nationality currency) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO Nationality "
                    + "( name) "
                    + " VALUES (?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            currency.getName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addNationality got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteNationalityById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from Nationality where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteNationalityById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from Nationality";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public boolean updateListNationality(List<Nationality> listNationality) {

        boolean ret = true;
        try {
            if (listNationality.size() > 0) {
                for (Nationality obj : listNationality) {
                    updateNationality(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListNationality got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListNationality(List<Nationality> listNationality) {

        System.out.println("->addListNationality");
        boolean ret = true;
        try {
            if (listNationality.size() > 0) {
                for (Nationality obj : listNationality) {
                    addNationality(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListNationality got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateNationality(Nationality currency) {

        boolean ret = true;
        try {
            String sql = "update Nationality set name = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("Id = " + currency.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            currency.getName(),
                            currency.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updateNationality got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
