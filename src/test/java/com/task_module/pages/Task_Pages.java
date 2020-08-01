package com.task_module.pages;

import com.task_module.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task_Pages {

    public Task_Pages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement thingToDoBoxElement;

    @FindBy(xpath = "(//span[@title='Upload files'])[3]")
    public WebElement uploadfilesIconElement;

    @FindBy(xpath = "(//span[.='Select document from Bitrix24'])[5]")
    public WebElement selectFromBitrixElement;

    @FindBy(xpath = "//span[.='Sales and marketing']")
    public WebElement salesMarketingButtonElement;

    @FindBy(linkText = "Marketing and advertising")
    public WebElement MarketingAdvertisingElement;

    @FindBy(linkText = "Logo.gif")
    public WebElement LogoGifElement;

    @FindBy(xpath = "//*[@id='DiskFileDialog']/div[3]/span[1]")
    public WebElement selectDocumentButtonElement;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButtonElement;

    @FindBy(xpath = "//*[@id='bx_left_menu_menu_tasks']/a/span[1]")
    public WebElement menuTaskButtonElement;

//Scenario 4

    @FindBy(xpath = "(//span[@title='Quote text'])[2]")
    public WebElement quoteIconElement;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    public WebElement messageBoxElement;

//Scenario 5

    @FindBy(xpath = "//*[@id='bx-b-mention-task-form-lifefeed_task_form']")
    public WebElement mentionAddIcon;

    @FindBy(xpath = "//a[.='Employees and departments']")
    public WebElement employAndDep;

    @FindBy(xpath = "//table[@id='TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_table']//td[3]")
    public WebElement taskTable;


    @FindBy(xpath = "//div[.='helpdesk22@cybertekschool.com']")
    public WebElement addMentionEmail;


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


}
