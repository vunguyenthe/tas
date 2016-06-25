package com.small.business.model.people;

import java.util.ArrayList;
import java.util.List;

import com.small.business.model.base.BaseMessage;

public class People extends BaseMessage {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String mobilePhone;
    private Long companyId;// primary key
    private String jobTitle;
    private String businessPhone;
    private String businessFax;
    private String linkedIn;
    private String address;
    private String cv;
    private String webLink;
    private String skypeID;
    private boolean client;
    private boolean candidate;
    private boolean partner;
    private boolean contact;
    private boolean doNotMass;
    private boolean vip;
    private boolean supplier;
    private String photo;
    private String createBy;
    private List<PeopleJournal> journal = new ArrayList();
    private List<PeopleEducation> education = new ArrayList();;
    private List<PeopleHistory> history = new ArrayList();;
    private List<PeopleAssignment> assignment = new ArrayList();;
    private List<PeopleDocument> document = new ArrayList();
    private PeopleDetail peopleDetail = new PeopleDetail();
    private String companyName;
    private PeopleTag peopleTag = new PeopleTag();
    private PeopleNotepad peopleNotepad = new PeopleNotepad();

    public PeopleNotepad getPeopleNotepad() {

        return peopleNotepad;
    }

    public void setPeopleNotepad(PeopleNotepad peopleNotepad) {

        this.peopleNotepad = peopleNotepad;
    }

    public PeopleDetail getPeopleDetail() {

        return peopleDetail;
    }

    public void setPeopleDetail(PeopleDetail peopleDetail) {

        this.peopleDetail = peopleDetail;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getMobilePhone() {

        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {

        this.mobilePhone = mobilePhone;
    }

    public Long getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Long companyId) {

        this.companyId = companyId;
    }

    public String getJobTitle() {

        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {

        this.jobTitle = jobTitle;
    }

    public String getBusinessPhone() {

        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {

        this.businessPhone = businessPhone;
    }

    public String getBusinessFax() {

        return businessFax;
    }

    public void setBusinessFax(String businessFax) {

        this.businessFax = businessFax;
    }

    public String getLinkedIn() {

        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {

        this.linkedIn = linkedIn;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getCv() {

        return cv;
    }

    public void setCv(String cv) {

        this.cv = cv;
    }

    public String getWebLink() {

        return webLink;
    }

    public void setWebLink(String webLink) {

        this.webLink = webLink;
    }

    public String getSkypeID() {

        return skypeID;
    }

    public void setSkypeID(String skypeID) {

        this.skypeID = skypeID;
    }

    public boolean isClient() {

        return client;
    }

    public void setClient(boolean client) {

        this.client = client;
    }

    public boolean isCandidate() {

        return candidate;
    }

    public void setCandidate(boolean candidate) {

        this.candidate = candidate;
    }

    public boolean isPartner() {

        return partner;
    }

    public void setPartner(boolean partner) {

        this.partner = partner;
    }

    public boolean isContact() {

        return contact;
    }

    public void setContact(boolean contact) {

        this.contact = contact;
    }

    public boolean isDoNotMass() {

        return doNotMass;
    }

    public void setDoNotMass(boolean doNotMass) {

        this.doNotMass = doNotMass;
    }

    public boolean isVip() {

        return vip;
    }

    public void setVip(boolean vip) {

        this.vip = vip;
    }

    public boolean isSupplier() {

        return supplier;
    }

    public void setSupplier(boolean supplier) {

        this.supplier = supplier;
    }

    public String getPhoto() {

        return photo;
    }

    public void setPhoto(String photo) {

        this.photo = photo;
    }

    public String getCreateBy() {

        return createBy;
    }

    public void setCreateBy(String createBy) {

        this.createBy = createBy;
    }

    public List<PeopleJournal> getJournal() {

        return journal;
    }

    public void setJournal(List<PeopleJournal> journal) {

        this.journal = journal;
    }

    public List<PeopleEducation> getEducation() {

        return education;
    }

    public void setEducation(List<PeopleEducation> education) {

        this.education = education;
    }

    public List<PeopleHistory> getHistory() {

        return history;
    }

    public void setHistory(List<PeopleHistory> history) {

        this.history = history;
    }

    public List<PeopleAssignment> getAssignment() {

        return assignment;
    }

    public void setAssignment(List<PeopleAssignment> assignment) {

        this.assignment = assignment;
    }

    public List<PeopleDocument> getDocument() {

        return document;
    }

    public void setDocument(List<PeopleDocument> document) {

        this.document = document;
    }

    public String getCompanyName() {

        return companyName;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }

    public PeopleTag getPeopleTag() {

        return peopleTag;
    }

    public void setPeopleTag(PeopleTag peopleTag) {

        this.peopleTag = peopleTag;
    }

    @Override
    public String toString() {

        return "People [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", mobilePhone=" + mobilePhone + ", companyId=" + companyId
                + ", jobTitle=" + jobTitle + ", businessPhone=" + businessPhone + ", businessFax=" + businessFax + ", linkedIn=" + linkedIn + ", address=" + address + ", cv="
                + cv + ", webLink=" + webLink + ", skypeID=" + skypeID + ", client=" + client + ", candidate=" + candidate + ", partner=" + partner + ", contact=" + contact
                + ", doNotMass=" + doNotMass + ", vip=" + vip + ", supplier=" + supplier + ", photo=" + photo + ", createBy=" + createBy + ", journal=" + journal
                + ", education=" + education + ", history=" + history + ", assignment=" + assignment + ", document=" + document + "]";
    }

}