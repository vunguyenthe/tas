package com.small.business.model.company;

import java.util.ArrayList;
import java.util.List;

import com.small.business.model.base.BaseMessage;

public class Company extends BaseMessage {

    private String name;
    private String phoneNumber;
    private String fax;
    private Long primaryContact;
    private String webLink;
    private String linkedInLink;
    private Boolean client;
    private Boolean partner;
    private Boolean prospect;
    private Boolean supplier;
    private Boolean doNotContact;
    private Boolean doNotMass;
    private String email;
    private String primaryContactName;
    private List<CompanyPeople> peoples = new ArrayList<>();
    private List<CompanyLocation> locations = new ArrayList<>();
    private List<CompanyJournal> journals = new ArrayList<>();
    private List<CompanyNote> notes = new ArrayList<>();
    private List<CompanyDepartment> departments = new ArrayList<>();
    private CompanyTag companyTag = new CompanyTag();
    private CompanyNotepad companyNotepad = new CompanyNotepad();
    private CompanyProfile companyProfile = new CompanyProfile();

    public CompanyNotepad getCompanyNotepad() {

        return companyNotepad;
    }

    public void setCompanyNotepad(CompanyNotepad companyNotepad) {

        this.companyNotepad = companyNotepad;
    }

    public CompanyProfile getCompanyProfile() {

        return companyProfile;
    }

    public void setCompanyProfile(CompanyProfile companyProfile) {

        this.companyProfile = companyProfile;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getFax() {

        return fax;
    }

    public void setFax(String fax) {

        this.fax = fax;
    }

    public Long getPrimaryContact() {

        return primaryContact;
    }

    public void setPrimaryContact(Long primaryContact) {

        this.primaryContact = primaryContact;
    }

    public String getWebLink() {

        return webLink;
    }

    public void setWebLink(String webLink) {

        this.webLink = webLink;
    }

    public String getLinkedInLink() {

        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {

        this.linkedInLink = linkedInLink;
    }

    public Boolean getClient() {

        return client;
    }

    public void setClient(Boolean client) {

        this.client = client;
    }

    public Boolean getPartner() {

        return partner;
    }

    public void setPartner(Boolean partner) {

        this.partner = partner;
    }

    public Boolean getProspect() {

        return prospect;
    }

    public void setProspect(Boolean prospect) {

        this.prospect = prospect;
    }

    public Boolean getSupplier() {

        return supplier;
    }

    public void setSupplier(Boolean supplier) {

        this.supplier = supplier;
    }

    public Boolean getDoNotContact() {

        return doNotContact;
    }

    public void setDoNotContact(Boolean doNotContact) {

        this.doNotContact = doNotContact;
    }

    public Boolean getDoNotMass() {

        return doNotMass;
    }

    public void setDoNotMass(Boolean doNotMass) {

        this.doNotMass = doNotMass;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public List<CompanyPeople> getPeoples() {

        return peoples;
    }

    public void setPeoples(List<CompanyPeople> peoples) {

        this.peoples = peoples;
    }

    public List<CompanyLocation> getLocations() {

        return locations;
    }

    public void setLocations(List<CompanyLocation> locations) {

        this.locations = locations;
    }

    public List<CompanyJournal> getJournals() {

        return journals;
    }

    public void setJournals(List<CompanyJournal> journals) {

        this.journals = journals;
    }

    public List<CompanyNote> getNotes() {

        return notes;
    }

    public void setNotes(List<CompanyNote> notes) {

        this.notes = notes;
    }

    public List<CompanyDepartment> getDepartments() {

        return departments;
    }

    public void setDepartments(List<CompanyDepartment> departments) {

        this.departments = departments;
    }

    public String getPrimaryContactName() {

        return primaryContactName;
    }

    public void setPrimaryContactName(String primaryContactName) {

        this.primaryContactName = primaryContactName;
    }

    public CompanyTag getCompanyTag() {

        return companyTag;
    }

    public void setCompanyTag(CompanyTag companyTag) {

        this.companyTag = companyTag;
    }

    @Override
    public String toString() {

        return "Company [name=" + name + ", phoneNumber=" + phoneNumber + ", fax=" + fax + ", primaryContact=" + primaryContact + ", webLink=" + webLink + ", linkedInLink="
                + linkedInLink + ", client=" + client + ", partner=" + partner + ", prospect=" + prospect + ", supplier=" + supplier + ", doNotContact=" + doNotContact
                + ", doNotMass=" + doNotMass + ", email=" + email + ", peoples=" + peoples + ", locations=" + locations + ", journals=" + journals + ", notes=" + notes
                + ", departments=" + departments + "]";
    }

}