package com.small.business.model.people;

import com.small.business.model.base.BaseMessage;

public class PeopleEducation extends BaseMessage {

    private Long peopleId = 0L;
    private Long journaType;
    private String qualification;
    private String institution;
    private Long yearStarted;
    private Long yearEnd;
    private String journalName;

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

    public Long getJournaType() {

        return journaType;
    }

    public void setJournaType(Long journaType) {

        this.journaType = journaType;
    }

    public String getQualification() {

        return qualification;
    }

    public void setQualification(String qualification) {

        this.qualification = qualification;
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

    public String getJournalName() {

        return journalName;
    }

    public void setJournalName(String journalName) {

        this.journalName = journalName;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((institution == null) ? 0 : institution.hashCode());
        result = prime * result + ((journaType == null) ? 0 : journaType.hashCode());
        result = prime * result + ((journalName == null) ? 0 : journalName.hashCode());
        result = prime * result + ((peopleId == null) ? 0 : peopleId.hashCode());
        result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
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
        PeopleEducation other = (PeopleEducation) obj;
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
        if (journaType == null) {
            if (other.journaType != null)
                return false;
        } else if (!journaType.equals(other.journaType))
            return false;
        if (journalName == null) {
            if (other.journalName != null)
                return false;
        } else if (!journalName.equals(other.journalName))
            return false;
        if (peopleId == null) {
            if (other.peopleId != null)
                return false;
        } else if (!peopleId.equals(other.peopleId))
            return false;
        if (qualification == null) {
            if (other.qualification != null)
                return false;
        } else if (!qualification.equals(other.qualification))
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

        return "PeopleEducation [id=" + id + ", peopleId=" + peopleId + ", journaType=" + journaType + ", qualification=" + qualification + ", institution=" + institution
                + ", yearStarted=" + yearStarted + ", yearEnd=" + yearEnd + ", journalName=" + journalName + "]";
    }

}
