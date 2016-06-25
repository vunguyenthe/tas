package com.small.business.model.company;

import com.small.business.model.base.BaseMessage;

public class CompanyPeople extends BaseMessage {

    private Long companyId = 0L;
    private Long peopleId = 0L;
    private String companyName;
    private String peopleName;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Long companyId) {

        this.companyId = companyId;
    }

    public Long getPeopleId() {

        return peopleId;
    }

    public void setPeopleId(Long peopleId) {

        this.peopleId = peopleId;
    }

    public String getCompanyName() {

        return companyName;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }

    public String getPeopleName() {

        return peopleName;
    }

    public void setPeopleName(String peopleName) {

        this.peopleName = peopleName;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
        result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((peopleId == null) ? 0 : peopleId.hashCode());
        result = prime * result + ((peopleName == null) ? 0 : peopleName.hashCode());
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
        CompanyPeople other = (CompanyPeople) obj;
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
        if (peopleName == null) {
            if (other.peopleName != null)
                return false;
        } else if (!peopleName.equals(other.peopleName))
            return false;
        return true;
    }

    @Override
    public String toString() {

        return "CompanyPeople [id=" + id + ", companyId=" + companyId + ", peopleId=" + peopleId + ", companyName=" + companyName + ", peopleName=" + peopleName + "]";
    }

}
