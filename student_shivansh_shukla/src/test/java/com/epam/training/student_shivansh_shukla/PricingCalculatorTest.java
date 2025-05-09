package com.epam.training.student_shivansh_shukla;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PricingCalculatorTest {
    private WebDriver driver;
    private String estimatedCostText;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testPricingCalculatorEstimate() throws InterruptedException {
        CloudHomePage homePage = new CloudHomePage(driver);
        homePage.open();
        homePage.clickSearchIcon();
        homePage.searchFor("Google Cloud Pricing Calculator");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.clickCalculatorLink();

        PricingCalculatorPage calculatorPage = new PricingCalculatorPage(driver);
        calculatorPage.clickComputeEngineTab();
        calculatorPage.fillForm();
        calculatorPage.clickAddToEstimate();

        estimatedCostText = calculatorPage.getEstimatedCostText();
        assertTrue(estimatedCostText.contains("Total Estimated Cost"), "Estimated cost is displayed");

        calculatorPage.clickShare();
        calculatorPage.openEstimateSummary();

        // Switch to new tab
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        EstimateSummaryPage summaryPage = new EstimateSummaryPage(driver);
        boolean summaryValid = summaryPage.verifySummaryContains(
                "4",
                "n1-standard-8",
                "NVIDIA Tesla V100",
                "2x375 GB",
                "Frankfurt",
                "1 Year"
        );

        assertTrue(summaryValid, "Summary page contains expected values");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
