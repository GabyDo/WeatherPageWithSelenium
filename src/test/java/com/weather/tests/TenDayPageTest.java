package com.weather.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

public class TenDayPageTest {
    WebDriver driver;
    String googleUrl = "https://weather.com/vi-VN/weather/tenday/l/53692b85ecdcbeb3013c1bf60fa2737edfd8b6efc634ccd48d6cfdf435ddb89f";

    @Test
    public void testGet10days() {

       By locationSearchField = By.id("LocationSearch_input");
       By searchLocationListBox = By.xpath("//div[contains(@id, 'LocationSearch_listbox')]/button");
       By tenDayInfoList = By.xpath("//div[contains(@class,'DailyForecast--DisclosureList')]//summary");



        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(googleUrl);

        //click 10 day tab:done
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
//        driver.findElement(tenDayTab).click();

        ///
//        WebDriverWait wait = new WebDriverWait(driver, 1000);
        WebElement searchField = driver.findElement(locationSearchField);
        searchField.clear();
        searchField.sendKeys("Singapore");

        //

        WebElement buttonSearch = driver.findElements(searchLocationListBox).stream()
                .filter(btn -> btn.getText().contains("Singapore, ")).findFirst().orElse(null);
        buttonSearch.click();

        List<WebElement> list =  driver.findElements(tenDayInfoList);
        for (WebElement e: list) {
            e.click();
            ////div[contains(@class,'DailyForecast--DisclosureList')]//span[contains(@class,'DailyContent--daypartDate')]

            ////h3[contains(text(),'26')]/parent::div//span[contains(@class,'highTempValue')]
            ////div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex0')]//div[@class='DetailsTable--field--CPpc_']/span[@data-testid='PercentageValue']
            ////div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex0')]//div[@class='DetailsTable--field--CPpc_']/span[@data-testid='PercentageValue']


        }





        System.out.println("aaaaa");


//        wait.until(ExpectedConditions.visibilityOf(dropDownlist));



        //


    }
}
