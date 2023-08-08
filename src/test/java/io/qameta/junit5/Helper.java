package io.qameta.junit5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Helper {

    public static void prepareEnvironmentPropertyReport(String browser, String version) {
        Properties properties = new Properties();

        if (browser != null) {
            properties.setProperty("Browser", browser);
            properties.setProperty("Browser.Version", version);
        }

        properties.setProperty("Stand", "Production");

        String allureResultsDirectory = "target/allure-results"; // Replace with your actual path

        try (FileOutputStream outputStream = new FileOutputStream(allureResultsDirectory + "/environment.properties")) {
            properties.store(outputStream, "Environment Configuration for Allure Report");
            System.out.println("environment.properties file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
