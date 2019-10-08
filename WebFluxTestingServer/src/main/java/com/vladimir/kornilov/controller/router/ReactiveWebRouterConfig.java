package com.vladimir.kornilov.controller.router;

import com.vladimir.kornilov.controller.handler.ConcatenateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ReactiveWebRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(ConcatenateHandler concatenateHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/concatenate")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        concatenateHandler::hello);
    }
}
