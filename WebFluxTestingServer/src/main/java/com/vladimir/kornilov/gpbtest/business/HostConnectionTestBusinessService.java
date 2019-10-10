package com.vladimir.kornilov.gpbtest.business;

import com.vladimir.kornilov.gpbtest.rest.rqrs.Request;
import com.vladimir.kornilov.gpbtest.rest.rqrs.Response;

public interface HostConnectionTestBusinessService {

    Response getHtml(Request request);
    Response getOpenBracketsCount(Request request);
}
