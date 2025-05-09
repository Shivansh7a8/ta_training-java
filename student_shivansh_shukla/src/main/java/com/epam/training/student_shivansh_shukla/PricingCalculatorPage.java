package com.epam.training.student_shivansh_shukla;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PricingCalculatorPage {
    private WebDriver driver;

    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'calculator')]")));
        driver.switchTo().frame("myFrame");
    }

    private By computeEngineTab = By.xpath("//md-tab-item//div[contains(text(),'Compute Engine')]");
    private By instancesInput = By.xpath("//input[@ng-model='listingCtrl.computeServer.quantity']");

    private By osDropdown = By.name("select_149");
    private By provisioningDropdown = By.name("select_153");
    private By machineFamilyDropdown = By.name("select_165");
    private By seriesDropdown = By.name("select_167");
    private By machineTypeDropdown = By.name("select_169");

    private By addGpuCheckbox = By.xpath("//md-checkbox[@aria-label='Add GPUs']");
    private By gpuTypeDropdown = By.name("select_503");
    private By numberOfGpuDropdown = By.name("select_505");

    private By localSsdDropdown = By.name("select_449");
    private By datacenterLocationDropdown = By.name("select_231");
    private By committedUsageDropdown = By.name("select_126");

    private By addToEstimateButton = By.xpath("//button[@aria-label='Add to Estimate']");

    private By totalEstimatedCost = By.xpath("//b[contains(text(),'Total Estimated Cost')]");

    private By shareButton = By.xpath("//button[@id='export']");
    private By openEstimateSummaryButton = By.xpath("//a[text()='Open estimate summary']");

    public void clickComputeEngineTab() {
        driver.findElement(computeEngineTab).click();
    }

    public void fillForm() {
        driver.findElement(instancesInput).sendKeys("4");

        selectDropdownByVisibleText(osDropdown, "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");
        selectDropdownByVisibleText(provisioningDropdown, "Regular");
        selectDropdownByVisibleText(machineFamilyDropdown, "General purpose");
        selectDropdownByVisibleText(seriesDropdown, "N1");
        selectDropdownByVisibleText(machineTypeDropdown, "n1-standard-8 (vCPUs: 8, RAM: 30GB)");

        driver.findElement(addGpuCheckbox).click();
        selectDropdownByVisibleText(gpuTypeDropdown, "NVIDIA Tesla V100");
        selectDropdownByVisibleText(numberOfGpuDropdown, "1");

        selectDropdownByVisibleText(localSsdDropdown, "2x375 GB");
        selectDropdownByVisibleText(datacenterLocationDropdown, "Frankfurt (europe-west3)");
        selectDropdownByVisibleText(committedUsageDropdown, "1 Year");
    }

    public void clickAddToEstimate() {
        driver.findElement(addToEstimateButton).click();
    }

    public String getEstimatedCostText() {
        return driver.findElement(totalEstimatedCost).getText();
    }

    public void clickShare() {
        driver.findElement(shareButton).click();
    }

    public void openEstimateSummary() {
        driver.findElement(openEstimateSummaryButton).click();
    }

    private void selectDropdownByVisibleText(By locator, String visibleText) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(visibleText);
    }
}
