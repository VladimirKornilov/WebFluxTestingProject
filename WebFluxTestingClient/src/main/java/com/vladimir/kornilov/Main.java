package com.vladimir.kornilov;

import com.vladimir.kornilov.gpbtest.HostConnectionTestWebClient;

public class Main {

    private static final String REQUEST_TYPE_V1 = "v1";
    private static final String REQUEST_TYPE_V2 = "v2";

    public static void main(String... args) {
        String json = "{\"request\": {\"host\":\"https://habr.com\", \"path\":\"/ru/top/\"}}";
        String result = HostConnectionTestWebClient.getResult(REQUEST_TYPE_V2, json);
        System.out.println(result);
    }
}
