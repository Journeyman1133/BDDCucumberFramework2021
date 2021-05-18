package com.swaglabs.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    private ConfigReader prop;

    public static WebDriver initializeDriver() {
        // load the config.properties using the ConfigReader class
        ConfigReader.readProperties("./src/test/resources/configuration/config.properties");
        // choose the browser using the ConfigReader class
        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else {
            throw new RuntimeException("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(ConfigReader.getProperty("url"));

        PageManager.initializePageObjects();

        return driver;
    }

    public static void tearDown() {
        if (driver != null)
            driver.quit();
    }
}