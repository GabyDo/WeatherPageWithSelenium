package com.weather.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver ;

    private By locationSearchField = By.id("LocationSearch_input");
    private By dropdown = By.id("dropdown");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputLocationSearchField( String country) {
        driver.findElement(locationSearchField).sendKeys(country);
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOption() {
        List<WebElement> selectElements = findDropDownElement().getAllSelectedOptions();
        return selectElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }



}
