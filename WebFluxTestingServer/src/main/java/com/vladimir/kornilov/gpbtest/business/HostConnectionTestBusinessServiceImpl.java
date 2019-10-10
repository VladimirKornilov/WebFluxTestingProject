package com.vladimir.kornilov.gpbtest.business;

import com.vladimir.kornilov.gpbtest.rest.rqrs.Request;
import com.vladimir.kornilov.gpbtest.rest.rqrs.Response;
import com.vladimir.kornilov.gpbtest.rest.rqrs.ResponseAnswer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HostConnectionTestBusinessServiceImpl implements HostConnectionTestBusinessService{

    @Value("${test.host}")
    private String testHost;

    @Value("${test.path}")
    private String testPath;

    private final static String USER_AGENT = "User-Agent";
    private final static String USER_AGENT_VALUE = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)";
    private final static String ACCEPT_CHARSET = "Accept-Charset";
    private final static String CHARSET_VALUE = "UTF-8";

    private final static String HTML_TAG = "<html>";
    private final static String HTML_TAG_CLOSED = "</html>";
    private final static String SCRIPT_TAG = "<script>";
    private final static String SCRIPT_TAG_CLOSED = "</script>";

    private final static char BRACKET_PATTERN = '<';

    @Override
    public Response getHtml(Request request) {
        Response response = new Response(new ResponseAnswer());
        response.getResponse().setAnswer(getHtmlText(request, false));
        return response;
    }

    @Override
    public Response getOpenBracketsCount(Request request) {
        Response response = new Response(new ResponseAnswer());
        response.getResponse().setAnswer(
                Long.toString(getHtmlText(request, true).chars().filter(c -> c == BRACKET_PATTERN).count()));
        return response;
    }

    private String getHtmlText(Request request, boolean removeScript) {
        String host = null;
        String path = null;
        if (request.getRequest() != null) {
            host = request.getRequest().getHost();
            path = request.getRequest().getPath();
        }
        if (StringUtils.isEmpty(host)) {
            host = testHost;
        }

        if (StringUtils.isEmpty(path)) {
            path = testPath;
        }
        String html = readHtmlFromWebSite(host + path);
        if(html == null || !html.contains(HTML_TAG)) {
            return "";
        }

        List<String> tagsToRemove = new ArrayList<>(Arrays.asList(HTML_TAG, HTML_TAG_CLOSED));
        if(removeScript) {
            tagsToRemove.add(SCRIPT_TAG);
            tagsToRemove.add(SCRIPT_TAG_CLOSED);
        }
        html = removeTags(html, tagsToRemove);

        return html;
    }

    private String readHtmlFromWebSite(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty(USER_AGENT, USER_AGENT_VALUE);
            connection.setRequestProperty(ACCEPT_CHARSET, CHARSET_VALUE);
            connection.connect();
            if(connection.getResponseCode() != 200) {
                return "not200";
            }

            InputStream stream = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(stream, CHARSET_VALUE));

            StringBuilder html = new StringBuilder();
            String line;
            while((line = br.readLine()) != null) {
                html.append(line);
            }
            return html.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return "not200";
        }
    }

    private String removeTags(String html, List<String> tagsToRemove) {
        String patternString =  "(" + tagsToRemove.stream().collect(Collectors.joining("|")) + ")";
        return html.replaceAll(patternString, "");
    }
}