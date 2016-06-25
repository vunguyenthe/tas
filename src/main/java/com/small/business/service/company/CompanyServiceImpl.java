package com.small.business.service.company;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.small.business.dao.company.CompanyDao;
import com.small.business.model.company.Company;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyServiceImpl.class);
    private static List<Company> companyList = new ArrayList<Company>();
    private static Long id = 0L;

    @Autowired
    CompanyDao companyDao;

    public List<Company> getAllCompany() {

        List<Company> companyList = companyDao.getAllCompany();
        return companyList;
    }

    public List<Company> getFullCompany() {

        List<Company> companyList = companyDao.getFullCompany();
        return companyList;
    }

    public Long getNextCompanyId() {

        return companyDao.getNextCompanyId();
    }

    public Company getCompanyById(Long id) {

        return companyDao.getCompanyById(id);
    }

    public boolean addCompany(Company company) {

        company.setId(++id);
        return companyDao.addCompany(company);
    }

    public boolean deleteCompanyById(Long id) {

        boolean ret = false;
        ret = companyDao.deleteCompanyById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        companyList.clear();
        id = 0L;
        return companyDao.deleteAll();
    }

    public String uploadFilePostMethod(MultipartFile file,
            HttpServletRequest request) {

        System.out.println("Upload file - post method");
        if (file != null) {

            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null)
                    System.out.println("File inputstream is null");

                String pathUpDir = request.getSession().getServletContext()
                        .getRealPath("/")
                        + "resources/cv/";

                File upload = new File(pathUpDir + file.getOriginalFilename());
                file.transferTo(upload);
                String imagePath = pathUpDir + file.getOriginalFilename();
                System.out.println("imagePath ->" + imagePath);
                IOUtils.closeQuietly(inputStream);

            } catch (IOException ex) {
                logger.debug("uploadFilePostMethod got error: " + ex.getMessage());
                return "ERROR";
            }
        }

        return "SUCCESS";

    }

    public boolean updateCompany(Company company) {

        Company foundCompany = findCompanyById(company.getId());
        if (foundCompany != null) {
            companyList.remove(foundCompany);
            companyList.add(company);
        }
        return companyDao.updateCompany(company);

    }

    private Company findCompanyById(Long id) {

        return companyDao.getCompanyById(id);
    }
}
