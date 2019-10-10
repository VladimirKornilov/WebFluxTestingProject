package com.vladimir.kornilov.gpbtest.rest.rqrs;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 1L;

    private HostPath request;

    public HostPath getRequest() {
        return request;
    }

    public void setRequest(HostPath request) {
        this.request = request;
    }
}
