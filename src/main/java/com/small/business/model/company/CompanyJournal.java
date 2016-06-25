package com.small.business.model.company;

import com.small.business.model.base.BaseMessage;

public class CompanyJournal extends BaseMessage {

    private Long companyId = 0L;
    private Long journaType;
    private Long userId = 0L;
    private String notes;
    private String journalName;
    private String userName;
    private String dateCreated;

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

    public Long getJournaType() {

        return journaType;
    }

    public void setJournaType(Long journaType) {

        this.journaType = journaType;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public String getNotes() {

        return notes;
    }

    public void setNotes(String notes) {

        this.notes = notes;
    }

    public String getJournalName() {

        return journalName;
    }

    public void setJournalName(String journalName) {

        this.journalName = journalName;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getDateCreated() {

        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {

        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
        result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
        result = prime * result + ((journaType == null) ? 0 : journaType.hashCode());
        result = prime * result + ((journalName == null) ? 0 : journalName.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CompanyJournal other = (CompanyJournal) obj;
        if (companyId == null) {
            if (other.companyId != null)
                return false;
        } else if (!companyId.equals(other.companyId))
            return false;
        if (dateCreated == null) {
            if (other.dateCreated != null)
                return false;
        } else if (!dateCreated.equals(other.dateCreated))
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
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }

    @Override
    public String toString() {

        return "CompanyJournal [companyId=" + companyId + ", journaType=" + journaType + ", userId=" + userId + ", notes=" + notes + ", journalName=" + journalName
                + ", userName=" + userName + ", dateCreated=" + dateCreated + "]";
    }

}
