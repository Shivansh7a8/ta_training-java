package com.epam.training.student_shivansh_shukla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.Select;

public class PastebinHomePage2 {

    private WebDriver driver;

    // Locators
    private By pasteTextArea = By.id("postform-text");
    private By syntaxHighlightingDropdown = By.id("select2-postform-format-container");
    private By syntaxHighlightingOption = By.xpath("//li[text()='Bash']");
    private By expirationDropdown = By.id("select2-postform-expiration-container");
    private By expirationOption = By.xpath("//li[text()='10 Minutes']");
    private By pasteTitleInput = By.id("postform-name");
    private By createPasteButton = By.xpath("//button[text()='Create New Paste']");

    public PastebinHomePage2(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCode(String code) {
        driver.findElement(pasteTextArea).sendKeys(code);
    }

    public void selectSyntaxHighlighting(String syntax) {
        driver.findElement(syntaxHighlightingDropdown).click();
        driver.findElement(syntaxHighlightingOption).click();
    }

    public void selectExpiration(String expiration) {
        driver.findElement(expirationDropdown).click();
        driver.findElement(expirationOption).click();
    }

    public void enterPasteTitle(String title) {
        driver.findElement(pasteTitleInput).sendKeys(title);
    }

    public void createNewPaste() {
        driver.findElement(createPasteButton).click();
    }
}
