package com.task_module.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    //logger we need to print more organize
    private static final Logger logger = Logger.getLogger(Driver.class);

    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();


    //so no one can create object of Driver class
    //everyone should call static getter method instead
    private Driver() {

    }

    /**
     * synchronized makes method thread safe. It ensures that only 1 thread can use it at the time.
     * <p>
     * Thread safety reduces performance but it makes everything safe.
     *
     * @return
     */

    public synchronized static WebDriver getDriver() {
        //if webdriver object doesn't exist
        //create it
        if (driverPool.get() == null) {
            //specify browser type in configuration.properties file
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            // -Dbrowser=firefox
            if (System.getProperty("browser") != null) {
                browser = System.getProperty("browser");
            }

            logger.info("Browser :: " + browser);

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;

                case "chromePathChanger":
                    WebDriverManager.chromedriver().setup();
                   // ChromeOptions chromeOptions = new ChromeOptions();
                    //chromeOptions.addArguments("--start-maximized");
                    //driverPool.set(new ChromeDriver(chromeOptions));

                    ChromeOptions options = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("download.default_directory", "/directory/path");
                    options.setExperimentalOption("prefs", prefs);

                    break;


                case "remote-chrome":
                    try {
                        URL url = new URL("http://100.25.20.235:4444/wd/hub");
                        ChromeOptions chromeOptions1 = new ChromeOptions();
                        driverPool.set(new RemoteWebDriver(url, chromeOptions1));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    logger.error("Wrong browser name :: " + browser);
                    throw new RuntimeException("Wrong browser name :: " + browser);
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {

        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
