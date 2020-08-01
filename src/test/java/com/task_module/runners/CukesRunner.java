package com.task_module.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/Bitrix24.html",
        features = "src/test/resources/features",
        glue = "com/task_module/step_defenitions",
        dryRun = false,
        tags = "@test"
)



public class CukesRunner {



}
