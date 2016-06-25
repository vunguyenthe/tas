package com.small.business.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.company.CompanyJournalRowMapper;
import com.small.business.model.company.CompanyJournal;

public class CompanyJournalDaoImpl implements CompanyJournalDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyJournalDaoImpl.class);

    public List<CompanyJournal> getAllCompanyJournal() {

        List<CompanyJournal> companyJournalList = new ArrayList();

        String sql = "select * from CompanyJournal";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyJournalList = jdbcTemplate.query(sql, new CompanyJournalRowMapper());
        return companyJournalList;
    }

    public CompanyJournal getCompanyJournalById(Long id) {

        CompanyJournal assignment = new CompanyJournal();
        List<CompanyJournal> companyJournalList = new ArrayList<CompanyJournal>();
        String sql = "select * from CompanyJournal where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyJournalList = jdbcTemplate.query(sql, new CompanyJournalRowMapper());
        if (companyJournalList.size() > 0) {
            return companyJournalList.get(0);
        }
        return assignment;
    }

    public boolean addCompanyJournal(CompanyJournal companyJournal) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO CompanyJournal "
                    + "(companyId, journaType, userId, notes, "
                    + " journalName, userName, dateCreated) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyJournal.getCompanyId(),
                            companyJournal.getJournaType(),
                            companyJournal.getUserId(),
                            companyJournal.getNotes(),
                            companyJournal.getJournalName(),
                            companyJournal.getUserName(),
                            companyJournal.getDateCreated()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addCompanyJournal got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCompanyJournalById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from CompanyJournal where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCompanyJournalById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from CompanyJournal";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateCompanyJournal(CompanyJournal companyJournal) {

        boolean ret = true;
        try {
            String sql = "update CompanyJournal set companyId = ?, journaType = ?, userId = ?, "
                    + " notes = ?, journalName = ?, userName = ?, dateCreated = ?"
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("CompanyJournal Id = " + companyJournal.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyJournal.getCompanyId(),
                            companyJournal.getJournaType(),
                            companyJournal.getUserId(),
                            companyJournal.getNotes(),
                            companyJournal.getJournalName(),
                            companyJournal.getUserName(),
                            companyJournal.getDateCreated(),
                            companyJournal.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateCompanyJournal got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListCompanyJournal(List<CompanyJournal> listCompanyJournal) {

        System.out.println("->addListCompanyJournal");
        boolean ret = true;
        try {
            if (listCompanyJournal.size() > 0) {
                for (CompanyJournal obj : listCompanyJournal) {
                    addCompanyJournal(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyJournal got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListCompanyJournal(List<CompanyJournal> listCompanyJournal) {

        boolean ret = true;
        try {
            if (listCompanyJournal.size() > 0) {
                for (CompanyJournal obj : listCompanyJournal) {
                    updateCompanyJournal(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateListCompanyJournal got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public List<CompanyJournal> getListCompanyJournalByCompanyId(Long companyId) {

        List<CompanyJournal> companyJournalList = new ArrayList<CompanyJournal>();
        String sql = "select * from CompanyJournal where companyId= " + companyId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyJournalList = jdbcTemplate.query(sql, new CompanyJournalRowMapper());
        return companyJournalList;
    }
}
