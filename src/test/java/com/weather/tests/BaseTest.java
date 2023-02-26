package com.weather.tests;

import com.weather.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    String url = "https://weather.com";

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public void getHomepage(){
        driver.get(url);
        homePage = new HomePage(driver);

    }

    protected WebDriver getBrowserDriver(String browserName, String url) {

        if(browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if (browserName.equalsIgnoreCase("safari"))
        {
            WebDriverManager.iedriver().arch32().setup();
            driver = new SafariDriver();
        }
        else
        {
            throw new RuntimeException("Browser name invalid.");
        }

        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

}
