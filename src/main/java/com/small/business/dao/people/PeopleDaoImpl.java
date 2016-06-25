package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.PeopleRowMapper;
import com.small.business.model.people.People;

public class PeopleDaoImpl implements PeopleDao {

    private static final Logger logger = LoggerFactory
            .getLogger(PeopleDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<People> getAllPeople() {

        List<People> peopleList = new ArrayList();

        String sql = "select * from People";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleList = jdbcTemplate.query(sql, new PeopleRowMapper());
        return peopleList;
    }

    public List<People> getAllClient() {

        List<People> peopleList = new ArrayList();

        String sql = "select * from People where client = 1";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleList = jdbcTemplate.query(sql, new PeopleRowMapper());
        return peopleList;
    }

    public List<People> getAllCandidate() {

        List<People> peopleList = new ArrayList();

        String sql = "select * from People where candidate = 1";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleList = jdbcTemplate.query(sql, new PeopleRowMapper());
        return peopleList;
    }

    public People getPeopleById(Long id) {

        People people = new People();
        List<People> peopleList = new ArrayList<People>();
        String sql = "select * from People where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleList = jdbcTemplate.query(sql, new PeopleRowMapper());
        if (peopleList.size() > 0) {
            return peopleList.get(0);
        }
        return people;
    }

    public boolean addPeople(People people) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO People "
                    + "(fullName, email, phoneNumber, mobilePhone,"
                    + " companyId, jobTitle, businessPhone,"
                    + "businessFax, linkedIn, address, cv,"
                    + "webLink, skypeID, client, candidate,"
                    + "partner, contact, doNotMass, vip, supplier, photo, createBy, companyName) VALUES "
                    + "(?, ?, ?, ?,"
                    + " ?, ?, ?,"
                    + "?, ?, ?, ?,"
                    + "?, ?, ?, ?,"
                    + "?, ?, ?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            System.out.println("->addPeople");
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            people.getFullName(),
                            people.getEmail(),
                            people.getPhoneNumber(),
                            people.getMobilePhone(),
                            people.getCompanyId(),
                            people.getJobTitle(),
                            people.getBusinessPhone(),
                            people.getBusinessFax(),
                            people.getLinkedIn(),
                            people.getAddress(),
                            people.getCv(),
                            people.getWebLink(),
                            people.getSkypeID(),
                            people.isClient(),
                            people.isCandidate(),
                            people.isPartner(),
                            people.isContact(),
                            people.isDoNotMass(),
                            people.isVip(),
                            people.isSupplier(),
                            people.getPhoto(),
                            people.getCreateBy(),
                            people.getCompanyName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addPeople got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deletePeopleById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from People where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deletePeopleById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from People";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;

    }

    @Override
    public Long getNextPeopleId() {

        String sql = "select max(id) as maxPeopleId from People";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long maxPeopleId = (long) jdbcTemplate.queryForInt(sql);
        if (maxPeopleId == 0)
            maxPeopleId = 1L;
        System.out.println("maxPeopleId -> " + maxPeopleId);
        return maxPeopleId;
    }

    public boolean updatePeople(People people) {

        boolean ret = true;
        String sql = "update People set fullName = ?, email = ?, phoneNumber = ?, "
                + "mobilePhone = ?, companyId = ?, jobTitle = ?, businessPhone = ?, "
                + "businessFax = ?, linkedIn = ?, address = ?, cv = ?, "
                + "webLink = ?, skypeID = ?, client = ?, candidate = ?, "
                + "partner = ?, contact = ?, doNotMass = ?, "
                + "vip = ?, supplier = ?, photo = ?, createBy = ?, companyName = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("updatePeople: " + sql);
        logger.debug("PeopleId = " + people.getId());
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            people.getFullName(),
                            people.getEmail(),
                            people.getPhoneNumber(),
                            people.getMobilePhone(),
                            people.getCompanyId(),
                            people.getJobTitle(),
                            people.getBusinessPhone(),
                            people.getBusinessFax(),
                            people.getLinkedIn(),
                            people.getAddress(),
                            people.getCv(),
                            people.getWebLink(),
                            people.getSkypeID(),
                            people.isClient(),
                            people.isCandidate(),
                            people.isPartner(),
                            people.isContact(),
                            people.isDoNotMass(),
                            people.isVip(),
                            people.isSupplier(),
                            people.getPhoto(),
                            people.getCreateBy(),
                            people.getCompanyName(),
                            people.getId() });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updatePeople got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
