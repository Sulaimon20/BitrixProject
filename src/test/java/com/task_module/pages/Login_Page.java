package com.task_module.pages;

import com.task_module.utilities.ConfigurationReader;
import com.task_module.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login_Page extends BasePage{


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);

    // LOGIN WebElements

    @FindBy(xpath = "(//a[.='Login'])[2]")
    public WebElement loginHomePageElement;

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@class='login-btn']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='login-popup']/div[2]/text()")
    public WebElement errorMessage;



    //


    public void login() {

        wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(ConfigurationReader.getProperty("HR"));
        wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

    public void login(String User) {

        wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(ConfigurationReader.getProperty(User));
        wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

    public void login(String username, String password) {

        wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(password);
        loginButton.click();
    }







}
