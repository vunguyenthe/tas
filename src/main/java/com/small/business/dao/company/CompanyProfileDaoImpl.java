package com.small.business.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.company.CompanyProfileRowMapper;
import com.small.business.model.company.CompanyProfile;

public class CompanyProfileDaoImpl implements CompanyProfileDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyProfileDaoImpl.class);

    public List<CompanyProfile> getAllCompanyProfile() {

        List<CompanyProfile> companyBriefList = new ArrayList();

        String sql = "select * from companyprofile";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyBriefList = jdbcTemplate.query(sql, new CompanyProfileRowMapper());
        return companyBriefList;
    }

    public CompanyProfile getCompanyProfileById(Long id) {

        CompanyProfile company = new CompanyProfile();
        List<CompanyProfile> companyProfileList = new ArrayList<CompanyProfile>();
        String sql = "select * from companyprofile where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyProfileList = jdbcTemplate.query(sql, new CompanyProfileRowMapper());
        if (companyProfileList.size() > 0) {
            return companyProfileList.get(0);
        }
        return company;
    }

    public boolean addCompanyProfile(CompanyProfile companyBrief) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO companyprofile "
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

    public boolean deleteCompanyProfileById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from companyprofile where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCompanyProfileById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from companyprofile";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateCompanyProfile(CompanyProfile companyBrief) {

        boolean ret = true;
        try {
            String sql = "update companyprofile set companyId = ?, content = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("CompanyProfile Id = " + companyBrief.getId());
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
            logger.debug("updateCompanyProfile got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListCompanyProfile(List<CompanyProfile> listCompanyProfile) {

        System.out.println("->addListCompanyProfile");
        boolean ret = true;
        try {
            if (listCompanyProfile.size() > 0) {
                for (CompanyProfile obj : listCompanyProfile) {
                    addCompanyProfile(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyProfile got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListCompanyProfile(List<CompanyProfile> listCompanyProfile) {

        boolean ret = true;
        try {
            if (listCompanyProfile.size() > 0) {
                for (CompanyProfile obj : listCompanyProfile) {
                    updateCompanyProfile(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyProfile got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public CompanyProfile getCompanyProfileByCompanyId(Long companyId) {

        CompanyProfile companyProfile = new CompanyProfile();
        List<CompanyProfile> companyProfileList = new ArrayList<CompanyProfile>();
        String sql = "select * from companyprofile where companyId= " + companyId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyProfileList = jdbcTemplate.query(sql, new CompanyProfileRowMapper());
        if (companyProfileList.size() > 0) {
            return companyProfileList.get(0);
        }
        return companyProfile;
    }

}
