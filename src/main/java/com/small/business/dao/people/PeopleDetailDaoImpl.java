package com.small.business.dao.people;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.people.PeopleDetailRowMapper;
import com.small.business.model.people.PeopleDetail;

public class PeopleDetailDaoImpl implements PeopleDetailDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(PeopleDetailDaoImpl.class);

    public List<PeopleDetail> getAllPeopleDetail() {

        List<PeopleDetail> peopleDetailList = new ArrayList();

        String sql = "select * from PeopleDetail";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleDetailList = jdbcTemplate.query(sql, new PeopleDetailRowMapper());
        return peopleDetailList;
    }

    @Override
    public Long getNextPeopleId() {

        String sql = "select max(id) + 1 as maxPeopleId from People";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long maxPeopleId = (long) jdbcTemplate.queryForInt(sql);
        if (maxPeopleId == 0)
            maxPeopleId = 1L;
        System.out.println("maxPeopleId -> " + maxPeopleId);
        return maxPeopleId;
    }

    public PeopleDetail getPeopleDetailByPeopleId(Long peopleId) {

        PeopleDetail peopleDetail = new PeopleDetail();
        List<PeopleDetail> peopleDetailList = new ArrayList<PeopleDetail>();
        String sql = "select * from PeopleDetail where peopleId= " + peopleId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleDetailList = jdbcTemplate.query(sql, new PeopleDetailRowMapper());
        if (peopleDetailList.size() > 0) {
            return peopleDetailList.get(0);
        }
        return peopleDetail;
    }

    public PeopleDetail getPeopleDetailById(Long id) {

        PeopleDetail peopleDetail = new PeopleDetail();
        List<PeopleDetail> peopleDetailList = new ArrayList<PeopleDetail>();
        String sql = "select * from PeopleDetail where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        peopleDetailList = jdbcTemplate.query(sql, new PeopleDetailRowMapper());
        if (peopleDetailList.size() > 0) {
            return peopleDetailList.get(0);
        }
        return peopleDetail;
    }

    public boolean addPeopleDetail(PeopleDetail peopleDetail) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO PeopleDetail "
                    + "(peopleId, dateofBirth, age, gender, matialStatus,"
                    + "nationalityId, travel, relocate, payrollNo, niNo, "
                    + "passportNo, visaStatus, noticePeriod, availableDate) "
                    + " VALUES (?, ?, ?, ?, ?, "
                    + "? ,?, ?, ?, ?"
                    + ",?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleDetail.getPeopleId(),
                            peopleDetail.getDateOfBirth(),
                            peopleDetail.getAge(),
                            peopleDetail.getGender(),
                            peopleDetail.getMatialStatus(),
                            peopleDetail.getNationalityId(),
                            peopleDetail.isTravel(),
                            peopleDetail.isRelocate(),
                            peopleDetail.getPayrollNo(),
                            peopleDetail.getNiNo(),
                            peopleDetail.getPassPortNo(),
                            peopleDetail.getVisaStatus(),
                            peopleDetail.getNoticePeriod(),
                            peopleDetail.getAvailableDate()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addPeopleDetail got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deletePeopleDetailById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from PeopleDetail where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deletePeopleDetailById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from PeopleDetail";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public boolean updateListPeopleDetail(List<PeopleDetail> listPeopleDetail) {

        boolean ret = true;
        try {
            if (listPeopleDetail.size() > 0) {
                for (PeopleDetail obj : listPeopleDetail) {
                    updatePeopleDetail(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("updateListPeopleDetail got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean addListPeopleDetail(List<PeopleDetail> listPeopleDetail) {

        System.out.println("->addListPeopleDetail");
        boolean ret = true;
        try {
            if (listPeopleDetail.size() > 0) {
                for (PeopleDetail obj : listPeopleDetail) {
                    addPeopleDetail(obj);
                }
            }
        } catch (Exception ex) {
            ret = false;
            logger.error("addListPeopleDetail got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean updatePeopleDetail(PeopleDetail peopleDetail) {

        boolean ret = true;
        try {
            String sql = "update PeopleDetail set peopleId = ?, dateofBirth =?, age = ?, gender = ?"
                    + ", matialStatus =?,"
                    + "nationalityId =?, travel = ?, relocate = ?, payrollNo = ?, niNo = ?, "
                    + "passportNo = ?, visaStatus = ?, noticePeriod = ?, availableDate =? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("Id = " + peopleDetail.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            peopleDetail.getPeopleId(),
                            peopleDetail.getDateOfBirth(),
                            peopleDetail.getAge(),
                            peopleDetail.getGender(),
                            peopleDetail.getMatialStatus(),
                            peopleDetail.getNationalityId(),
                            peopleDetail.isTravel(),
                            peopleDetail.isRelocate(),
                            peopleDetail.getPayrollNo(),
                            peopleDetail.getNiNo(),
                            peopleDetail.getPassPortNo(),
                            peopleDetail.getVisaStatus(),
                            peopleDetail.getNoticePeriod(),
                            peopleDetail.getAvailableDate(),
                            peopleDetail.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.error("updatePeopleDetail got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
