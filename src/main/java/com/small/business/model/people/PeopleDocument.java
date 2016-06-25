package com.small.business.model.people;

import com.small.business.model.base.BaseMessage;

public class PeopleDocument extends BaseMessage {

    private Long peopleId = 0L;
    private String documentName;
    private String documentPath;
    private String notes;
    private String createBy;
    private String dateCreated;

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

    public String getDocumentName() {

        return documentName;
    }

    public void setDocumentName(String documentName) {

        this.documentName = documentName;
    }

    public String getDocumentPath() {

        return documentPath;
    }

    public void setDocumentPath(String documentPath) {

        this.documentPath = documentPath;
    }

    public String getNotes() {

        return notes;
    }

    public void setNotes(String notes) {

        this.notes = notes;
    }

    public String getCreateBy() {

        return createBy;
    }

    public void setCreateBy(String createBy) {

        this.createBy = createBy;
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
        int result = 1;
        result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
        result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
        result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
        result = prime * result + ((documentPath == null) ? 0 : documentPath.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
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
        PeopleDocument other = (PeopleDocument) obj;
        if (createBy == null) {
            if (other.createBy != null)
                return false;
        } else if (!createBy.equals(other.createBy))
            return false;
        if (dateCreated == null) {
            if (other.dateCreated != null)
                return false;
        } else if (!dateCreated.equals(other.dateCreated))
            return false;
        if (documentName == null) {
            if (other.documentName != null)
                return false;
        } else if (!documentName.equals(other.documentName))
            return false;
        if (documentPath == null) {
            if (other.documentPath != null)
                return false;
        } else if (!documentPath.equals(other.documentPath))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
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
        return true;
    }

    @Override
    public String toString() {

        return "PeopleDocument [id=" + id + ", peopleId=" + peopleId + ", documentName=" + documentName + ", documentPath=" + documentPath + ", notes=" + notes + ", createBy="
                + createBy + ", dateCreated=" + dateCreated + "]";
    }

}
