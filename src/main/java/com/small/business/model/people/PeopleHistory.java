package com.small.business.model.people;

import com.small.business.model.base.BaseMessage;

public class PeopleHistory extends BaseMessage {

    private Long peopleId = 0L;
    private String jobTitle;
    private Long companyId;
    private String institution;
    private Long yearStarted;
    private Long yearEnd;
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

    public String getJobTitle() {

        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {

        this.jobTitle = jobTitle;
    }

    public Long getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Long companyId) {

        this.companyId = companyId;
    }

    public String getInstitution() {

        return institution;
    }

    public void setInstitution(String institution) {

        this.institution = institution;
    }

    public Long getYearStarted() {

        return yearStarted;
    }

    public void setYearStarted(Long yearStarted) {

        this.yearStarted = yearStarted;
    }

    public Long getYearEnd() {

        return yearEnd;
    }

    public void setYearEnd(Long yearEnd) {

        this.yearEnd = yearEnd;
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
        result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
        result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((institution == null) ? 0 : institution.hashCode());
        result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
        result = prime * result + ((peopleId == null) ? 0 : peopleId.hashCode());
        result = prime * result + ((yearEnd == null) ? 0 : yearEnd.hashCode());
        result = prime * result + ((yearStarted == null) ? 0 : yearStarted.hashCode());
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
        PeopleHistory other = (PeopleHistory) obj;
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
        if (institution == null) {
            if (other.institution != null)
                return false;
        } else if (!institution.equals(other.institution))
            return false;
        if (jobTitle == null) {
            if (other.jobTitle != null)
                return false;
        } else if (!jobTitle.equals(other.jobTitle))
            return false;
        if (peopleId == null) {
            if (other.peopleId != null)
                return false;
        } else if (!peopleId.equals(other.peopleId))
            return false;
        if (yearEnd == null) {
            if (other.yearEnd != null)
                return false;
        } else if (!yearEnd.equals(other.yearEnd))
            return false;
        if (yearStarted == null) {
            if (other.yearStarted != null)
                return false;
        } else if (!yearStarted.equals(other.yearStarted))
            return false;
        return true;
    }

    @Override
    public String toString() {

        return "PeopleHistory [id=" + id + ", peopleId=" + peopleId + ", jobTitle=" + jobTitle + ", companyId=" + companyId + ", institution=" + institution + ", yearStarted="
                + yearStarted + ", yearEnd=" + yearEnd + ", companyName=" + companyName + "]";
    }

}
