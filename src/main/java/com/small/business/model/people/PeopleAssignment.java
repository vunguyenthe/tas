package com.small.business.model.people;

import com.small.business.model.base.BaseMessage;

public class PeopleAssignment extends BaseMessage {

    private Long peopleId = 0L;
    private Long assignmentId = 0L;
    private Long companyId = 0L;
    private String assignmentName;
    private String companyName;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getPeopleId() {

        return peopleId;
    }

    public void setPeopleId(Long peopleId) {

        this.peopleId = peopleId;
    }

    public Long getAssignmentId() {

        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {

        this.assignmentId = assignmentId;
    }

    public Long getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Long companyId) {

        this.companyId = companyId;
    }

    public String getAssignmentName() {

        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {

        this.assignmentName = assignmentName;
    }

    public String getCompanyName() {

        return companyName;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((assignmentId == null) ? 0 : assignmentId.hashCode());
        result = prime * result + ((assignmentName == null) ? 0 : assignmentName.hashCode());
        result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
        result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((peopleId == null) ? 0 : peopleId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PeopleAssignment other = (PeopleAssignment) obj;
        if (assignmentId == null) {
            if (other.assignmentId != null)
                return false;
        } else if (!assignmentId.equals(other.assignmentId))
            return false;
        if (assignmentName == null) {
            if (other.assignmentName != null)
                return false;
        } else if (!assignmentName.equals(other.assignmentName))
            return false;
        if (companyId == null) {
            if (other.companyId != null)
                return false;
        } else if (!companyId.equals(other.companyId))
            return false;
        if (companyName == null) {
            if (other.companyName != null)
                return false;
        } else if (!companyName.equals(other.companyName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (peopleId == null) {
            if (other.peopleId != null)
                return false;
        } else if (!peopleId.equals(other.peopleId))
            return false;
        return true;
    }

    @Override
    public String toString() {

        return "PeopleAssignment [id=" + id + ", peopleId=" + peopleId + ", assignmentId=" + assignmentId + ", companyId=" + companyId + ", assignmentName=" + assignmentName
                + ", companyName=" + companyName + "]";
    }

}
