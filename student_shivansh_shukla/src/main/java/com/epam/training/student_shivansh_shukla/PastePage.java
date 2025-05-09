//package com.epam.training.student_shivansh_shukla;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class PastePage {
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    private By pasteContent = By.id("editor");
//    private By pasteTitle = By.name("title");
//    private By expirationDropdown = By.name("expire");
//    private By expiration10MinOption = By.xpath("//select[@name='expire']/option[contains(text(), '10 Minutes')]");
//    private By submitButton = By.cssSelector("button[type='submit']");
//
//    public PastePage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    public void enterPasteContent(String editor) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(pasteContent)).sendKeys(editor);
//    }
//
//    public void enterPasteTitle(String title) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(pasteTitle)).sendKeys(title);
//    }
//
//    public void setExpirationTo10Minutes() {
//        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(expirationDropdown));
//        dropdown.click();
//        wait.until(ExpectedConditions.elementToBeClickable(expiration10MinOption)).click();
//    }
//
//    public void submitPaste() {
//        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
//    }
//
//    public String getCreatedPasteTitle() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))).getText();
//    }
//}
package com.epam.training.student_shivansh_shukla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PastePage {
    WebDriver driver;

    // Locators
    By contentField = By.id("editor");
    By titleField = By.name("name");
    By expirationDropdown = By.name("expire");
    By submitButton = By.cssSelector("button[type='submit']");

    public PastePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter content
    public void enterContent(String editor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        WebElement contentElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(contentField)
        );
        contentElement.sendKeys(editor);
    }

    // Method to enter title
    public void enterTitle(String title) {
        WebElement titleElement = driver.findElement(titleField);
        titleElement.sendKeys(title);
    }

    // Method to set expiration
    public void setExpiration(String expire) {
        WebElement expirationElement = driver.findElement(expirationDropdown);
        expirationElement.click();
        WebElement option = driver.findElement(By.xpath("//option[contains(text(),'" + expire + "')]"));
        option.click();
    }

    // Method to submit the paste
    public void submitPaste() {
        driver.findElement(submitButton).click();
    }
}
