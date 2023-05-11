package com.academy.techcenture.step_definitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginStepDefs {

    private WebDriver driver;
    @Given("user launches the browser")
    public void user_launches_the_browser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
    }

    @And("user navigates to the login page")
    public void user_navigates_to_the_login_page() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals("Web Orders Login"));
    }
    @And("user enters {string} in username input box")
    public void user_enters_in_username_input_box(String username) {
        WebElement userNameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        userNameInput.sendKeys(username);
    }
    @And("user enters {string} in password input box")
    public void user_enters_in_password_input_box(String password) {
        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys(password);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
        Assert.assertTrue("Login btn is not enabled",loginBtn.isEnabled());
        loginBtn.click();
    }
    @Then("user should be navigated to orders page")
    public void user_should_be_navigated_to_orders_page() {
        WebElement welcomeMsg = driver.findElement(By.className("login_info"));
        Assert.assertTrue("Welcome message problem",welcomeMsg.getText().trim().contains("Welcome, Tester!"));
    }

    @Then("user should see invalid login or password message")
    public void userShouldSeeInvalidLoginOrPasswordMessage() {
        WebElement errorMsg = driver.findElement(By.id("ctl00_MainContent_status"));
        Assert.assertTrue("Error message is not correct",errorMsg.getText().trim().equals("Invalid Login or Password."));
    }

    @And("user quits the browser")
    public void userQuitsTheBrowser() {
        if (driver != null){
            driver.quit();
        }
    }
}
