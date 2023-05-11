package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrdersPage extends BasePage{

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "login_info")
    protected WebElement welcomeMsg;

    public void verifyWelcomeMsg(){
        Assert.assertTrue("Welcome message problem",welcomeMsg.getText().trim().contains("Welcome, Tester!"));
    }
}
