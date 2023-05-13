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
        for (int code : codes) {
            String url = httpStatusChecker.getStatusImage(code);
            Assertions.assertEquals("https://http.cat/" + code + ".jpg", url);
        }
    }

    @Test
    void testThatExceptionThrowsCorrectly(){
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        int [] codes = {1000, 2000, -1};
        for (int code : codes) {
            Assertions.assertThrows(ImageNotFoundException.class, () -> httpStatusChecker.getStatusImage(code));
        }
    }

}