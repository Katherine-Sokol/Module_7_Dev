package com.goit;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }
}
