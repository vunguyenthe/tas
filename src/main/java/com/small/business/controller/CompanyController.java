package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.company.Company;
import com.small.business.model.company.CompanyDepartment;
import com.small.business.model.company.CompanyJournal;
import com.small.business.model.company.CompanyLocation;
import com.small.business.model.company.CompanyNote;
import com.small.business.model.company.CompanyNotepad;
import com.small.business.model.company.CompanyPeople;
import com.small.business.model.company.CompanyProfile;
import com.small.business.model.company.CompanyTag;
import com.small.business.service.company.CompanyDepartmentService;
import com.small.business.service.company.CompanyJournalService;
import com.small.business.service.company.CompanyLocationService;
import com.small.business.service.company.CompanyNoteService;
import com.small.business.service.company.CompanyNotepadService;
import com.small.business.service.company.CompanyPeopleService;
import com.small.business.service.company.CompanyProfileService;
import com.small.business.service.company.CompanyService;
import com.small.business.service.company.CompanyTagService;

@Controller
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyPeopleService companyPeopleService;

    @Autowired
    private CompanyNoteService companyNoteService;

    @Autowired
    private CompanyDepartmentService companyDepartmentService;

    @Autowired
    private CompanyLocationService companyLocationService;

    @Autowired
    private CompanyJournalService companyJournalService;

    @Autowired
    private CompanyTagService companyTagService;

    @Autowired
    private CompanyNotepadService companyNotepadService;

    @Autowired
    private CompanyProfileService companyProfileService;

    @RequestMapping(value = "/company/{companyId}", method = RequestMethod.GET)
    public @ResponseBody Company getCompany(@PathVariable long companyId) {

        Company company = companyService.getCompanyById(companyId);
        if (company.getId() > 0) {
            List<CompanyJournal> listCompanyJournal = companyJournalService.getListCompanyJournalByCompanyId(companyId);
            List<CompanyLocation> listCompanyLocation = companyLocationService.getListCompanyLocationByCompanyId(companyId);
            List<CompanyDepartment> listCompanyDepartment = companyDepartmentService.getListCompanyDepartmentByCompanyId(companyId);
            List<CompanyNote> listCompanyNote = companyNoteService.getListCompanyNoteByCompanyId(companyId);
            List<CompanyPeople> listCompanyPeople = companyPeopleService.getListCompanyPeopleByCompanyId(companyId);
            CompanyNotepad companyNotepad = companyNotepadService.getCompanyNotepadByCompanyId(companyId);
            CompanyProfile companyProfile = companyProfileService.getCompanyProfileByCompanyId(companyId);
            CompanyTag companyTag = companyTagService.getCompanyTagByCompanyId(companyId);
            company.setPeoples(listCompanyPeople);
            company.setLocations(listCompanyLocation);
            company.setJournals(listCompanyJournal);
            company.setNotes(listCompanyNote);
            company.setDepartments(listCompanyDepartment);
            company.setCompanyTag(companyTag);
            company.setCompanyNotepad(companyNotepad);
            company.setCompanyProfile(companyProfile);
        }
        return company;
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public @ResponseBody List<Company> getCompanyList() {

        return companyService.getAllCompany();
    }

    @RequestMapping(value = "/getFullCompany", method = RequestMethod.GET)
    public @ResponseBody List<Company> getFullCompany() {

        return companyService.getFullCompany();
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public @ResponseBody boolean addCompany(@RequestBody Company company) {

        boolean ret = true;
        ret = companyService.addCompany(company);
        if (ret) {

            Long companyId = companyService.getNextCompanyId();

            List<CompanyPeople> listCompanyPeople = company.getPeoples();
            if (listCompanyPeople.size() > 0) {
                for (CompanyPeople obj : listCompanyPeople) {
                    if (obj.getId() == 0L || obj.getCompanyId() != companyId) {
                        obj.setCompanyId(companyId);
                    }
                }
                ret &= companyPeopleService.addListCompanyPeople(listCompanyPeople);
            }

            List<CompanyNote> listCompanyNote = company.getNotes();
            if (listCompanyNote.size() > 0) {
                for (CompanyNote obj : listCompanyNote) {
                    if (obj.getId() == 0L || obj.getCompanyId() != companyId) {
                        obj.setCompanyId(companyId);
                    }
                }
                ret &= companyNoteService.addListCompanyNote(listCompanyNote);
            }

            List<CompanyDepartment> listcompanyDepartment = company.getDepartments();
            if (listcompanyDepartment.size() > 0) {
                for (CompanyDepartment obj : listcompanyDepartment) {
                    if (obj.getId() == 0L || obj.getCompanyId() != companyId) {
                        obj.setCompanyId(companyId);
                    }
                }
                ret &= companyDepartmentService.addListCompanyDepartment(listcompanyDepartment);
            }

            List<CompanyJournal> listCompanyJournal = company.getJournals();
            if (listCompanyJournal.size() > 0) {
                for (CompanyJournal obj : listCompanyJournal) {
                    if (obj.getId() == 0L || obj.getCompanyId() != companyId) {
                        obj.setCompanyId(companyId);
                    }
                }
                ret &= companyJournalService.addListCompanyJournal(listCompanyJournal);
            }

            List<CompanyLocation> listCompanyLocation = company.getLocations();
            if (listCompanyLocation.size() > 0) {
                for (CompanyLocation obj : listCompanyLocation) {
                    if (obj.getId() == 0L || obj.getCompanyId() != companyId) {
                        obj.setCompanyId(companyId);
                    }
                }
                ret &= companyLocationService.addListCompanyLocation(listCompanyLocation);
            }

            CompanyTag companyTag = company.getCompanyTag();
            if (companyTag.getId() == 0L || companyTag.getCompanyId() != companyId) {
                companyTag.setCompanyId(companyId);
                ret &= companyTagService.addCompanyTag(companyTag);
            }

            CompanyNotepad companyNotepad = company.getCompanyNotepad();
            if (companyNotepad.getId() == 0L || companyNotepad.getCompanyId() != companyId) {
                companyNotepad.setCompanyId(companyId);
                ret &= companyNotepadService.addCompanyNotepad(companyNotepad);
            }

            CompanyProfile companyProfile = company.getCompanyProfile();
            if (companyProfile.getId() == 0L || companyProfile.getCompanyId() != companyId) {
                companyProfile.setCompanyId(companyId);
                ret &= companyProfileService.addCompanyProfile(companyProfile);
            }

        }

        return ret;
    }

    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    public @ResponseBody boolean updateCompany(@RequestBody Company company) {

        boolean ret = true;
        Long companyId = company.getId();
        if (companyId > 0) {
            List<CompanyLocation> listCompanyLocation = company.getLocations();
            if (listCompanyLocation.size() > 0) {
                for (CompanyLocation obj : listCompanyLocation) {
                    if (obj.getId() == 0L) {
                        obj.setCompanyId(companyId);
                        ret &= companyLocationService.addCompanyLocation(obj);
                    } else {
                        ret &= companyLocationService.updateCompanyLocation(obj);
                    }
                }
            }

            List<CompanyPeople> listCompanyPeople = company.getPeoples();
            if (listCompanyPeople.size() > 0) {
                for (CompanyPeople obj : listCompanyPeople) {
                    if (obj.getId() == 0L) {
                        obj.setCompanyId(companyId);
                        ret &= companyPeopleService.addCompanyPeople(obj);
                    } else {
                        ret &= companyPeopleService.updateCompanyPeople(obj);
                    }
                }
            }

            List<CompanyNote> listCompanyNote = company.getNotes();
            if (listCompanyNote.size() > 0) {
                for (CompanyNote obj : listCompanyNote) {
                    if (obj.getId() == 0L) {
                        obj.setCompanyId(companyId);
                        ret &= companyNoteService.addCompanyNote(obj);
                    } else {
                        ret &= companyNoteService.updateCompanyNote(obj);
                    }
                }
            }

            List<CompanyJournal> listCompanyJournal = company.getJournals();
            if (listCompanyJournal.size() > 0) {
                for (CompanyJournal obj : listCompanyJournal) {
                    if (obj.getId() == 0L) {
                        obj.setCompanyId(companyId);
                        ret &= companyJournalService.addCompanyJournal(obj);
                    } else {
                        ret &= companyJournalService.updateCompanyJournal(obj);
                    }
                }
            }

            List<CompanyDepartment> listCompanyDepartment = company.getDepartments();
            if (listCompanyDepartment.size() > 0) {
                for (CompanyDepartment obj : listCompanyDepartment) {
                    if (obj.getId() == 0L) {
                        obj.setCompanyId(companyId);
                        ret &= companyDepartmentService.addCompanyDepartment(obj);
                    } else {
                        ret &= companyDepartmentService.updateCompanyDepartment(obj);
                    }
                }
            }

            CompanyTag companyTag = company.getCompanyTag();
            ret &= companyTagService.updateCompanyTag(companyTag);

            CompanyNotepad companyNotepad = company.getCompanyNotepad();
            ret &= companyNotepadService.updateCompanyNotepad(companyNotepad);

            CompanyProfile companyProfile = company.getCompanyProfile();
            ret &= companyProfileService.updateCompanyProfile(companyProfile);
        }

        ret &= companyService.updateCompany(company);
        return ret;
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeCompany(@PathVariable("id") Long id) {

        return companyService.deleteCompanyById(id);
    }

    @RequestMapping(value = "/removeAllCompany", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllCompany() {

        return companyService.deleteAll();
    }

}
