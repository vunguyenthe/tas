package com.small.business.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.company.CompanyNoteRowMapper;
import com.small.business.model.company.CompanyNote;

public class CompanyNoteDaoImpl implements CompanyNoteDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyNoteDaoImpl.class);

    public List<CompanyNote> getAllCompanyNote() {

        List<CompanyNote> companyNoteList = new ArrayList();

        String sql = "select * from CompanyNote";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyNoteList = jdbcTemplate.query(sql, new CompanyNoteRowMapper());
        return companyNoteList;
    }

    public CompanyNote getCompanyNoteById(Long id) {

        CompanyNote assignment = new CompanyNote();
        List<CompanyNote> companyNoteList = new ArrayList<CompanyNote>();
        String sql = "select * from CompanyNote where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyNoteList = jdbcTemplate.query(sql, new CompanyNoteRowMapper());
        if (companyNoteList.size() > 0) {
            return companyNoteList.get(0);
        }
        return assignment;
    }

    public boolean addCompanyNote(CompanyNote companyNote) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO CompanyNote "
                    + "(companyId, userId, userName, title, notes) "
                    + " VALUES (?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyNote.getCompanyId(),
                            companyNote.getUserId(),
                            companyNote.getUserName(),
                            companyNote.getTitle(),
                            companyNote.getNotes()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addCompanyNote got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCompanyNoteById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from CompanyNote where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCompanyNoteById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from CompanyNote";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateCompanyNote(CompanyNote companyNote) {

        boolean ret = true;
        try {
            String sql = "update CompanyNote set companyId = ?, userId = ?, userName = ?, title = ?,"
                    + " notes = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("CompanyNote Id = " + companyNote.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            companyNote.getCompanyId(),
                            companyNote.getUserId(),
                            companyNote.getUserName(),
                            companyNote.getTitle(),
                            companyNote.getNotes(),
                            companyNote.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateCompanyNote got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean addListCompanyNote(List<CompanyNote> listCompanyNote) {

        System.out.println("->addListCompanyNote");
        boolean ret = true;
        try {
            if (listCompanyNote.size() > 0) {
                for (CompanyNote obj : listCompanyNote) {
                    addCompanyNote(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyNote got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updateListCompanyNote(List<CompanyNote> listCompanyNote) {

        boolean ret = true;
        try {
            if (listCompanyNote.size() > 0) {
                for (CompanyNote obj : listCompanyNote) {
                    updateCompanyNote(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.debug("addListCompanyNote got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public List<CompanyNote> getListCompanyNoteByCompanyId(Long companyId) {

        List<CompanyNote> companyNoteList = new ArrayList<CompanyNote>();
        String sql = "select * from CompanyNote where companyId= " + companyId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyNoteList = jdbcTemplate.query(sql, new CompanyNoteRowMapper());
        return companyNoteList;
    }

}
