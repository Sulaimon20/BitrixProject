package com.task_module.pages;

import com.task_module.utilities.ConfigurationReader;
import com.task_module.utilities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login_Page extends BasePage{

    private final static Logger logger = Logger.getLogger(Login_Page.class);
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);

    // LOGIN WebElements

    @FindBy(xpath = "(//a[.='Login'])[2]")
    private WebElement loginHomePageElement;

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    private WebElement userNameBox;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    private WebElement passwordBox;

    @FindBy(xpath = "//input[@class='login-btn']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='login-popup']/div[2]/text()")
    private WebElement errorMessage;



    //


    public void login() {
        String usernameString = ConfigurationReader.getProperty("username");
        String passwordString = ConfigurationReader.getProperty("password");

        wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(usernameString);
        wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(passwordString);
        loginButton.click();
        logger.info("Login with " + usernameString + " username and " + passwordString + " password");
    }

    public void login(String User) {
        String passwordString = ConfigurationReader.getProperty("password");
        wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(ConfigurationReader.getProperty(User));
        wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(passwordString);
        loginButton.click();
        logger.info("Login with " + User + " username and " + passwordString + " password");

    }

    public void login(String username, String password) {

        wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(password);
        logger.info("Login with " + username + " username and " + password + " password");
        loginButton.click();
    }







}
