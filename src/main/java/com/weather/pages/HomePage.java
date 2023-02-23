package com.weather.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver ;
    private By locationSearchField = By.id("LocationSearch_input");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLocationSearchField( String country) {
        driver.findElement(locationSearchField).sendKeys(country);
    }

}
