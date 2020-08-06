package com.task_module.runners;

import com.task_module.utilities.Driver;
import io.cucumber.java.After;


public class Hooks {

 /*   @Before
    public void setUpScenario(){
        System.out.println("-----> Before annotation: Setting up browser");
    }*/


    @After
    public void tearDownScenario(){

        //#1 we need to take a screen shot using Selenium
        // #2 we are going to attach it into our report using attach method
        //attach method accept 3 arguments:
        //1)screenshot; 2) image type; 3) current scenario's name

        /*if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }*/

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
