package com.task_module.pages;

import com.task_module.utilities.ConfigurationReader;
import com.task_module.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    //


    public void login() {

        wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(ConfigurationReader.getProperty("username1"));
        wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

    public void setUser(String user, String username, String password) {

//        if (user == "HR3"){
//            wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(username);
//            wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(password);
//            loginButton.click();
//
//        }
//
//        if (user == "marketing3"){
//            wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(ConfigurationReader.getProperty("username3"));
//            wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(ConfigurationReader.getProperty("password"));
//            loginButton.click();
//        }
//        if (user == "helpdesk3"){
//            wait.until(ExpectedConditions.visibilityOf(userNameBox)).sendKeys(ConfigurationReader.getProperty("username2"));
//            wait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(ConfigurationReader.getProperty("password"));
//            loginButton.click();
//        }

    }




}
