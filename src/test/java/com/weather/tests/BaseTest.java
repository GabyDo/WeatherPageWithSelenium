package com.weather.tests;

import com.weather.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    String url = "https://weather.com";

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        homePage = new HomePage(driver);

    }

//    @BeforeTest
//    public void getWebsite()
//    {
//
//    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
