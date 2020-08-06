package com.task_module.pages;

import com.task_module.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {



    public BasePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

}
