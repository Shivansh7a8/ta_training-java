package com.epam.training.student_shivansh_shukla;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreatePasteTest {

    private WebDriver driver;
    private final String baseUrl = "https://pastebin.io/";
    private final String codeText = 
    	    "git config --global user.name  \"New Sheriff in Town\"\n" +
    	    	    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
    	    	    "git push origin master --force";

    private final String pasteTitle = "how to gain dominance among developers";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void createNewPasteSuccessfully() {
        driver.get(baseUrl);
        PastebinHomePage2 pastePage = new PastebinHomePage2(driver);

        pastePage.enterCode(codeText);
        pastePage.selectSyntaxHighlighting("Bash");
        pastePage.selectExpiration("10 Minutes");
        pastePage.enterPasteTitle(pasteTitle);
        pastePage.createNewPaste();

        // Stabilize: Wait for the result page to load (basic wait)
        Assertions.assertTimeoutPreemptively(java.time.Duration.ofSeconds(10), () -> {
            while (driver.getTitle().equals("Pastebin.com - #1 paste tool since 2002")) {
                Thread.sleep(500);
            }
        });

        // Verifications
        assertTrue(driver.getTitle().contains(pasteTitle), "Page title should contain paste title");

        String syntaxLabel = driver.findElement(By.xpath("//a[@class='btn -small h_800']")).getText();
        assertEquals("Bash", syntaxLabel, "Syntax highlighting should be Bash");

        String displayedCode = driver.findElement(By.xpath("//textarea[@class='textarea']")).getText();
        assertEquals(codeText.trim(), displayedCode.trim(), "The code content should match exactly");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
