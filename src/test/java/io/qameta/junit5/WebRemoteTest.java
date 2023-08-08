package io.qameta.junit5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.junit5.Helper.prepareEnvironmentPropertyReport;

public class WebRemoteTest {

    @BeforeAll
    public static void setUpAll(){

        Configuration.remote = "http://35.238.172.233:4444" + "/wd/hub";;
        Configuration.browser = "Chrome"; // System.getProperty("browserName");
        Configuration.browserVersion = "114.0";
        Configuration.browserSize = "1920x1080";

        Configuration.browserCapabilities.setCapability("selenoid:options",
                Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));

        prepareEnvironmentPropertyReport(Configuration.browser.toString(), Configuration.browserVersion.toString());
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Trying to open browsers");
        open( "http://51.250.6.164:3000" );
        System.out.println("browser Opened OK");
    }


    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }

    @Test
    public void incorrectLoginAndCheckPopup(){

        sleep( 2500 );

        $(By.id("username")).setValue("hello123");

        sleep( 2500 );

        $(By.id("password")).setValue("password");

        sleep( 2500 );
    }



}
