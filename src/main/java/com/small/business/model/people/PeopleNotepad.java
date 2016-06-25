package com.small.business.model.people;

import com.small.business.model.base.BaseMessage;

public class PeopleNotepad extends BaseMessage {

    private Long peopleId = 0L;
    private String content;

    public Long getPeopleId() {

        return peopleId;
    }

    public void setPeopleId(Long peopleId) {

        this.peopleId = peopleId;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    @Override
    public String toString() {

        return "PeopleBrief [id=" + id + ", peopleId=" + peopleId + ", content=" + content + "]";
    }

}
