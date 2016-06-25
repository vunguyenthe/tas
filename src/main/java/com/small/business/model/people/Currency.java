package com.small.business.model.people;

import com.small.business.model.base.BaseMessage;

public class Currency extends BaseMessage {

    String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return "Currency [name=" + name + "]";
    }

}
