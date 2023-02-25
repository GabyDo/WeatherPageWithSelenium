package com.weather.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver ;

    private By tenDayTab = By.xpath("//a[contains(@href, '/tenday/')][contains(@class, 'ListItem')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public TenDayPage clickTenDayButton() {
        clickLink(tenDayTab);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L)); //hỏi phần này
        return new TenDayPage(driver);
    }


    private void clickLink(By byElement){
        driver.findElement(tenDayTab).click();
    }

}
