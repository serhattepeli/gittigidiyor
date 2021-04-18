package org.example;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class driver {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-translate");
        driver = new ChromeDriver(options);
        driver.get("https://gittigidiyor.com");
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
