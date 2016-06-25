package com.small.business.model.assignment;

import com.small.business.model.base.BaseMessage;

public class AssignmentNotepad extends BaseMessage {

    private Long assignmentId = 0L;
    private String content;

    public Long getAssignmentId() {

        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {

        this.assignmentId = assignmentId;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    @Override
    public String toString() {

        return "AssignmentBrief [id=" + id + ", assignmentId=" + assignmentId + ", content=" + content + "]";
    }

}
