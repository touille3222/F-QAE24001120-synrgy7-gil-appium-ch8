package Appium.testcase;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Appium.pages.LoginPage;

public class LoginNegativeWithWrongPasswordTest {
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
        capabilities.setCapability("udid", "192.168.100.48:35315");

        driver = new AndroidDriver(capabilities);
    }

    @Test
    public static void loginNegativeTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("wrongpass_test");
        loginPage.clickLoginButton();

        //Assertion 1 : cek apakah error message muncul
        loginPage.errorMessageIsDisplayed();
    }

    @AfterClass
    public static void tearDown(){
        driver.terminateApp("com.swaglabsmobileapp");
    }
}
