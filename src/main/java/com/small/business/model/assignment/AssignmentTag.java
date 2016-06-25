package com.small.business.model.assignment;

import com.small.business.model.base.BaseTag;

public class AssignmentTag extends BaseTag {

    private Long assignmentId = 0L;

    public Long getAssignmentId() {

        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {

        this.assignmentId = assignmentId;
    }

    @Override
    public String toString() {

        return "AssignmentTag [assignmentId=" + assignmentId + ", id=" + id + ", getId()=" + getId() + ", getIndustryId()=" + getIndustryId() + ", getLocationId()="
                + getLocationId() + ", getPositionFunId()=" + getPositionFunId() + ", getPositionLevelId()=" + getPositionLevelId() + ", getLanguageId()=" + getLanguageId()
                + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
    }

}
