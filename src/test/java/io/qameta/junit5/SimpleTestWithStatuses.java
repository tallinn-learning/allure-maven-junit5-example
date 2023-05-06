package io.qameta.junit5;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SimpleTestWithStatuses {

  @Test
  @Feature("Allure illistration feature")
  @Severity(SeverityLevel.NORMAL)
  @DisplayName("test features of allure: steps")
  @Description("this is a description \n of using \n allure reports")
  void testOutput() throws IOException {
    firstStep();
    secondStep();
    // 3
    //attachment();
  }

  @Step
  private void firstStep() {

  }

  @BeforeAll
  static void init() {
    System.out.println("@BeforeAll");
  }

  //@Step
  @Attachment
  private String secondStep() {
    Assertions.assertTrue( true );
    return "text attachment";
  }


  @Step
  @Attachment(value = "allure.png")
  private byte[] attachment() throws IOException {
    File image = new File("src/test/resources/allure.png");
    return Files.readAllBytes(image.toPath());
  }


  @Test
  @Disabled
  @Feature("Allure illistration feature")
  void skippedTest() {
    Assumptions.assumeTrue(false);
  }

  @Test
  @Feature("Feature killer")
  void failedTest() {
    Assertions.assertTrue(true);
  }

  @Test
  @Disabled
  @Feature("Feature killer")
  void testWithExceptions() {
    throw new RuntimeException("Exception ...");
  }

}
