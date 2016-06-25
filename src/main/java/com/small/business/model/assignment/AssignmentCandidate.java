package com.small.business.model.assignment;

import com.small.business.model.base.BaseMessage;

public class AssignmentCandidate extends BaseMessage {

    private Long assignmentId = 0L;
    private Long userId;
    private Long candidateId = 0L;
    private String candidateName;
    private String details;
    private String dateCreated;

    public Long getAssignmentId() {

        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {

        this.assignmentId = assignmentId;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public Long getCandidateId() {

        return candidateId;
    }

    public void setCandidateId(Long candidateId) {

        this.candidateId = candidateId;
    }

    public String getCandidateName() {

        return candidateName;
    }

    public void setCandidateName(String candidateName) {

        this.candidateName = candidateName;
    }

    public String getDetails() {

        return details;
    }

    public void setDetails(String details) {

        this.details = details;
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
        result = prime * result + ((assignmentId == null) ? 0 : assignmentId.hashCode());
        result = prime * result + ((candidateId == null) ? 0 : candidateId.hashCode());
        result = prime * result + ((candidateName == null) ? 0 : candidateName.hashCode());
        result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
        result = prime * result + ((details == null) ? 0 : details.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
        AssignmentCandidate other = (AssignmentCandidate) obj;
        if (assignmentId == null) {
            if (other.assignmentId != null)
                return false;
        } else if (!assignmentId.equals(other.assignmentId))
            return false;
        if (candidateId == null) {
            if (other.candidateId != null)
                return false;
        } else if (!candidateId.equals(other.candidateId))
            return false;
        if (candidateName == null) {
            if (other.candidateName != null)
                return false;
        } else if (!candidateName.equals(other.candidateName))
            return false;
        if (dateCreated == null) {
            if (other.dateCreated != null)
                return false;
        } else if (!dateCreated.equals(other.dateCreated))
            return false;
        if (details == null) {
            if (other.details != null)
                return false;
        } else if (!details.equals(other.details))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public String toString() {

        return "AssignmentCandidate [id=" + id + ", assignmentId=" + assignmentId + ", userId=" + userId + ", candidateId=" + candidateId + ", candidateName=" + candidateName
                + ", details=" + details + ", dateCreated=" + dateCreated + "]";
    }

}
