package com.small.business.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.company.CompanyTagRowMapper;
import com.small.business.model.company.CompanyTag;

public class CompanyTagDaoImpl implements CompanyTagDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyTagDaoImpl.class);

    public List<CompanyTag> getAllCompanyTag() {

        List<CompanyTag> companyTagList = new ArrayList();

        String sql = "select * from CompanyTag";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyTagList = jdbcTemplate.query(sql, new CompanyTagRowMapper());
        return companyTagList;
    }

    public CompanyTag getCompanyTagByCompanyId(Long companyId) {

        CompanyTag companyTag = new CompanyTag();
        List<CompanyTag> companyTagList = new ArrayList<CompanyTag>();
        String sql = "select * from CompanyTag where companyId= " + companyId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyTagList = jdbcTemplate.query(sql, new CompanyTagRowMapper());
        if (companyTagList.size() > 0) {
            return companyTagList.get(0);
        }
        return companyTag;
    }

    public CompanyTag getCompanyTagById(Long id) {

        CompanyTag companyTag = new CompanyTag();
        List<CompanyTag> companyTagList = new ArrayList<CompanyTag>();
        String sql = "select * from CompanyTag where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyTagList = jdbcTemplate.query(sql, new CompanyTagRowMapper());
        if (companyTagList.size() > 0) {
            return companyTagList.get(0);
        }
        return companyTag;
    }

    public boolean addCompanyTag(CompanyTag companyTag) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO CompanyTag "
                    + "(companyId, industryId, locationId, positionFunId, positionLevelId,  languageId) "
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyTag.getCompanyId(),
                            companyTag.getIndustryId(),
                            companyTag.getLocationId(),
                            companyTag.getPositionFunId(),
                            companyTag.getPositionLevelId(),
                            companyTag.getLanguageId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addCompanyTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCompanyTagById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from CompanyTag where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCompanyTagById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from CompanyTag";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public boolean updateListCompanyTag(List<CompanyTag> listCompanyTag) {

        boolean ret = true;
        try {
            if (listCompanyTag.size() > 0) {
                for (CompanyTag obj : listCompanyTag) {
                    updateCompanyTag(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListCompanyTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListCompanyTag(List<CompanyTag> listCompanyTag) {

        System.out.println("->addListCompanyTag");
        boolean ret = true;
        try {
            if (listCompanyTag.size() > 0) {
                for (CompanyTag obj : listCompanyTag) {
                    addCompanyTag(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListCompanyTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateCompanyTag(CompanyTag companyTag) {

        boolean ret = true;
        try {
            String sql = "update CompanyTag set companyId = ?, industryId = ?, locationId = ?, positionFunId = ?, positionLevelId = ?,  languageId = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("Id = " + companyTag.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyTag.getCompanyId(),
                            companyTag.getIndustryId(),
                            companyTag.getLocationId(),
                            companyTag.getPositionFunId(),
                            companyTag.getPositionLevelId(),
                            companyTag.getLanguageId(),
                            companyTag.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updateCompanyTag got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
