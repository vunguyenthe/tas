package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.PeopleDocumentRowMapper;
import com.small.business.model.people.PeopleDocument;

public class PeopleDocumentDaoImpl implements PeopleDocumentDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(PeopleDocumentDaoImpl.class);

    public List<PeopleDocument> getAllPeopleDocument() {

        List<PeopleDocument> peopleDocumentList = new ArrayList();

        String sql = "select * from PeopleDocument";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleDocumentList = jdbcTemplate.query(sql, new PeopleDocumentRowMapper());
        return peopleDocumentList;
    }

    public List<PeopleDocument> getPeopleDocumentByPeopleId(Long peopleId) {

        List<PeopleDocument> peopleDocumentList = new ArrayList<PeopleDocument>();
        String sql = "select * from PeopleDocument where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleDocumentList = jdbcTemplate.query(sql, new PeopleDocumentRowMapper());
        return peopleDocumentList;
    }

    public PeopleDocument getPeopleDocumentById(Long id) {

        PeopleDocument assignment = new PeopleDocument();
        List<PeopleDocument> peopleDocumentList = new ArrayList<PeopleDocument>();
        String sql = "select * from PeopleDocument where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleDocumentList = jdbcTemplate.query(sql, new PeopleDocumentRowMapper());
        if (peopleDocumentList.size() > 0) {
            return peopleDocumentList.get(0);
        }
        return assignment;
    }

    public boolean addPeopleDocument(PeopleDocument peopleDocument) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO PeopleDocument "
                    + "(peopleId, documentName, documentPath, notes, createBy ) "
                    + " VALUES (?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleDocument.getPeopleId(),
                            peopleDocument.getDocumentName(),
                            peopleDocument.getDocumentPath(),
                            peopleDocument.getNotes(),
                            peopleDocument.getCreateBy()
                    // peopleDocument.getDateCreated()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addPeopleDocument got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deletePeopleDocumentById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from PeopleDocument where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deletePeopleDocumentById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from PeopleDocument";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public boolean updateListPeopleDocument(List<PeopleDocument> listPeopleDocument) {

        boolean ret = true;
        try {
            if (listPeopleDocument.size() > 0) {
                for (PeopleDocument obj : listPeopleDocument) {
                    updatePeopleDocument(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListPeopleDocument got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListPeopleDocument(List<PeopleDocument> listPeopleDocument) {

        System.out.println("->addListPeopleDocument");
        boolean ret = true;
        try {
            if (listPeopleDocument.size() > 0) {
                for (PeopleDocument obj : listPeopleDocument) {
                    addPeopleDocument(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListPeopleDocument got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updatePeopleDocument(PeopleDocument peopleDocument) {

        boolean ret = true;
        try {
            String sql = "update PeopleDocument set peopleId = ?, documentName = ?, documentPath = ?,"
                    + "notes = ?, createBy = ?"// , dateCreated = ?"
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("Id = " + peopleDocument.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleDocument.getPeopleId(),
                            peopleDocument.getDocumentName(),
                            peopleDocument.getDocumentPath(),
                            peopleDocument.getNotes(),
                            peopleDocument.getCreateBy(),
                            // peopleDocument.getDateCreated(),
                            peopleDocument.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updatePeopleDocument got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
