package com.small.business.model.company;

import com.small.business.model.base.BaseMessage;

public class CompanyProfile extends BaseMessage {

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

        return "CompanyProfile [id=" + id + ", companyId=" + companyId + ", content=" + content + "]";
    }

}
