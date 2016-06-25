package com.small.business.model.people;

import java.util.ArrayList;
import java.util.List;

import com.small.business.model.base.BaseMessage;

public class PeopleDetail extends BaseMessage {

    private Long peopleId = 0L;
    private String dateOfBirth;
    private Long age;
    private String gender;// 0: male, female
    private String matialStatus; // 0:single, 1:maried
    private Long nationalityId = 0L;
    private boolean travel;
    private boolean relocate;
    private String payrollNo;
    private String niNo;
    private String passPortNo;
    private String visaStatus;
    private String noticePeriod;
    private String availableDate;
    private List<CurrentPackage> currentPackage = new ArrayList();
    private List<CurrentBenefit> currentBenefit = new ArrayList();

    public Long getPeopleId() {

        return peopleId;
    }

    public void setPeopleId(Long peopleId) {

        this.peopleId = peopleId;
    }

    public String getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public Long getAge() {

        return age;
    }

    public void setAge(Long age) {

        this.age = age;
    }

    public boolean isTravel() {

        return travel;
    }

    public void setTravel(boolean travel) {

        this.travel = travel;
    }

    public boolean isRelocate() {

        return relocate;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public String getMatialStatus() {

        return matialStatus;
    }

    public void setMatialStatus(String matialStatus) {

        this.matialStatus = matialStatus;
    }

    public void setRelocate(boolean relocate) {

        this.relocate = relocate;
    }

    public String getPayrollNo() {

        return payrollNo;
    }

    public void setPayrollNo(String payrollNo) {

        this.payrollNo = payrollNo;
    }

    public String getNiNo() {

        return niNo;
    }

    public void setNiNo(String niNo) {

        this.niNo = niNo;
    }

    public String getPassPortNo() {

        return passPortNo;
    }

    public void setPassPortNo(String passPortNo) {

        this.passPortNo = passPortNo;
    }

    public String getVisaStatus() {

        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {

        this.visaStatus = visaStatus;
    }

    public String getNoticePeriod() {

        return noticePeriod;
    }

    public void setNoticePeriod(String noticePeriod) {

        this.noticePeriod = noticePeriod;
    }

    public String getAvailableDate() {

        return availableDate;
    }

    public void setAvailableDate(String availableDate) {

        this.availableDate = availableDate;
    }

    public List<CurrentPackage> getCurrentPackage() {

        return currentPackage;
    }

    public void setCurrentPackage(List<CurrentPackage> currentPackage) {

        this.currentPackage = currentPackage;
    }

    public List<CurrentBenefit> getCurrentBenefit() {

        return currentBenefit;
    }

    public void setCurrentBenefit(List<CurrentBenefit> currentBenefit) {

        this.currentBenefit = currentBenefit;
    }

    public Long getNationalityId() {

        return nationalityId;
    }

    public void setNationalityId(Long nationalityId) {

        this.nationalityId = nationalityId;
    }

    @Override
    public String toString() {

        return "PeopleDetail [peopleId=" + peopleId + ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", gender=" + gender + ", matialStatus=" + matialStatus
                + ", nationalityId=" + nationalityId + ", travel=" + travel + ", relocate=" + relocate + ", payrollNo=" + payrollNo + ", niNo=" + niNo + ", passPortNo="
                + passPortNo + ", visaStatus=" + visaStatus + ", noticePeriod=" + noticePeriod + ", availableDate=" + availableDate + ", currentPackage=" + currentPackage
                + ", currentBenefit=" + currentBenefit + "]";
    }

}
