package com.vladimir.kornilov.gpbtest.rest.rqrs;

import java.io.Serializable;

public class Response implements Serializable{
    private static final long serialVersionUID = 1L;

    private ResponseAnswer response;

    public Response(){}

    public Response(ResponseAnswer response){
        this.response = response;
    }

    public ResponseAnswer getResponse() {
        return response;
    }

    public void setResponse(ResponseAnswer response) {
        this.response = response;
    }
}
