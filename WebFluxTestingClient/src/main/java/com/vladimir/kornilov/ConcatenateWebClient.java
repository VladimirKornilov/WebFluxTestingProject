package com.vladimir.kornilov;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.function.Function;

public class ConcatenateWebClient {
    public static String getResult(String str1, String str2) {

//        WebClient.RequestHeadersUriSpec headers = WebClient.create().get();
//        headers.uri("http://localhost:8080/concatenate/?str1=Hello&str2=World");
//        headers.accept(MediaType.TEXT_PLAIN);
//
//        WebClient.RequestHeadersUriSpec headers2 = WebClient.create().get();
//        Function<UriBuilder, URI> uriFunction = builder -> builder.scheme("http").host("localhost").port(8080).path("concatenate").queryParam("str1", str1).queryParam("str2", str2).build();
//        headers2.uri(uriFunction);
//        headers2.accept(MediaType.TEXT_PLAIN);
////        headers.uri((Function<UriBuilder, URI>) builder -> builder.scheme("http")
////                .host("localhost").port(8080).path("concatenate")
////                .queryParam("str1", str1)
////                .queryParam("str2", str2)
////                .build());
//
//        Mono<ClientResponse> result = headers.exchange();
//        Mono<ClientResponse> result2 = headers2.exchange();
//
//        System.out.println(">> result1 = " + result.flatMap(res -> res.bodyToMono(String.class)).block());
//        System.out.println(">> result2 = " + result2.flatMap(res -> res.bodyToMono(String.class)).block());
        Mono<ClientResponse> result = WebClient.create().get().uri(builder ->
                builder.scheme("http")
                        .host("localhost").port(8080).path("concatenate")
                        .queryParam("str1", str1)
                        .queryParam("str2", str2)
                        .build()).accept(MediaType.TEXT_PLAIN).exchange();
        return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
