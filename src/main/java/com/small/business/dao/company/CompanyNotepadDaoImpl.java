package com.small.business.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.company.CompanyNotepadRowMapper;
import com.small.business.model.company.CompanyNotepad;

public class CompanyNotepadDaoImpl implements CompanyNotepadDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyNotepadDaoImpl.class);

    public List<CompanyNotepad> getAllCompanyNotepad() {

        List<CompanyNotepad> companyBriefList = new ArrayList();

        String sql = "select * from companynotepad";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyBriefList = jdbcTemplate.query(sql, new CompanyNotepadRowMapper());
        return companyBriefList;
    }

    public CompanyNotepad getCompanyNotepadById(Long id) {

        CompanyNotepad company = new CompanyNotepad();
        List<CompanyNotepad> companyNodepadList = new ArrayList<CompanyNotepad>();
        String sql = "select * from companynotepad where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyNodepadList = jdbcTemplate.query(sql, new CompanyNotepadRowMapper());
        if (companyNodepadList.size() > 0) {
            return companyNodepadList.get(0);
        }
        return company;
    }

    public boolean addCompanyNotepad(CompanyNotepad companyBrief) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO companynotepad "
                    + "(companyId, content) "
                    + " VALUES (?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyBrief.getCompanyId(),
                            companyBrief.getContent()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("companynodepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCompanyNotepadById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from companynotepad where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCompanyNotepadById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from companynotepad";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateCompanyNotepad(CompanyNotepad companyBrief) {

        boolean ret = true;
        try {
            String sql = "update companynotepad set companyId = ?, content = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("CompanyNotepad Id = " + companyBrief.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyBrief.getCompanyId(),
                            companyBrief.getContent(),
                            companyBrief.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateCompanyNotepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListCompanyNotepad(List<CompanyNotepad> listCompanyNotepad) {

        System.out.println("->addListCompanyNotepad");
        boolean ret = true;
        try {
            if (listCompanyNotepad.size() > 0) {
                for (CompanyNotepad obj : listCompanyNotepad) {
                    addCompanyNotepad(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyNotepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListCompanyNotepad(List<CompanyNotepad> listCompanyNotepad) {

        boolean ret = true;
        try {
            if (listCompanyNotepad.size() > 0) {
                for (CompanyNotepad obj : listCompanyNotepad) {
                    updateCompanyNotepad(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyNotepad got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public CompanyNotepad getCompanyNotepadByCompanyId(Long companyId) {

        CompanyNotepad company = new CompanyNotepad();
        List<CompanyNotepad> companyNodepadList = new ArrayList<CompanyNotepad>();
        String sql = "select * from companynotepad where companyId= " + companyId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyNodepadList = jdbcTemplate.query(sql, new CompanyNotepadRowMapper());
        if (companyNodepadList.size() > 0) {
            return companyNodepadList.get(0);
        }
        return company;
    }

}
