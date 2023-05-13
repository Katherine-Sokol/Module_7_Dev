package com.goit;

import com.goit.exception.ImageNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class HttpStatusCheckerTests {

    @Test
    void testThatStatusImageIsGottenCorrectly() throws IOException, InterruptedException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        int [] codes = {100, 101, 200, 201, 204, 300, 400, 404, 500, 501};
        for (int i = 0; i < codes.length; i++) {
            String url = httpStatusChecker.getStatusImage(codes[i]);
            Assertions.assertEquals("https://http.cat/" + codes[i] + ".jpg", url);
        }
    }

    @Test
    void testThatExceptionThrowsCorrectly() throws IOException, InterruptedException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        int [] codes = {1000, 2000, -1};
        for (int code : codes) {
            Assertions.assertThrows(ImageNotFoundException.class, () -> httpStatusChecker.getStatusImage(code));
        }
    }

}