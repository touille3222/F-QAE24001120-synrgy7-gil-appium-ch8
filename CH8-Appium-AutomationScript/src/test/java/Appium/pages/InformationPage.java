package Appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformationPage {
    AndroidDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@text='CHECKOUT: INFORMATION']");
    By firstnameField = AppiumBy.accessibilityId("test-First Name");
    By lastnameField = AppiumBy.accessibilityId("test-Last Name");
    By postalcodeField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    By continueButton = AppiumBy.accessibilityId("test-CONTINUE");

    public InformationPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getDashboardText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
        return driver.findElement(dashboardText).getText();
    }

    public void inputfirstnameField(String firstname){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameField));
        driver.findElement(firstnameField).sendKeys(firstname);
    }

    public void inputlastnameField(String lastname){
        driver.findElement(lastnameField).sendKeys(lastname);
    }

    public void inputpostalcodeField(String postalcode){
        driver.findElement(postalcodeField).sendKeys(postalcode);
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
}
