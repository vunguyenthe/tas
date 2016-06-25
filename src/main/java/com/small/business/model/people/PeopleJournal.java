package com.small.business.model.people;

import com.small.business.model.base.BaseMessage;

public class PeopleJournal extends BaseMessage {

    private Long peopleId = 0L;
    private Long journaType;
    private Long userId = 0L;
    private String notes;
    private String userName;
    private String date;

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

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((journaType == null) ? 0 : journaType.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((peopleId == null) ? 0 : peopleId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
        PeopleJournal other = (PeopleJournal) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (journaType == null) {
            if (other.journaType != null)
                return false;
        } else if (!journaType.equals(other.journaType))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        if (peopleId == null) {
            if (other.peopleId != null)
                return false;
        } else if (!peopleId.equals(other.peopleId))
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

        return "PeopleJournal [id=" + id + ", peopleId=" + peopleId + ", journaType=" + journaType + ", userId=" + userId + ", notes=" + notes + ", userName=" + userName + "]";
    }

}
