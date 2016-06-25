package com.small.business.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.small.business.jdbc.company.CompanyRowMapper;
import com.small.business.jdbc.company.CompanyRowMapper2;
import com.small.business.jdbc.people.PeopleRowMapper;
import com.small.business.model.company.Company;
import com.small.business.model.people.People;

public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    DataSource dataSource;
    private static final Logger logger = LoggerFactory
            .getLogger(CompanyDaoImpl.class);

    public List<Company> getAllCompany() {

        List<Company> companyList = new ArrayList();

        String sql = "select c.*, p.fullName from company c left join people p on c.primaryContact = p.id";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyList = jdbcTemplate.query(sql, new CompanyRowMapper2());
        return companyList;
    }

    public List<Company> getFullCompany() {

        List<Company> companyList = new ArrayList();

        String sql = "select c.*, p.fullName from company c left join people p on c.primaryContact = p.id";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyList = jdbcTemplate.query(sql, new CompanyRowMapper2());
        return companyList;
    }

    @Override
    public Long getNextCompanyId() {

        String sql = "select max(id) as companyId from Company";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long maxId = (long) jdbcTemplate.queryForInt(sql);
        if (maxId == 0)
            maxId = 1L;
        System.out.println("maxId -> " + maxId);
        return maxId;
    }

    private People getPeopleById(Long id) {

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

    public Company getCompanyById(Long id) {

        Company company = new Company();
        List<Company> companyList = new ArrayList<Company>();
        String sql = "select * from company where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        companyList = jdbcTemplate.query(sql, new CompanyRowMapper());
        if (companyList.size() > 0) {
            company = companyList.get(0);
            if (company.getPrimaryContact() > 0) {
                People p = getPeopleById(company.getPrimaryContact());
                company.setPrimaryContactName(p.getFullName());
            }
        }
        return company;
    }

    public boolean addCompany(Company company) {

        boolean ret = true;
        int id = 0;
        if (company.getName() == "" || company.getPhoneNumber() == "" ||
                company.getEmail() == "")
            return ret;
        try {
            String sql = "INSERT INTO Company "
                    + "(name, phoneNumber, fax, primaryContact, "
                    + "webLink, linkedInLink, client, partner,"
                    + "prospect, supplier, doNotContact, doNotMass, email, primaryContactName) "
                    + "VALUES (?, ?, ?, ?,"
                    + " ?, ?, ?, ?,"
                    + "?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            id = jdbcTemplate.update(
                    sql,
                    new Object[] {
                            company.getName(),
                            company.getPhoneNumber(),
                            company.getFax(),
                            company.getPrimaryContact(),
                            company.getWebLink(),
                            company.getLinkedInLink(),
                            company.getClient(),
                            company.getPartner(),
                            company.getProspect(),
                            company.getSupplier(),
                            company.getDoNotContact(),
                            company.getDoNotMass(),
                            company.getEmail(),
                            company.getPrimaryContactName()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("addCompany got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

    public boolean deleteCompanyById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from Company where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteCompanyById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from Company";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            logger.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateCompany(Company company) {

        boolean ret = true;
        try {
            String sql = "update Company set name = ?, phoneNumber = ?, fax = ?, primaryContact = ?, "
                    + " webLink = ?, linkedInLink = ?, client = ?, partner = ?, "
                    + " prospect = ?, supplier = ?, doNotContact = ?, doNotMass = ?, email = ?, primaryContactName = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            logger.debug("companyId = " + company.getId());
            System.out.println("sql: " + sql);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            company.getName(),
                            company.getPhoneNumber(),
                            company.getFax(),
                            company.getPrimaryContact(),
                            company.getWebLink(),
                            company.getLinkedInLink(),
                            company.getClient(),
                            company.getPartner(),
                            company.getProspect(),
                            company.getSupplier(),
                            company.getDoNotContact(),
                            company.getDoNotMass(),
                            company.getEmail(),
                            company.getPrimaryContactName(),
                            company.getId()
                    });
        } catch (Exception ex) {
            ret = false;
            logger.debug("updateCompany got error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }

}
