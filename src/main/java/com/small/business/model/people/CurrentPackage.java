package com.small.business.model.people;

import com.small.business.model.base.BaseMessage;

public class CurrentPackage extends BaseMessage {

    private String packageName;
    private Long peopleId = 0l;
    private String total;
    private Long currencyId = 0L;
    private String period;
    private String notes;

    public String getPackageName() {

        return packageName;
    }

    public void setPackageName(String packageName) {

        this.packageName = packageName;
    }

    public String getTotal() {

        return total;
    }

    public void setTotal(String total) {

        this.total = total;
    }

    public Long getCurrencyId() {

        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {

        this.currencyId = currencyId;
    }

    public String getPeriod() {

        return period;
    }

    public void setPeriod(String period) {

        this.period = period;
    }

    public String getNotes() {

        return notes;
    }

    public void setNotes(String notes) {

        this.notes = notes;
    }

    public Long getPeopleId() {

        return peopleId;
    }

    public void setPeopleId(Long peopleId) {

        this.peopleId = peopleId;
    }

    @Override
    public String toString() {

        return "CurrentPackage [packageName=" + packageName + ", peopleId=" + peopleId + ", total=" + total + ", currencyId=" + currencyId + ", period=" + period + ", notes="
                + notes + "]";
    }

}
