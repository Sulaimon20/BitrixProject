package com.task_module.pages;

import com.task_module.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task_Pages extends BasePage{


    @FindBy(xpath = "//span[@class='logo-text']")
    public WebElement homePageLogoElement;

    @FindBy(xpath = "//div/span[.='Task']")
    public WebElement taskButtonElement;

    @FindBy(xpath = "//input[@id='tasks-task-priority-cb']")
    public WebElement priorityBoxElement;

    @FindBy(xpath = "(//input[@type='checkbox'])[13]")
    public WebElement priorityCheckBoxElement;

    @FindBy(xpath = "(//div[@class='feed-add-post-form-but-more-open']/span[1])[3]")
    public WebElement visualEditorElement;

    @FindBy(xpath = "(//div[@class='bxhtmled-toolbar'])[3]")
    public WebElement postVisualEditorElement;


    //Scenario 3
//

    @FindBy(name = "ACTION[0][ARGUMENTS][data][TITLE]")
    public WebElement thingToDoBoxElement;

    @FindBy(xpath = "(//span[@title='Upload files'])[3]")
    public WebElement uploadfilesIconElement;

    @FindBy(xpath = "(//span[.='Select document from Bitrix24'])[5]")
    public WebElement selectFromBitrixElement;

    @FindBy(xpath = "//span[.='Sales and marketing']")
    public WebElement salesMarketingButtonElement;

    @FindBy(linkText = "Marketing and advertising")
    public WebElement marketingAdvertisingElement;

    @FindBy(linkText = "Logo.gif")
    public WebElement logoGifElement;

    @FindBy(xpath = "//*[@id='DiskFileDialog']/div[3]/span[1]")
    public WebElement selectDocumentButtonElement;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButtonElement;

    @FindBy(xpath = "//*[@id='bx_left_menu_menu_tasks']/a/span[1]")
    public WebElement menuTaskButtonElement;

//Scenario 4

    @FindBy(xpath = "(//span[@title='Quote text'])[2]")
    public WebElement quoteIconElement;


//Scenario 5

    @FindBy(xpath = "//*[@id='bx-b-mention-task-form-lifefeed_task_form']")
    public WebElement addMentionIcon;

    @FindBy(xpath = "(//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link'])[2]")
    public WebElement linkIconElement;

    @FindBy(xpath = "//input[@id='linklifefeed_task_form-text']")
    public WebElement textLinkElement;

    @FindBy(xpath = "//input[@id='linklifefeed_task_form-href']")
    public WebElement urlLinkElement;

    @FindBy(xpath = "//input[@id='undefined']")
    public WebElement saveButtonElement;

    //Scenario 7

    @FindBy(xpath = "//span[@class='tasks-task-mpf-link']")
    public WebElement checkListElement;


    @FindBy(xpath = "//input[@class='js-id-checklist-is-form-title task-checklist-field-add']")
    public WebElement checkListToDoBoxElement;

    @FindBy(xpath = "//span[@class='js-id-checklist-is-form-submit block-edit tasks-btn-apply task-field-title-ok']")
    public WebElement checkListToDoBoxOkElement;

//Scenario 8

    @FindBy(linkText = "Add more")
    public WebElement addMoreElement;

    @FindBy(xpath = "(//span[@class='bx-finder-groupbox-content']//a)[1]")
    public WebElement addMoreEmailElement;

//    @FindBy(xpath = "//div[@class='bx-finder-box-item-t7-name']")
//    public WebElement closeAddMoreAlertElement;

    //Scenario 9

    @FindBy(xpath = "//span[@class='task-options-inp-container task-options-date t-empty']")
    public WebElement deadLineBoxElement;

    @FindBy(xpath = "//a[@class='bx-calendar-top-month']")
    public WebElement monthBoxElement;


    @FindBy(xpath = "//a[@class='bx-calendar-top-year']")
    public WebElement yearBoxElement;


    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[1]")
    public WebElement hourElement;

    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[2]")
    public WebElement minutelement;


    @FindBy(xpath = "//span[@class='bx-calendar-AM-PM-text']")
    public WebElement pm_am_element;

    @FindBy(xpath = "(//span[@class='bx-calendar-button-text'])[1]")
    public WebElement selectButtonElement;

    //time planning
    @FindBy(xpath = "//span[contains(text(),'Time planning')]")
    public WebElement timePlanningButtonElement;

    @FindBy(xpath = "(//input[@data-bx-id='datepicker-display'])[2]")
    public WebElement startTaskOnBoxElement;

    @FindBy(xpath = "//span[@class='bx-calendar-button-text'][contains(text(),'Select')]")
    public WebElement startTaskOnSelectButtonElement;

    @FindBy(xpath = "(//input[@class='task-options-inp'])[3]")
    public WebElement startTaskOnDurationElement;

    //Scenario 10

    @FindBy(xpath = "//div[@class='task-additional-alt-more']")
    public WebElement moreButtonElement;

    @FindBy(xpath = "//input[@class='js-id-timeestimate-flag task-options-checkbox']")
    public WebElement timeTrackClickBoxElement;


    @FindBy(xpath = "//input[@class='js-id-timeestimate-time js-id-timeestimate-hour task-options-inp']")
    public WebElement taskPlanHourBoxElement;

    @FindBy(xpath = "//input[@class='js-id-timeestimate-time js-id-timeestimate-minute task-options-inp']")
    public WebElement taskPlanMinuteBoxElement;

    @FindBy(xpath = "//span[contains(text(),'Add reminder')]")
    public WebElement addReminderElement;

    @FindBy(xpath = "(//input[@class='task-popup-inp'])[1]")
    public WebElement addDateReminderElement;

    @FindBy(xpath = "//div[@class='task-popup-label-add']")
    public WebElement addButtonElement;

    @FindBy(xpath = "//input[@class='task-options-checkbox']")
    public WebElement activateBoxElement;


}
