package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.ID, using = "ctl00_MainContent_username")
    protected WebElement usernameInput;

    @FindBy(id = "ctl00_MainContent_password")
    protected WebElement passwordInput;

    @FindBy(id = "ctl00_MainContent_login_button")
    protected WebElement loginBtn;

    @FindBy(how = How.XPATH , using = "//span[@id='ctl00_MainContent_status']")
    protected WebElement errorMsg;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn(){
        Assert.assertTrue("Login button is not enabled",loginBtn.isEnabled());
        loginBtn.click();
    }

    public void verifyLoginError(){
        Assert.assertTrue("Error message is not correct",errorMsg.getText().trim().equals("Invalid Login or Password."));
    }
}
