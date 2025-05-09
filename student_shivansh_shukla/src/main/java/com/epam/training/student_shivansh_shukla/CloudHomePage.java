package com.epam.training.student_shivansh_shukla;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudHomePage {
    private WebDriver driver;

    private By searchIcon = By.xpath("//button[@aria-label='Search']");
    private By searchInput = By.name("q");

    public CloudHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://cloud.google.com/");
    }

    public void clickSearchIcon() {
        driver.findElement(searchIcon).click();
    }

    public void searchFor(String text) {
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchInput).submit();
    }
}
