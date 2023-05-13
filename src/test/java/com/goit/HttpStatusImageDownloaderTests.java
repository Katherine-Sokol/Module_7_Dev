package com.goit;

import org.junit.jupiter.api.Test;
import java.io.IOException;

class HttpStatusImageDownloaderTests {

    @Test
    void testThatImageDownloadedCorrectly() throws IOException, InterruptedException {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        int[] codes = {100, 101, 200, 201, 204, 300, 400, 404, 500, 501};
        for (int code : codes) {
            httpStatusImageDownloader.downloadStatusImage(code);
        }
    }
}