package com.small.business.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.company.CompanyDepartmentRowMapper;
import com.small.business.model.company.CompanyDepartment;

public class CompanyDepartmentDaoImpl implements CompanyDepartmentDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyDepartmentDaoImpl.class);

    public List<CompanyDepartment> getAllCompanyDepartment() {

        List<CompanyDepartment> companyDepartmentList = new ArrayList();

        String sql = "select * from CompanyDepartment";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyDepartmentList = jdbcTemplate.query(sql, new CompanyDepartmentRowMapper());
        return companyDepartmentList;
    }

    public CompanyDepartment getCompanyDepartmentById(Long id) {

        CompanyDepartment assignment = new CompanyDepartment();
        List<CompanyDepartment> companyDepartmentList = new ArrayList<CompanyDepartment>();
        String sql = "select * from CompanyDepartment where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyDepartmentList = jdbcTemplate.query(sql, new CompanyDepartmentRowMapper());
        if (companyDepartmentList.size() > 0) {
            return companyDepartmentList.get(0);
        }
        return assignment;
    }

    public boolean addCompanyDepartment(CompanyDepartment companyDepartment) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO CompanyDepartment "
                    + "(companyId, name, headId, headName, locationId, locationName) "
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyDepartment.getCompanyId(),
                            companyDepartment.getName(),
                            companyDepartment.getHeadId(),
                            companyDepartment.getHeadName(),
                            companyDepartment.getLocationId(),
                            companyDepartment.getLocationName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addCompanyDepartment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCompanyDepartmentById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from CompanyDepartment where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCompanyDepartmentById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from CompanyDepartment";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateCompanyDepartment(CompanyDepartment companyDepartment) {

        boolean ret = true;
        try {
            String sql = "update CompanyDepartment set companyId = ?, name = ?, headId = ?, headName = ?,"
                    + " locationId = ?, locationName = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("CompanyDepartment Id = " + companyDepartment.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyDepartment.getCompanyId(),
                            companyDepartment.getName(),
                            companyDepartment.getHeadId(),
                            companyDepartment.getHeadName(),
                            companyDepartment.getLocationId(),
                            companyDepartment.getLocationName(),
                            companyDepartment.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateCompanyDepartment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListCompanyDepartment(List<CompanyDepartment> listCompanyDepartment) {

        System.out.println("->addListCompanyDepartment");
        boolean ret = true;
        try {
            if (listCompanyDepartment.size() > 0) {
                for (CompanyDepartment obj : listCompanyDepartment) {
                    addCompanyDepartment(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyDepartment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListCompanyDepartment(List<CompanyDepartment> listCompanyDepartment) {

        boolean ret = true;
        try {
            if (listCompanyDepartment.size() > 0) {
                for (CompanyDepartment obj : listCompanyDepartment) {
                    updateCompanyDepartment(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyDepartment got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public List<CompanyDepartment> getListCompanyDepartmentByCompanyId(Long companyId) {

        List<CompanyDepartment> companyDepartmentList = new ArrayList<CompanyDepartment>();
        String sql = "select * from CompanyDepartment where companyId= " + companyId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyDepartmentList = jdbcTemplate.query(sql, new CompanyDepartmentRowMapper());
        return companyDepartmentList;
    }

}
