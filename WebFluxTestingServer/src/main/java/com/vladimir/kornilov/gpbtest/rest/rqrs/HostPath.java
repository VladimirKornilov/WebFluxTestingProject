package com.vladimir.kornilov.gpbtest.rest.rqrs;

import java.io.Serializable;

public class HostPath implements Serializable {
    private static final long serialVersionUID = 1L;

    private String host;
    private String path;

    public HostPath(){}

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
