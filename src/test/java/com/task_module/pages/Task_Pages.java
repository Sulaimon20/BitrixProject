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
    public WebElement taskButton;


    @FindBy(xpath = "//input[@id='tasks-task-priority-cb']")
    public WebElement priorityBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[13]")
    public WebElement priorityCheckBox;


    @FindBy(xpath = "//span[@class='logo-text']")
    public WebElement homePage;



    @FindBy(xpath = "(//div[@class='feed-add-post-form-but-more-open']/span[1])[3]")
    public WebElement visualEditor;


    @FindBy(xpath = "(//div[@class='bxhtmled-toolbar'])[3]")
    public WebElement postVisualEditor;


    //Scenario 3

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement thingToDoBox;

    @FindBy(xpath = "(//span[@title='Upload files'])[3]")
    public WebElement uploadfilesIcon;

    @FindBy(xpath = "(//span[.='Select document from Bitrix24'])[5]")
    public WebElement selectFromBitrix;

    @FindBy(xpath = "//span[.='Sales and marketing']")
    public WebElement salesMarketingButton;

    @FindBy(linkText = "Marketing and advertising")
    public WebElement MarketingAdvertising;

    @FindBy(linkText = "Logo.gif")
    public WebElement LogoGifElement;

    @FindBy(xpath = "//*[@id='DiskFileDialog']/div[3]/span[1]")
    public WebElement selectDocumentButton;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "//*[@id='bx_left_menu_menu_tasks']/a/span[1]")
    public WebElement menuTaskButton;

//Scenario 4

    @FindBy(xpath = "(//span[@title='Quote text'])[2]")
    public WebElement quoteIcon;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    public WebElement messageBox;

//Scenario 5

    @FindBy(xpath = "//*[@id='bx-b-mention-task-form-lifefeed_task_form']")
    public WebElement mentionAddIcon;

    @FindBy(xpath = "//a[.='Employees and departments']")
    public WebElement employAndDep;

    @FindBy(xpath = "//table[@id='TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_table']//td[3]")
    public WebElement taskTable;


    @FindBy(xpath = "//div[.='helpdesk22@cybertekschool.com']")
    public WebElement addMentionEmail;





}
