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
import com.google.gson.JsonSyntaxException;

public class RestActions {

    public static String getCatFact() {
        try (RestClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("catfact.ninja", 80, "http")))
                .getLowLevelClient()) {
            Request request = new Request("GET", "/fact");
            request.setJsonEntity("{}");
            Response response = client.performRequest(request);

            HttpEntity body = response.getEntity();
            /*- Should really parse this way
            XContentType type = XContentType.fromMediaType(body.getContentType().getValue());
            XContentParser parser = type.xContent()
                .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, body.getContent());
            */
            String json = new String(body.getContent().readAllBytes(), StandardCharsets.UTF_8).trim();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(json);
            return gson.toJson(je);
        } catch (UnsupportedOperationException | JsonSyntaxException | IOException e) {
            return "Request failed: " + e.getMessage();
        }
    }

    public static String getBoredActivity() {
        return getBoredActivity(null);
    }

    public static String getBoredActivity(String type) {
        try (RestClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("boredapi.com", 80, "http")))
                .getLowLevelClient()) {
            Request request = new Request("GET", "/api/activity" + (type == null ? "" : ("?type=" + type)));
            // request.setJsonEntity("{}");
            Response response = client.performRequest(request);

            HttpEntity body = response.getEntity();
            /*- Should really parse this way
            XContentType type = XContentType.fromMediaType(body.getContentType().getValue());
            XContentParser parser = type.xContent()
                .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, body.getContent());
            */
            String json = new String(body.getContent().readAllBytes(), StandardCharsets.UTF_8).trim();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(json);
            return gson.toJson(je);
        } catch (UnsupportedOperationException | JsonSyntaxException | IOException e) {
            return "Request failed: " + e.getMessage();
        }
    }
}
