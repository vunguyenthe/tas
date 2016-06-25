package com.small.business.model.assignment;

import java.util.ArrayList;
import java.util.List;

import com.small.business.model.base.BaseMessage;

public class Assignment extends BaseMessage {

    private String assignment;
    private String language;
    private String industry;
    private String assignmenetSt;
    private String engagement;
    private Long clientId;
    private String location;
    private String department;
    private Long primaryContactId;
    private Long otherContactId;
    private String signedContract;
    private String clientName;
    private String primaryContactName;
    private String otherContactName;
    private List<AssignmentBrief> briefs = new ArrayList<>();
    private List<AssignmentNotepad> notepads = new ArrayList<>();
    private List<AssignmentCandidate> candidates = new ArrayList<>();
    private AssignmentTag assignmentTag = new AssignmentTag();

    public String getAssignment() {

        return assignment;
    }

    public void setAssignment(String assignment) {

        this.assignment = assignment;
    }

    public String getLanguage() {

        return language;
    }

    public void setLanguage(String language) {

        this.language = language;
    }

    public String getIndustry() {

        return industry;
    }

    public void setIndustry(String industry) {

        this.industry = industry;
    }

    public String getAssignmenetSt() {

        return assignmenetSt;
    }

    public void setAssignmenetSt(String assignmenetSt) {

        this.assignmenetSt = assignmenetSt;
    }

    public String getEngagement() {

        return engagement;
    }

    public void setEngagement(String engagement) {

        this.engagement = engagement;
    }

    public Long getClientId() {

        return clientId;
    }

    public void setClientId(Long clientId) {

        this.clientId = clientId;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }

    public Long getPrimaryContactId() {

        return primaryContactId;
    }

    public void setPrimaryContactId(Long primaryContactId) {

        this.primaryContactId = primaryContactId;
    }

    public Long getOtherContactId() {

        return otherContactId;
    }

    public void setOtherContactId(Long otherContactId) {

        this.otherContactId = otherContactId;
    }

    public String getSignedContract() {

        return signedContract;
    }

    public void setSignedContract(String signedContract) {

        this.signedContract = signedContract;
    }

    public List<AssignmentBrief> getBriefs() {

        return briefs;
    }

    public void setBriefs(List<AssignmentBrief> briefs) {

        this.briefs = briefs;
    }

    public List<AssignmentNotepad> getNotepads() {

        return notepads;
    }

    public void setNotepads(List<AssignmentNotepad> notepads) {

        this.notepads = notepads;
    }

    public List<AssignmentCandidate> getCandidates() {

        return candidates;
    }

    public void setCandidates(List<AssignmentCandidate> candidates) {

        this.candidates = candidates;
    }

    public String getClientName() {

        return clientName;
    }

    public void setClientName(String clientName) {

        this.clientName = clientName;
    }

    public String getPrimaryContactName() {

        return primaryContactName;
    }

    public void setPrimaryContactName(String primaryContactName) {

        this.primaryContactName = primaryContactName;
    }

    public String getOtherContactName() {

        return otherContactName;
    }

    public void setOtherContactName(String otherContactName) {

        this.otherContactName = otherContactName;
    }

    public AssignmentTag getAssignmentTag() {

        return assignmentTag;
    }

    public void setAssignmentTag(AssignmentTag assignmentTag) {

        this.assignmentTag = assignmentTag;
    }

    @Override
    public String toString() {

        return "Assignment [id=" + id + ", assignment=" + assignment + ", language=" + language + ", industry=" + industry + ", assignmenetSt=" + assignmenetSt
                + ", engagement=" + engagement + ", clientId=" + clientId + ", location=" + location + ", department=" + department + ", primaryContactId=" + primaryContactId
                + ", otherContactId=" + otherContactId + ", signedContract=" + signedContract + ", briefs=" + briefs + ", notepads=" + notepads + ", candidates=" + candidates
                + "]";
    }

}
