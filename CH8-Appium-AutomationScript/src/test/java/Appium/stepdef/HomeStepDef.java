package Appium.stepdef;

import Appium.pages.*;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.awt.SystemColor.text;

public class HomeStepDef {
    protected static AndroidDriver driver;

    @Given("user login with valid username and password")
    public void userLoginWithValidUsernameAndPassword(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("deviceName", "Infinix HOT 11S NFC");
        capabilities.setCapability("udid", "192.168.100.48:35315");

        driver = new AndroidDriver(capabilities);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @And("user click on filter button")
    public void userClickOnFilterButton(){
        HomePage homePage = new HomePage(driver);
        homePage.clickFilterButton();
    }

    @When("user click on low to high button")
    public void userClickOnPriceLowToHighButton(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLowToHighButton();
    }

    @Then("items are lined up in order of low price to high price")
    public void itemsAreLinedUpInOrderOfLowPriceToHighPrice(){
        HomePage homePage = new HomePage(driver);
        homePage.validateOnPage();
    }

    @And("user add to cart first item")
    public void userAddToCartFirstItem(){
        HomePage homePage = new HomePage(driver);
        homePage.addToCartFirstItemButton();
    }

    @And("user add to cart second item")
    public void userAddToCartSecondItem(){
        HomePage homePage = new HomePage(driver);
        homePage.addToCartSecondItemButton();
    }

    @And("user click on cart button")
    public void userClickOnCartButton(){
        HomePage homePage = new HomePage(driver);
        homePage.clickCartButton();
    }

    @And("user click on checkout button")
    public void userClickOnCheckoutButton(){
        CartPage cartPage = new CartPage(driver);
        cartPage.swipeToElementWithText("CHECKOUT");
        cartPage.clickCheckoutButton();
    }

    @And("user input first name last name and postal code")
    public void userInputFirstNameLastNameAndPostalCode(){
        InformationPage informationPage = new InformationPage(driver);
        informationPage.inputfirstnameField("Gilang Zhanuardy");
        informationPage.inputlastnameField("Pamungkas");
        informationPage.inputpostalcodeField("15510");
    }

    @And("user click on continue button")
    public void userClickOnContinueButton(){
        InformationPage informationPage = new InformationPage(driver);
        informationPage.clickContinueButton();
    }

    @When("user click on finish button")
    public void userClickOnFinishButton(){
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.swipeToElementWithText("FINISH");
        overviewPage.clickFinishButton();
    }

    @Then("user is on complete page")
    public void userIsOnCompletePage(){
        CompletePage completePage = new CompletePage(driver);
        completePage.validateOnPage();
    }
}
