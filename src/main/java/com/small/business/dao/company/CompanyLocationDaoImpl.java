package com.small.business.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.company.CompanyLocationRowMapper;
import com.small.business.model.company.CompanyLocation;

public class CompanyLocationDaoImpl implements CompanyLocationDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyLocationDaoImpl.class);

    public List<CompanyLocation> getAllCompanyLocation() {

        List<CompanyLocation> companyLocationList = new ArrayList();

        String sql = "select * from CompanyLocation";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyLocationList = jdbcTemplate.query(sql, new CompanyLocationRowMapper());
        return companyLocationList;
    }

    public CompanyLocation getCompanyLocationById(Long id) {

        CompanyLocation assignment = new CompanyLocation();
        List<CompanyLocation> companyLocationList = new ArrayList<CompanyLocation>();
        String sql = "select * from CompanyLocation where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyLocationList = jdbcTemplate.query(sql, new CompanyLocationRowMapper());
        if (companyLocationList.size() > 0) {
            return companyLocationList.get(0);
        }
        return assignment;
    }

    public boolean addCompanyLocation(CompanyLocation companyLocation) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO CompanyLocation "
                    + "(companyId, location, addressName, address, phone, fax) "
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyLocation.getCompanyId(),
                            companyLocation.getLocation(),
                            companyLocation.getAddressName(),
                            companyLocation.getAddress(),
                            companyLocation.getPhone(),
                            companyLocation.getFax()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addCompanyLocation got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCompanyLocationById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from CompanyLocation where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCompanyLocationById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from CompanyLocation";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateCompanyLocation(CompanyLocation companyLocation) {

        boolean ret = true;
        try {
            String sql = "update CompanyLocation set companyId = ?, location = ?, addressName = ?, address = ?, "
                    + " phone = ?, fax = ?"
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("CompanyLocation Id = " + companyLocation.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyLocation.getCompanyId(),
                            companyLocation.getLocation(),
                            companyLocation.getAddressName(),
                            companyLocation.getAddress(),
                            companyLocation.getPhone(),
                            companyLocation.getFax(),
                            companyLocation.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateCompanyLocation got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListCompanyLocation(List<CompanyLocation> listCompanyLocation) {

        System.out.println("->addListCompanyLocation");
        boolean ret = true;
        try {
            if (listCompanyLocation.size() > 0) {
                for (CompanyLocation obj : listCompanyLocation) {
                    addCompanyLocation(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyLocation got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListCompanyLocation(List<CompanyLocation> listCompanyLocation) {

        boolean ret = true;
        try {
            if (listCompanyLocation.size() > 0) {
                for (CompanyLocation obj : listCompanyLocation) {
                    updateCompanyLocation(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyLocation got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public List<CompanyLocation> getListCompanyLocationByCompanyId(Long companyId) {

        List<CompanyLocation> companyLocationList = new ArrayList<CompanyLocation>();
        String sql = "select * from CompanyLocation where companyId= " + companyId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyLocationList = jdbcTemplate.query(sql, new CompanyLocationRowMapper());
        return companyLocationList;
    }

}
