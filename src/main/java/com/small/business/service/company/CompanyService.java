package com.small.business.service.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.small.business.model.company.Company;

public interface CompanyService {

    public List<Company> getAllCompany();

    public List<Company> getFullCompany();

    public Company getCompanyById(Long id);

    public boolean addCompany(Company company);

    public boolean deleteCompanyById(Long id);

    public Long getNextCompanyId();

    public boolean deleteAll();

    public boolean updateCompany(Company People);

    public String uploadFilePostMethod(MultipartFile file,
            HttpServletRequest request);

}
