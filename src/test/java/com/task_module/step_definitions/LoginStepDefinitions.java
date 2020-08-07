package com.task_module.step_definitions;

import com.task_module.pages.Login_Page;
import com.task_module.pages.Task_Pages;
import com.task_module.utilities.ConfigurationReader;
import com.task_module.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginStepDefinitions {

    Login_Page loginPage = new Login_Page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
    Task_Pages task_pages = new Task_Pages();
    Actions actions = new Actions(Driver.getDriver());
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yy/HH:mm:ss");

    @Given("User is on the Login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();

    }

    @When("{string} login with username and password")
    public void loginWithUsernameAndPassword(String user) {
        loginPage.login(user);
    }

    @Then("User should be on the Active Stream {string}")
    public void userShouldBeOnTheActiveStream(String HomePageTitle) {


        System.out.println(Driver.getDriver().getTitle());
        Assert.assertEquals("Verification is failed!!", Driver.getDriver().getTitle(), HomePageTitle);

    }


    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);

    }

    @Then("{string} should be displayed.")
    public void shouldBeDisplayed(String errorMessage) {

    String actualErrorMessage=Driver.getDriver().findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals("Verification is failed!!",actualErrorMessage,errorMessage);
    }
}
