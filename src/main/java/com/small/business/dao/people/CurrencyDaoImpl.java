package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.CurrencyRowMapper;
import com.small.business.model.people.Currency;

public class CurrencyDaoImpl implements CurrencyDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CurrencyDaoImpl.class);

    public List<Currency> getAllCurrency() {

        List<Currency> currencyList = new ArrayList();

        String sql = "select * from Currency";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currencyList = jdbcTemplate.query(sql, new CurrencyRowMapper());
        return currencyList;
    }

    public Currency getCurrencyById(Long id) {

        Currency assignment = new Currency();
        List<Currency> currencyList = new ArrayList<Currency>();
        String sql = "select * from Currency where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currencyList = jdbcTemplate.query(sql, new CurrencyRowMapper());
        if (currencyList.size() > 0) {
            return currencyList.get(0);
        }
        return assignment;
    }

    public boolean addCurrency(Currency currency) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO Currency "
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
            logger.debug("addCurrency got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCurrencyById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from Currency where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCurrencyById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from Currency";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public boolean updateListCurrency(List<Currency> listCurrency) {

        boolean ret = true;
        try {
            if (listCurrency.size() > 0) {
                for (Currency obj : listCurrency) {
                    updateCurrency(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListCurrency got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListCurrency(List<Currency> listCurrency) {

        System.out.println("->addListCurrency");
        boolean ret = true;
        try {
            if (listCurrency.size() > 0) {
                for (Currency obj : listCurrency) {
                    addCurrency(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListCurrency got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateCurrency(Currency currency) {

        boolean ret = true;
        try {
            String sql = "update Currency set name = ? "
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
            logger.error("updateCurrency got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
