package com.small.business.model.base;

public class BaseTag extends BaseMessage {

    private Long industryId = 0L;
    private Long locationId = 0L;
    private Long positionFunId = 0L;
    private Long positionLevelId = 0L;
    private Long languageId = 0L;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getIndustryId() {

        return industryId;
    }

    public void setIndustryId(Long industryId) {

        this.industryId = industryId;
    }

    public Long getLocationId() {

        return locationId;
    }

    public void setLocationId(Long locationId) {

        this.locationId = locationId;
    }

    public Long getPositionFunId() {

        return positionFunId;
    }

    public void setPositionFunId(Long positionFunId) {

        this.positionFunId = positionFunId;
    }

    public Long getPositionLevelId() {

        return positionLevelId;
    }

    public void setPositionLevelId(Long positionLevelId) {

        this.positionLevelId = positionLevelId;
    }

    public Long getLanguageId() {

        return languageId;
    }

    public void setLanguageId(Long languageId) {

        this.languageId = languageId;
    }

    @Override
    public String toString() {

        return "BaseTag [industryId=" + industryId + ", locationId=" + locationId + ", positionFunId=" + positionFunId + ", positionLevelId=" + positionLevelId
                + ", languageId=" + languageId + "]";
    }

}
