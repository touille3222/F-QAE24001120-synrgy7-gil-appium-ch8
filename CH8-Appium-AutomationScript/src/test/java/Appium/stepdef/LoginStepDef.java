package Appium.stepdef;

import Appium.pages.HomePage;
import Appium.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class LoginStepDef {
    protected static AndroidDriver driver;

    @Given("user is on login page")
    public void userIsOnLoginPage(){
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

    @And("user input username with {string}")
    public void userInputUsernameWith(String username){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword(password);
    }

    @When("user click on login button")
    public void userClickLoginButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Then("user is on home page")
    public void userIsOnHomePage(){
        HomePage homePage = new HomePage(driver);
        homePage.validateOnPage();
    }

    @Then("error message is showing up")
    public void error_message_is_showing_up() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.errorMessageIsDisplayed();
    }
}
