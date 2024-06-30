package Appium.testcase;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Appium.pages.HomePage;
import Appium.pages.LoginPage;

public class SortingLowToHighTest {
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
    public static void sortingTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Assertion 1 : cek apakah sudah berpindah halaman
        Assert.assertEquals(homePage.getDashboardText(),"PRODUCTS");

        homePage.clickFilterButton();
        homePage.clickLowToHighButton();

        //Assertion 2 : cek apakah fungsi filter low to high sudah berfungsi
        Assert.assertTrue(homePage.getFirstitemPriceNumber()< homePage.getSeconditemPriceNumber());
    }

    @AfterClass
    public static void tearDown(){
        driver.terminateApp("com.swaglabsmobileapp");
    }
}
