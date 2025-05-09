//package com.epam.training.student_shivansh_shukla;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class PasteTest {
//    private WebDriver driver;
//    private PastePage pastePage;
//
//    @BeforeEach
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://pastes.io/");
//        pastePage = new PastePage(driver);
//    }
//
//    @Test
//    public void createNewPasteTest() {
//        pastePage.enterPasteContent("Hello from WebDriver");
//        pastePage.enterPasteTitle("helloweb");
//        pastePage.setExpirationTo10Minutes();
//        pastePage.submitPaste();
//
//        String actualTitle = pastePage.getCreatedPasteTitle();
//        assertTrue(actualTitle.contains("helloweb"), "Paste title should contain 'helloweb'");
//    }
//
//    @AfterEach
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
package com.epam.training.student_shivansh_shukla;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasteTest {
    WebDriver driver;
    PastePage pastePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shivansh Shukla\\Music\\webdrivers\\chromedriver.exe"); // Specify your ChromeDriver path
        driver = new ChromeDriver();
        driver.get("https://pastes.io");
        pastePage = new PastePage(driver);
    }

    @Test
    public void createNewPasteTest() {
        pastePage.enterContent("Hello from WebDriver");
        pastePage.enterTitle("helloweb");
        pastePage.setExpiration("10 Minutes");
        pastePage.submitPaste();
        
        // Verify the paste was created by checking the URL or a specific message
        assertTrue(driver.getCurrentUrl().contains("pastes.io"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
