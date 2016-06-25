package com.small.business.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.company.CompanyPeopleRowMapper;
import com.small.business.model.company.CompanyPeople;

public class CompanyPeopleDaoImpl implements CompanyPeopleDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyPeopleDaoImpl.class);

    public List<CompanyPeople> getAllCompanyPeople() {

        List<CompanyPeople> companyPeopleList = new ArrayList();

        String sql = "select * from CompanyPeople";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyPeopleList = jdbcTemplate.query(sql, new CompanyPeopleRowMapper());
        return companyPeopleList;
    }

    public CompanyPeople getCompanyPeopleById(Long id) {

        CompanyPeople assignment = new CompanyPeople();
        List<CompanyPeople> companyPeopleList = new ArrayList<CompanyPeople>();
        String sql = "select * from CompanyPeople where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyPeopleList = jdbcTemplate.query(sql, new CompanyPeopleRowMapper());
        if (companyPeopleList.size() > 0) {
            return companyPeopleList.get(0);
        }
        return assignment;
    }

    public boolean addCompanyPeople(CompanyPeople companyPeople) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO CompanyPeople "
                    + "(companyId, peopleId, companyName, peopleName) "
                    + " VALUES (?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyPeople.getCompanyId(),
                            companyPeople.getPeopleId(),
                            companyPeople.getCompanyName(),
                            companyPeople.getPeopleName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addCompanyPeople got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCompanyPeopleById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from CompanyPeople where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCompanyPeopleById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from CompanyPeople";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateCompanyPeople(CompanyPeople companyPeople) {

        boolean ret = true;
        try {
            String sql = "update CompanyPeople set companyId = ?, peopleId = ?, companyName = ?, peopleName = ?"
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("CompanyPeople Id = " + companyPeople.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyPeople.getCompanyId(),
                            companyPeople.getPeopleId(),
                            companyPeople.getCompanyName(),
                            companyPeople.getPeopleName(),
                            companyPeople.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateCompanyPeople got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListCompanyPeople(List<CompanyPeople> listCompanyPeople) {

        System.out.println("->addListCompanyPeople");
        boolean ret = true;
        try {
            if (listCompanyPeople.size() > 0) {
                for (CompanyPeople obj : listCompanyPeople) {
                    addCompanyPeople(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyPeople got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListCompanyPeople(List<CompanyPeople> listCompanyPeople) {

        boolean ret = true;
        try {
            if (listCompanyPeople.size() > 0) {
                for (CompanyPeople obj : listCompanyPeople) {
                    updateCompanyPeople(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateListCompanyPeople got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public List<CompanyPeople> getListCompanyPeopleByCompanyId(Long companyId) {

        List<CompanyPeople> companyPeopleList = new ArrayList<CompanyPeople>();
        String sql = "select * from CompanyPeople where companyId= " + companyId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyPeopleList = jdbcTemplate.query(sql, new CompanyPeopleRowMapper());
        return companyPeopleList;
    }
}
