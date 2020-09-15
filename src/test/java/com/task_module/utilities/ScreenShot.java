package com.task_module.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class ScreenShot {
    /**
     * This method takes a screenshot and saves it with a date&time stamp.
     * @return path to screenshot
     */

    public static String takeAScreenshotAndSave() {
        String path = System.getProperty("user.dir") + "/src/test/resources/screenshots/";
        path = path.replace("/", File.separator);
        File file = new File(path);
        file.mkdirs();
        Date date = new Date();
        path += date+"screenshot.jpeg";
        try (OutputStream outputStream = new FileOutputStream(path)) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            outputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create a screenshot :: " + path);
        }
        System.out.println("Screenshot saved here :: " + path);
        return path;
    }
}
