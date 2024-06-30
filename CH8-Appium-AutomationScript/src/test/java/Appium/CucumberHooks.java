package Appium;

import Appium.testcase.LoginPositiveTest;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class CucumberHooks {
    @BeforeAll
    public static void setUp() {
        LoginPositiveTest.setUp();
        System.out.println("Driver initialized");
    }

    @AfterAll
    public static void tearDown() {
        // Quit the driver
        LoginPositiveTest.tearDown();
        System.out.println("Driver quit");
    }
}
