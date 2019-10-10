package com.vladimir.kornilov.gpbtest;

import com.sun.media.jfxmedia.Media;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class HostConnectionTestWebClient {

    public static String getResult(String requestType, String json) {
        Mono<ClientResponse> result = WebClient.create().post().uri(builder ->
                builder.scheme("http")
                        .host("localhost").port(8080).path("request/").path(requestType)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(json)).exchange();

        return "Response = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
