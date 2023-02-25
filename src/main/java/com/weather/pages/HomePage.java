package com.weather.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver ;

    private By tenDayTab = By.xpath("//a[contains(@href, '/tenday/')][contains(@class, 'ListItem')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public TenDayPage clickTenDayButton() {
        clickLink(tenDayTab);
        return new TenDayPage(driver);
    }


    private void clickLink(By byElement){
       new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(tenDayTab)).click();
    }

}
