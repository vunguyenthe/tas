package com.small.business.model.people;

import com.small.business.model.base.BaseMessage;

public class CurrentBenefit extends BaseMessage {

    private Long peopleId = 0L;
    private String benefit;

    public Long getPeopleId() {

        return peopleId;
    }

    public void setPeopleId(Long peopleId) {

        this.peopleId = peopleId;
    }

    public String getBenefit() {

        return benefit;
    }

    public void setBenefit(String benefit) {

        this.benefit = benefit;
    }

    @Override
    public String toString() {

        return "CurrentBenefit [peopleId=" + peopleId + ", benefit=" + benefit + "]";
    }

}
