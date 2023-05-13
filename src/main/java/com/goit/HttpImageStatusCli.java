package com.goit;

import com.goit.exception.ImageNotFoundException;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

    public void askStatus() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int code;
        System.out.println("Enter HTTP status code");
        while (scanner.hasNext()) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    code = Integer.parseInt(line);
                } catch (RuntimeException e) {
                    System.out.println("Please enter valid number");
                    continue;
                }
                try {
                    httpStatusImageDownloader.downloadStatusImage(code);
                } catch (ImageNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
