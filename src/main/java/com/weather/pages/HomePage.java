package com.weather.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonPage{
    WebDriver driver ;

    private By tenDayTab = By.xpath("//a[contains(@href, '/tenday/')][contains(@class, 'ListItem')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public TenDayPage clickTenDayButton() {
        clickOnElement(driver, tenDayTab);
        return new TenDayPage(driver);
    }

}
