package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.CurrentBenefitRowMapper;
import com.small.business.model.people.CurrentBenefit;

public class CurrentBenefitDaoImpl implements CurrentBenefitDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CurrentBenefitDaoImpl.class);

    public List<CurrentBenefit> getAllCurrentBenefit() {

        List<CurrentBenefit> currentBenefitList = new ArrayList();

        String sql = "select * from CurrentBenefit";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currentBenefitList = jdbcTemplate.query(sql, new CurrentBenefitRowMapper());
        return currentBenefitList;
    }

    public List<CurrentBenefit> getCurrentBenefitByPeopleId(Long peopleId) {

        List<CurrentBenefit> currentBenefitList = new ArrayList<CurrentBenefit>();
        String sql = "select * from CurrentBenefit where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currentBenefitList = jdbcTemplate.query(sql, new CurrentBenefitRowMapper());
        return currentBenefitList;
    }

    public CurrentBenefit getCurrentBenefitById(Long id) {

        CurrentBenefit assignment = new CurrentBenefit();
        List<CurrentBenefit> currentBenefitList = new ArrayList<CurrentBenefit>();
        String sql = "select * from CurrentBenefit where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currentBenefitList = jdbcTemplate.query(sql, new CurrentBenefitRowMapper());
        if (currentBenefitList.size() > 0) {
            return currentBenefitList.get(0);
        }
        return assignment;
    }

    public boolean addCurrentBenefit(CurrentBenefit currentBenefit) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO CurrentBenefit "
                    + "(peopleId, benefit) "
                    + " VALUES (?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            currentBenefit.getPeopleId(),
                            currentBenefit.getBenefit()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addCurrentBenefit got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCurrentBenefitById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from CurrentBenefit where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCurrentBenefitById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from CurrentBenefit";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public boolean updateListCurrentBenefit(List<CurrentBenefit> listCurrentBenefit) {

        boolean ret = true;
        try {
            if (listCurrentBenefit.size() > 0) {
                for (CurrentBenefit obj : listCurrentBenefit) {
                    updateCurrentBenefit(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListCurrentBenefit got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListCurrentBenefit(List<CurrentBenefit> listCurrentBenefit) {

        System.out.println("->addListCurrentBenefit");
        boolean ret = true;
        try {
            if (listCurrentBenefit.size() > 0) {
                for (CurrentBenefit obj : listCurrentBenefit) {
                    addCurrentBenefit(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListCurrentBenefit got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateCurrentBenefit(CurrentBenefit currentBenefit) {

        boolean ret = true;
        try {
            String sql = "update CurrentBenefit set peopleId = ?, benefit =? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("Id = " + currentBenefit.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            currentBenefit.getPeopleId(),
                            currentBenefit.getBenefit(),
                            currentBenefit.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updateCurrentBenefit got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
