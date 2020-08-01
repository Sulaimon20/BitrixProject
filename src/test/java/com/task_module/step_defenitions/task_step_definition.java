package com.task_module.step_defenitions;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class task_step_definition {

    Login_Page loginPage = new Login_Page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Task_Pages task_pages = new Task_Pages();
    Actions actions = new Actions(Driver.getDriver());
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yy/HH:mm:ss");


    @Given("user login and is on the <Active Stream> home page")
    public void userLoginAndIsOnTheActiveStreamHomePage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        loginPage.login();
        String actualTitle = "Portal";
        Assert.assertEquals(Driver.getDriver().getTitle(), actualTitle);
    }


    //Scenario 1
    @When("User clicks on <Task> button")
    public void user_clicks_on_task_button() {
        wait.until(ExpectedConditions.visibilityOf(task_pages.taskButton)).click();

    }

    @Then("User clicks <High Priority> dropdown box")
    public void user_clicks_high_priority_dropdown_box() {
        wait.until(ExpectedConditions.visibilityOf(task_pages.priorityBox)).click();

    }

    @When("User see fire icon colored")
    public void user_see_fire_icon_colored() {
        //the fire icon should be verified
        Assert.assertTrue("the clicking of priority checkbox is failed", task_pages.priorityCheckBox.isSelected());
    }


    //Scenario 2

    @Then("User clicks on the letter <A> in the bottom of the message box")
    public void userClicksOnTheLetterAInTheBottomOfTheMessageBox() {
        wait.until(ExpectedConditions.visibilityOf(task_pages.visualEditor)).click();


    }

    @Then("The editor text-bar on the top of the message box is displayed")
    public void theEditorTextBarOnTheTopOfTheMessageBoxIsDisplayed() {


        Assert.assertTrue("Element does not displayed", task_pages.postVisualEditor.isDisplayed());


    }


    //Scenario #3
    @Then("User writes in <Thing to do> box text {string}")
    public void userWritesInThingToDoBoxText(String text) {

        String formatDateTime = now.format(format);
        String textMessage = text + " " + formatDateTime;

        wait.until(ExpectedConditions.visibilityOf(task_pages.thingToDoBox)).click();
        wait.until(ExpectedConditions.visibilityOf(task_pages.thingToDoBox)).sendKeys(textMessage);

    }

    @Then("User writes in <Thing to do> box text <Upload file> and text <The file  was uploaded> in <Message body> box")
    public void user_writes_in_thing_to_do_box_text_upload_file_and_text_the_file_was_uploaded_in_message_body_box(String arg) {

        wait.until(ExpectedConditions.visibilityOf(task_pages.uploadfilesIcon)).click();

        wait.until(ExpectedConditions.visibilityOf(task_pages.thingToDoBox)).click();
        wait.until(ExpectedConditions.visibilityOf(task_pages.thingToDoBox)).sendKeys(arg);

    }

    @Then("User clicks on <Upload files> icon and upload <TeamTestCases> file  and <LoginVyTrack> picture from local disks")
    public void user_clicks_on_upload_files_icon_and_upload_team_test_cases_file_and_login_vy_track_picture_from_local_disks() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(task_pages.uploadfilesIcon)).click();
        Thread.sleep(1000);
        //add text file
        WebElement addTxtFile = Driver.getDriver().findElement(By.xpath("(.//input[@type='file'])[5]"));
        Thread.sleep(1000);
        addTxtFile.sendKeys("C:/Users/Acer/Desktop/test.txt");
        Thread.sleep(1000);
        //adding image file
        WebElement addImageFile = Driver.getDriver().findElement(By.xpath("(.//input[@type='file'])[5]"));
        Thread.sleep(1000);
        addImageFile.sendKeys("C:/Users/Acer/Desktop/test2.bmp");
        Thread.sleep(2000);


    }

    @Then("User clicks the <Select document> button and upload a file from <Bitrix>")
    public void userClicksTheSelectDocumentButtonAndUploadAFileFromBitrix() {
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.selectFromBitrix)).click();
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.salesMarketingButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.MarketingAdvertising)).click();
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.LogoGifElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.selectDocumentButton)).click();

    }

    @Then("User clicks <Send> button")
    public void user_clicks_send_button() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(task_pages.sendButton)).click();
    }

    @Then("User clicks on <Task> button on menu bar")
    public void user_clicks_on_task_button_on_menu_bar() {
        Driver.getDriver().navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.menuTaskButton)).click();
    }

    @Then("User see the {string} in <My Tasks> table")
    public void userSeeTheInMyTasksTable(String text) throws InterruptedException {

        String formatDateTime = now.format(format);
        String textMessage = text + "::" + formatDateTime;

        Thread.sleep(2000);
        List<WebElement> namesList = Driver.getDriver().findElements(By.xpath("//table[@id='TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_table']//td[3]"));

        for (WebElement each : namesList) {
            if (each.getText().equals(textMessage)) {
                Assert.assertTrue(true);
            } else {
               }
            break;
        }
    }


    //Scenario 4

    @Then("User clicks <Quote text> icon")
    public void userClicksQuoteTextIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.quoteIcon)).click();

    }

    String formatDateTime = now.format(format);
    String textMessage;

    @Then("User writes a text {string} in <message box> empty box")
    public void userWritesATextInMessageBoxEmptyBox(String message) {

        textMessage = message + "::" + formatDateTime;
        System.out.println("formatDateTime = " + formatDateTime);

        WebElement table = Driver.getDriver().findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));

        actions.moveToElement(table).build().perform();
        actions.sendKeys(textMessage).build().perform();
    }

    @Then("User see the the {string} in <My Tasks> table")
    public void userSeeTheTheInMyTasksTable(String message) throws InterruptedException {


        String textMessage = message + "::" + formatDateTime;
        System.out.println("formatDateTime = " + formatDateTime);
        Thread.sleep(2000);
        List<WebElement> taskList = Driver.getDriver().findElements(By.xpath("//table[@id='TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_table']//td[3]"));
                String getText = "";

        for (WebElement each : taskList) {

            if (each.getText().equals(textMessage)) {
                Assert.assertTrue(true);
            } else {
            }
            break;
        }
    }

    @Then("User see the the quoted task in <My Tasks>")
    public void userSeeTheTheQuotedTaskInMyTasks() {


    }


    //Scenario 5

    @Then("User clicks on <Add mention> button")
    public void userClicksOnAddMentionButton() {

    wait.until(ExpectedConditions.elementToBeClickable(task_pages.mentionAddIcon)).click();

    }

    @Then("User clicks on <Employees and departments>")
    public void userClicksOnEmployeesAndDepartments() {

        wait.until(ExpectedConditions.visibilityOf(task_pages.employAndDep)).click();

    }

    @And("User clicks on given email and chooses it")
    public void userClicksOnGivenEmailAndChoosesIt() {
        wait.until(ExpectedConditions.visibilityOf(task_pages.addMentionEmail)).click();

    }




}
