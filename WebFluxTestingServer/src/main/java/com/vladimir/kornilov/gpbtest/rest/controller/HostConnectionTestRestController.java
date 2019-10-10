package com.vladimir.kornilov.gpbtest.rest.controller;

import com.vladimir.kornilov.gpbtest.business.HostConnectionTestBusinessService;
import com.vladimir.kornilov.gpbtest.rest.rqrs.Request;
import com.vladimir.kornilov.gpbtest.rest.rqrs.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class HostConnectionTestRestController {

    @Autowired
    private HostConnectionTestBusinessService hostConnectionTestBusinessService;

    @RequestMapping(value = "/request/v1", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response> getHtml(@RequestBody Request request) {
        if(request.getRequest() != null) {
            request.getRequest().setPath(null);
        }
        return Mono.just(hostConnectionTestBusinessService.getHtml(request));
    }

    @RequestMapping(value = "/request/v2", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response> getBracketsCount(@RequestBody Request request){
        if(request.getRequest() != null) {
            request.getRequest().setHost(null);
        }
        return Mono.just(hostConnectionTestBusinessService.getOpenBracketsCount(request));
    }
}
