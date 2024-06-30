package Appium.testcase;

import Appium.pages.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {
    protected static AndroidDriver driver;

    @BeforeClass
    public static void setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("deviceName", "Infinix HOT 11S NFC");
        capabilities.setCapability("udid", "073262521J015262");

        driver = new AndroidDriver(capabilities);
    }

    @Test
    public static void checkoutTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        InformationPage informationPage = new InformationPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);
        CompletePage completePage = new CompletePage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Assertion 1 : cek apakah sudah berpindah halaman
        Assert.assertEquals(homePage.getDashboardText(),"PRODUCTS");

        homePage.addToCartFirstItemButton();
        homePage.addToCartSecondItemButton();
        homePage.clickCartButton();

        //Assertion 2 : cek apakah sudah berpindah ke Cart Page
        Assert.assertEquals(cartPage.getDashboardText(), "YOUR CART");

        cartPage.swipeToElementWithText("CHECKOUT");
        cartPage.clickCheckoutButton();

        //Assertion 3 : cek apakah sudah berpindah ke Information Page
        Assert.assertEquals(informationPage.getDashboardText(),"CHECKOUT: INFORMATION");

        informationPage.inputfirstnameField("Gilang Zhanuardy");
        informationPage.inputlastnameField("Pamungkas");
        informationPage.inputpostalcodeField("15510");
        informationPage.clickContinueButton();

        //Assertion 4 : cek apakah sudah berpindah ke Overview Page
        Assert.assertEquals(overviewPage.getDashboardText(),"CHECKOUT: OVERVIEW");

        overviewPage.swipeToElementWithText("FINISH");
        overviewPage.clickFinishButton();

        //Assertion 5 : cek apakah sudah berpindah ke Complete Page
        Assert.assertEquals(completePage.getDashboardText(),"CHECKOUT: COMPLETE!");
    }

    @AfterClass
    public static void tearDown(){
        driver.terminateApp("com.swaglabsmobileapp");
    }
}
