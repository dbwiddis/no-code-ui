/*
 * Copyright 2023 The Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package ui.rest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.opensearch.client.Request;
import org.opensearch.client.Response;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestHighLevelClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class RestActions {

    private static final RestClient CLIENT = new RestHighLevelClient(
            RestClient.builder(new HttpHost("cat-fact.herokuapp.com", 80, "http"))).getLowLevelClient();

    public static String testAPI() {
        Request request = new Request("GET", "/facts");
        request.setJsonEntity("{}");
        Response response;
        try {
            response = CLIENT.performRequest(request);
            HttpEntity body = response.getEntity();
//            XContentType type = XContentType.fromFormat(body.getContentType().getValue());
//            XContentParser parser = type.xContent().createParser(NamedXContentRegistry.EMPTY,
//                    LoggingDeprecationHandler.INSTANCE, body.getContent());
            String type = body.getContentType().getValue();
            String json = new String(body.getContent().readAllBytes(), StandardCharsets.UTF_8).trim();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(json);
            return type + "\n" + gson.toJson(je);
        } catch (UnsupportedOperationException | IOException e) {
            return "Request failed: " + e.getMessage();
        }
    }
}
