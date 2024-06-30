package Appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    AndroidDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@text='PRODUCTS']");
    By filterButton = By.xpath("//*[@content-desc='test-Modal Selector Button']");
    By lowtohighButton = By.xpath("//*[@text='Price (low to high)']");
    By firstitemPrice = By.xpath("(//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup//android.widget.TextView[contains(@text, '$')])[1]");
    By seconditemPrice = By.xpath("(//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup//android.widget.TextView[contains(@text, '$')])[2]");
    By addtocartfirstitemButton = By.xpath("(//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]");
    By addtocartseconditemButton = By.xpath("(//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]");
    By cartButton = AppiumBy.accessibilityId("test-Cart");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void validateOnPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Cart")));
    }

    public String getDashboardText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
        return driver.findElement(dashboardText).getText();
    }

    public void clickFilterButton(){
        driver.findElement(filterButton).click();
    }

    public void clickLowToHighButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lowtohighButton));
        driver.findElement(lowtohighButton).click();
    }

    public float getFirstitemPriceNumber(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstitemPrice));
        String beforeRemoveDollar = driver.findElement(firstitemPrice).getText();
        String afterRemoveDollar = beforeRemoveDollar.replace("$", "");
        return Float.parseFloat(afterRemoveDollar);
    }

    public float getSeconditemPriceNumber(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(seconditemPrice));
        String beforeRemoveDollar = driver.findElement(seconditemPrice).getText();
        String afterRemoveDollar = beforeRemoveDollar.replace("$", "");
        return Float.parseFloat(afterRemoveDollar);
    }

    public void addToCartFirstItemButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addtocartfirstitemButton));
        driver.findElement(addtocartfirstitemButton).click();
    }

    public void addToCartSecondItemButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addtocartseconditemButton));
        driver.findElement(addtocartseconditemButton).click();
    }

    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }
}
