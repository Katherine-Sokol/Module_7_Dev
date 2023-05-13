package com.goit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class HttpStatusImageDownloader {
    private static final String FILE_STORAGE_FOLDER = "images";
    private static final String USER_FOLDER = System.getProperty("user.dir");
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public void downloadStatusImage(int code) throws IOException, InterruptedException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String imageUrl = httpStatusChecker.getStatusImage(code);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(imageUrl))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        byte[] bytes = response.body().getBytes(StandardCharsets.UTF_8);
        createImage(code, bytes);
    }

    private static void createImage(int code, byte[] bytes) {
        File file = new File( USER_FOLDER + File.separator + FILE_STORAGE_FOLDER + File.separator + code + ".jpg");
        File parentDir = file.getParentFile();
        if(! parentDir.exists())
            parentDir.mkdirs();
        try (FileOutputStream fis = new FileOutputStream(file)){
            fis.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
