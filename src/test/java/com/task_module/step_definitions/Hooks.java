package com.task_module.step_definitions;

import com.task_module.pages.Login_Page;
import com.task_module.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks  {
    private final static Logger logger = Logger.getLogger(Hooks.class);

   @Before
    public void setUpScenario() {
       System.out.println("-----> Before annotation: Setting up browser");


   }


    @After
    public void tearDownScenario(Scenario scenario){

        //#1 we need to take a screen shot using Selenium
        // #2 we are going to attach it into our report using attach method
        //attach method accept 3 arguments:
        //1)screenshot; 2) image type; 3) current scenario's name
        logger.info("Scenario: " + scenario);

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }


    /*

    @BeforeStep
    public void setUpStep(){
        System.out.println("===========> BEFORESTEP: TAKING SCREENSHOT <===========");

    }

    @AfterStep
    public void tearDownStep(){
        System.out.println("===========> AFTERSTEP: TAKING SCREENSHOT <===========");


    }
*/


}
