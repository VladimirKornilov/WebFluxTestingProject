package com.vladimir.kornilov;

public class Main {
    private static final String STR1 = "Hello, ";
    private static final String STR2 = "World!";

    public static void main(String... args) {
        String result = ConcatenateWebClient.getResult(STR1,STR2);
        System.out.println(result);
    }
}
