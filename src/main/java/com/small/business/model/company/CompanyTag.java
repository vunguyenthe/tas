package com.small.business.model.company;

import com.small.business.model.base.BaseTag;

public class CompanyTag extends BaseTag {

    private Long companyId = 0L;

    public Long getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Long companyId) {

        this.companyId = companyId;
    }

    @Override
    public String toString() {

        return "CompanyTag [companyId=" + companyId + ", id=" + id + ", getId()=" + getId() + ", getIndustryId()=" + getIndustryId() + ", getLocationId()=" + getLocationId()
                + ", getPositionFunId()=" + getPositionFunId() + ", getPositionLevelId()=" + getPositionLevelId() + ", getLanguageId()=" + getLanguageId() + ", toString()="
                + super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
    }

}
