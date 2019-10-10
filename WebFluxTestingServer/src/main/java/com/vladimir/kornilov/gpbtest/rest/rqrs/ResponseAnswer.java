package com.vladimir.kornilov.gpbtest.rest.rqrs;

import java.io.Serializable;

public class ResponseAnswer implements Serializable{
    private static final long serialVersionUID = 1L;

    private String answer;

    public ResponseAnswer(){
        this.answer = "";
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
