package Appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    AndroidDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@text='YOUR CART']");
    By checkoutButton = AppiumBy.accessibilityId("test-CHECKOUT");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getDashboardText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
        return driver.findElement(dashboardText).getText();
    }

    public void swipeToElementWithText(String text) {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",
                                text)));
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
}
