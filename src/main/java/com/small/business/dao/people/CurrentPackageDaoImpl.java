package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.CurrentPackageRowMapper;
import com.small.business.model.people.CurrentPackage;

public class CurrentPackageDaoImpl implements CurrentPackageDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CurrentPackageDaoImpl.class);

    public List<CurrentPackage> getAllCurrentPackage() {

        List<CurrentPackage> currentPackageList = new ArrayList();

        String sql = "select * from CurrentPackage";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currentPackageList = jdbcTemplate.query(sql, new CurrentPackageRowMapper());
        return currentPackageList;
    }

    public List<CurrentPackage> getCurrentPackageByPeopleId(Long peopleId) {

        List<CurrentPackage> currentPackageList = new ArrayList<CurrentPackage>();
        String sql = "select * from CurrentPackage where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currentPackageList = jdbcTemplate.query(sql, new CurrentPackageRowMapper());
        return currentPackageList;
    }

    public CurrentPackage getCurrentPackageById(Long id) {

        CurrentPackage assignment = new CurrentPackage();
        List<CurrentPackage> currentPackageList = new ArrayList<CurrentPackage>();
        String sql = "select * from CurrentPackage where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        currentPackageList = jdbcTemplate.query(sql, new CurrentPackageRowMapper());
        if (currentPackageList.size() > 0) {
            return currentPackageList.get(0);
        }
        return assignment;
    }

    public boolean addCurrentPackage(CurrentPackage currentPackage) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO CurrentPackage "
                    + "(packageName, peopleId, total, currencyId, period, notes) "
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            currentPackage.getPackageName(),
                            currentPackage.getPeopleId(),
                            currentPackage.getTotal(),
                            currentPackage.getCurrencyId(),
                            currentPackage.getPeriod(),
                            currentPackage.getNotes()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addCurrentPackage got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCurrentPackageById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from CurrentPackage where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCurrentPackageById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from CurrentPackage";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public boolean updateListCurrentPackage(List<CurrentPackage> listCurrentPackage) {

        boolean ret = true;
        try {
            if (listCurrentPackage.size() > 0) {
                for (CurrentPackage obj : listCurrentPackage) {
                    updateCurrentPackage(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListCurrentPackage got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListCurrentPackage(List<CurrentPackage> listCurrentPackage) {

        System.out.println("->addListCurrentPackage");
        boolean ret = true;
        try {
            if (listCurrentPackage.size() > 0) {
                for (CurrentPackage obj : listCurrentPackage) {
                    addCurrentPackage(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListCurrentPackage got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateCurrentPackage(CurrentPackage currentPackage) {

        boolean ret = true;
        try {
            String sql = "update CurrentPackage set packageName = ?, peopleId = ?, total = ?"
                    + ", currencyId = ?, period =? , notes =? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("Id = " + currentPackage.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            currentPackage.getPackageName(),
                            currentPackage.getPeopleId(),
                            currentPackage.getTotal(),
                            currentPackage.getCurrencyId(),
                            currentPackage.getPeriod(),
                            currentPackage.getNotes(),
                            currentPackage.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updateCurrentPackage got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
