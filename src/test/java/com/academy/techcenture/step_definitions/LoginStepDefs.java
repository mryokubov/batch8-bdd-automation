package com.academy.techcenture.step_definitions;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.OrdersPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private OrdersPage ordersPage;

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        driver = Driver.getDriver();
    }

    @And("user navigates to the login page")
    public void user_navigates_to_the_login_page() {
        driver.get(ConfigReader.getProperty("url"));
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals("Web Orders Login"));
        loginPage = new LoginPage(driver);
        ordersPage = new OrdersPage(driver);
    }

    @And("user enters {string} and {string} in username and password inputs")
    public void userEntersAndInUsernameAndPasswordInputs(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginBtn();
    }
    @Then("user should be navigated to orders page")
    public void user_should_be_navigated_to_orders_page() {
       ordersPage.verifyWelcomeMsg();
    }

    @Then("user should see invalid login or password message")
    public void userShouldSeeInvalidLoginOrPasswordMessage() {
        loginPage.verifyLoginError();
    }

    @And("user quits the browser")
    public void userQuitsTheBrowser() {
        if (driver != null){
            driver.quit();
        }
    }
}
