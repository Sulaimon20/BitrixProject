package com.task_module.step_definitions;

import com.github.javafaker.Faker;
import com.task_module.pages.Login_Page;
import com.task_module.pages.Task_Pages;
import com.task_module.utilities.BrowserUtils;
import com.task_module.utilities.ConfigurationReader;
import com.task_module.utilities.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TaskModule_step_definition {

    Login_Page loginPage = new Login_Page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
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
    @When("User clicks on Task button")
    public void user_clicks_on_task_button() {
        wait.until(ExpectedConditions.visibilityOf(task_pages.taskButtonElement)).click();

    }

    @Then("User clicks High Priority dropdown box")
    public void user_clicks_high_priority_dropdown_box() {
        wait.until(ExpectedConditions.visibilityOf(task_pages.priorityBoxElement)).click();

    }

    @Then("User see fire icon colored")
    public void user_see_fire_icon_colored() {
        //the fire icon should be verified
        Assert.assertTrue("the clicking of priority checkbox is failed", task_pages.priorityCheckBoxElement.isSelected());
    }


    //Scenario 2
    @When("User in is Hope page")
    public void userInIsHopePage() {

        wait.until(ExpectedConditions.visibilityOf(task_pages.homePageLogoElement)).click();

    }

    @Then("User clicks on the letter <A> in the bottom of the message box")
    public void userClicksOnTheLetterAInTheBottomOfTheMessageBox() {
        wait.until(ExpectedConditions.visibilityOf(task_pages.visualEditorElement)).click();


    }

    @Then("The editor text-bar on the top of the message box is displayed")
    public void theEditorTextBarOnTheTopOfTheMessageBoxIsDisplayed() {


        Assert.assertTrue("Element does not displayed", task_pages.postVisualEditorElement.isDisplayed());


    }

    //Scenario #3
    //these two line serve as randomly accumulating text in textboxes
    String formatDateTime = now.format(format);
    String textMessage;

    @Then("User writes in Thing to do box text {string}")
    public void userWritesInThingToDoBoxText(String text) {

        textMessage = text + " " + formatDateTime;
        wait.until(ExpectedConditions.visibilityOf(task_pages.thingToDoBoxElement)).click();
        wait.until(ExpectedConditions.visibilityOf(task_pages.thingToDoBoxElement)).sendKeys(textMessage);

    }

    @Then("User writes in <Thing to do> box text <Upload file> and text <The file  was uploaded> in <Message body> box")
    public void user_writes_in_thing_to_do_box_text_upload_file_and_text_the_file_was_uploaded_in_message_body_box(String arg) {

        wait.until(ExpectedConditions.visibilityOf(task_pages.uploadfilesIconElement)).click();
        wait.until(ExpectedConditions.visibilityOf(task_pages.thingToDoBoxElement)).click();
        wait.until(ExpectedConditions.visibilityOf(task_pages.thingToDoBoxElement)).sendKeys(arg);

    }

    @Then("User clicks on <Upload files> icon and upload <test> file  and <test2> picture from local disks")
    public void user_clicks_on_upload_files_icon_and_upload_team_test_cases_file_and_login_vy_track_picture_from_local_disks() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(task_pages.uploadfilesIconElement)).click();
        Thread.sleep(1000);
        //add text file
        String testPath = System.getProperty("user.dir") + "/src/test/resources/testData/test.txt";
        String test2Path = System.getProperty("user.dir") + "/src/test/resources/testData/test2.bmp";

        WebElement addTxtFile = Driver.getDriver().findElement(By.xpath("(//input[@class='diskuf-fileUploader wd-test-file-light-inp '])[5]"));
        Thread.sleep(1000);
        addTxtFile.sendKeys(testPath);
        //C:\Users\Acer\IdeaProjects\BitrixProject\src\test\resources\testData\test2.bmp
        Thread.sleep(1000);
        //adding image file
        WebElement addImageFile = Driver.getDriver().findElement(By.xpath("(.//input[@type='file'])[5]"));
        Thread.sleep(1000);
        addImageFile.sendKeys(test2Path);
        Thread.sleep(2000);

    }

    @Then("User clicks the <Select document> button and upload a file from <Bitrix>")
    public void userClicksTheSelectDocumentButtonAndUploadAFileFromBitrix() {
        task_pages.selectFromBitrixElement.click();
        wait.until(ExpectedConditions.visibilityOf(task_pages.salesMarketingButtonElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.marketingAdvertisingElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.logoGifElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.selectDocumentButtonElement)).click();

    }

    @Then("User clicks Send button")
    public void user_clicks_send_button() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(task_pages.sendButtonElement)).click();
    }

    @Then("User clicks on Task button on menu bar")
    public void user_clicks_on_task_button_on_menu_bar() {
        Driver.getDriver().navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.menuTaskButtonElement)).click();
    }

    @Then("User see the {string} in <My Tasks> table")
    public void userSeeTheInMyTasksTable(String text) throws InterruptedException {

        String formatDateTime = now.format(format);
        String textMessage = text + "::" + formatDateTime;

        Thread.sleep(2000);
        List<WebElement> namesList = Driver.getDriver().findElements(By.xpath("//table[@id='TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_table']//td[3]"));

        for (WebElement each : namesList) {
            if (each.getText().equals(textMessage)) {
                Assert.assertTrue("The test is FAILED", true);
            } else {
            }
            break;
        }
    }


    //Scenario 4
    @Then("User clicks <Quote text> icon")
    public void userClicksQuoteTextIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.quoteIconElement)).click();

    }

    @Then("User writes a text {string} in <message box> empty box")
    public void userWritesATextInMessageBoxEmptyBox(String message) {

        textMessage = message + "#" + formatDateTime;

        WebElement table = Driver.getDriver().findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));

        actions.moveToElement(table).build().perform();
        actions.sendKeys(textMessage).build().perform();
    }

    @Then("User see the the {string} in <My Tasks> table")
    public void userSeeTheTheInMyTasksTable(String message) throws InterruptedException {


        textMessage = message + "#" + formatDateTime;

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

        wait.until(ExpectedConditions.elementToBeClickable(task_pages.addMentionIcon)).click();

    }

    @And("User clicks on given email and chooses it")
    public void userClicksOnGivenEmailAndChoosesIt() {
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.addMoreEmailElement)).click();

    }

    //Scenario 6
    @And("User clicks on link icon")
    public void userClicksOnLinkIcon() {

        task_pages.linkIconElement.click();

    }

    @And("User writes the {string} and pastes {string} and save it")
    public void userWritesTheAndPastesAndSaveIt(String text, String URL) {
        task_pages.textLinkElement.sendKeys(text);
        task_pages.urlLinkElement.sendKeys(URL);
        task_pages.saveButtonElement.click();
    }

    //Scenario 7
    @And("User clicks on <Checklist> icon")
    public void userClicksOnChecklistIcon() {

        task_pages.checkListElement.click();


    }

    @And("User writes {string} in <Checklist>")
    public void userWritesInChecklist(String arg0) {
        Faker faker = new Faker();
        String text;
        for (int i = 1; i <= 4; i++) {
            text = faker.job().keySkills();
            task_pages.checkListToDoBoxElement.sendKeys(text + Keys.ENTER);
        }
    }


    //Scenario 8
    @And("User clicks on <Add more>")
    public void userClicksOnAddMore() {
        wait.until(ExpectedConditions.visibilityOf(task_pages.addMoreElement)).click();

    }

    @And("User clicks on assignee's emails and chooses it")
    public void userClicksOnAssigneeSEmailsAndChoosesIt() {
        wait.until(ExpectedConditions.elementToBeClickable(task_pages.addMoreEmailElement)).getText();
        List<WebElement> emailList = Driver.getDriver().findElements(By.xpath("//div[@class='bx-finder-box-item-t7-name']"));

        for (WebElement each : emailList) {
            each.click();
        }

    }

    //Scenario 9
    @And("User clicks on <Deadline> dropbox")
    public void userClicksOnDeadlineDropbox() {

        BrowserUtils.highlightElement(task_pages.deadLineBoxElement);
        task_pages.deadLineBoxElement.click();

    }

    @And("User clicks on {string}, {string}, {string}, {string}, {string} and {string}")
    public void userClicksOnAnd(String month, String year, String day, String hour, String minute, String pm_am) {


        //  Month value
        BrowserUtils.highlightElement(task_pages.monthBoxElement);
        task_pages.monthBoxElement.click();
        WebElement monthElement = Driver.getDriver().findElement(By.xpath("//span[contains(@class,'bx-calendar-month')][contains(text(),'" + month + "')]"));
        BrowserUtils.highlightElement(monthElement);
        wait.until(ExpectedConditions.elementToBeClickable(monthElement)).click();

        //  Year value
        BrowserUtils.highlightElement(task_pages.yearBoxElement);
        task_pages.yearBoxElement.click();

        WebElement yearElement = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + year + "')]"));
        BrowserUtils.highlightElement(yearElement);
        wait.until(ExpectedConditions.elementToBeClickable(yearElement)).click();

        //Day value
        WebElement dayElement = Driver.getDriver().findElement(By.xpath("//a[@class='bx-calendar-cell bx-calendar-weekend'][contains(text(),'" + day + "')]"));

        BrowserUtils.highlightElement(dayElement);
        wait.until(ExpectedConditions.elementToBeClickable(dayElement)).click();

        //  hour value
        BrowserUtils.highlightElement(task_pages.hourElement);
        task_pages.hourElement.clear();
        task_pages.hourElement.sendKeys(hour);

        //  minute value
        BrowserUtils.highlightElement(task_pages.minutelement);
        task_pages.minutelement.clear();
        task_pages.minutelement.sendKeys(minute);

        BrowserUtils.highlightElement(task_pages.pm_am_element);

        if (pm_am.equalsIgnoreCase("am")) {
            task_pages.pm_am_element.click();
        }

    }

    @And("User clicks on Select button")
    public void userClicksOnSelectButton() {
        //Select button
        BrowserUtils.highlightElement(task_pages.selectButtonElement);
        task_pages.selectButtonElement.click();
    }

    @And("User clicks on <Time planning> and <Start task on>")
    public void userClicksOnTimePlanningAndStartTaskOn() {

        task_pages.timePlanningButtonElement.click();
        task_pages.startTaskOnBoxElement.click();


    }

    @And("User clicks <Select> button")
    public void userClicksSelectButton() {
        task_pages.startTaskOnSelectButtonElement.click();

    }

    @And("User click {string} and writes the time {string}")
    public void userClickAndWritesTheTime(String timeOption, String timeAmount) {

        WebElement element = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + timeOption + "')]"));
        BrowserUtils.highlightElement(element);
        element.click();
        task_pages.startTaskOnDurationElement.sendKeys(timeAmount);

    }

    //Scenario 10
    @And("User clicks on <More>")
    public void userClicksOnMore() {
        task_pages.moreButtonElement.click();

    }

    @And("User clicks Time tracking and defines time {string} as hour and {string} minute")
    public void userClicksTimeTrackingAndDefinesTimeAsHourAndMinute(String hour, String minute) {

        task_pages.timeTrackClickBoxElement.click();
        task_pages.taskPlanHourBoxElement.sendKeys(hour);
        task_pages.taskPlanMinuteBoxElement.sendKeys(minute);

    }

    @And("User add reminder and activate repeate task")
    public void userAddReminderAndActivateRepeateTask() {
        task_pages.addReminderElement.click();
        task_pages.addDateReminderElement.click();
        task_pages.selectButtonElement.click();
        task_pages.addButtonElement.click();
        task_pages.activateBoxElement.click();

    }
}
