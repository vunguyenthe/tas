package com.small.business.model.company;

import com.small.business.model.base.BaseMessage;

public class CompanyNotepad extends BaseMessage {

    private Long companyId = 0L;
    private String content;

    public Long getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Long companyId) {

        this.companyId = companyId;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    @Override
    public String toString() {

        return "CompanyNotepad [id=" + id + ", companyId=" + companyId + ", content=" + content + "]";
    }

}
