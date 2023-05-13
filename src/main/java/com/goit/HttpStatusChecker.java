package com.goit;

import com.goit.exception.ImageNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final String URL = "https://http.cat";

    public String getStatusImage(int code) throws IOException, InterruptedException {
        String imageUrl = String.format("%s/%d.jpg", URL, code);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(imageUrl))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 404) {
            throw new ImageNotFoundException("There is not image for HTTP status " + code);
        }
        return imageUrl;
    }
}
