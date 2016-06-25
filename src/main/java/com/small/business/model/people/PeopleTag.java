package com.small.business.model.people;

import com.small.business.model.base.BaseTag;

public class PeopleTag extends BaseTag {

    private Long PeopleId = 0L;

    public Long getPeopleId() {

        return PeopleId;
    }

    public void setPeopleId(Long peopleId) {

        PeopleId = peopleId;
    }

    @Override
    public String toString() {

        return "PeopleTag [PeopleId=" + PeopleId + ", id=" + id + ", getId()=" + getId() + ", getIndustryId()=" + getIndustryId() + ", getLocationId()=" + getLocationId()
                + ", getPositionFunId()=" + getPositionFunId() + ", getPositionLevelId()=" + getPositionLevelId() + ", getLanguageId()=" + getLanguageId() + ", toString()="
                + super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
    }

}
