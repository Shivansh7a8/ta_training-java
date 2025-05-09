package com.epam.training.student_shivansh_shukla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;

    private By calculatorLink = By.xpath("//a/b[text()='Google Cloud Pricing Calculator']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCalculatorLink() {
        driver.findElement(calculatorLink).click();
    }
}
