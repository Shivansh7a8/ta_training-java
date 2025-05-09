package com.epam.training.student_shivansh_shukla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstimateSummaryPage {
    private WebDriver driver;

    private By summaryTable = By.xpath("//div[contains(@class, 'summary')]");

    public EstimateSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifySummaryContains(String... expectedTexts) {
        String summaryText = driver.findElement(summaryTable).getText();
        for (String text : expectedTexts) {
            if (!summaryText.contains(text)) {
                return false;
            }
        }
        return true;
    }
}
