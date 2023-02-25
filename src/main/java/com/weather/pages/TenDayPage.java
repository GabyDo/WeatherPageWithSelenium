package com.weather.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TenDayPage {
    WebDriver driver ;

    private By locationSearchField = By.id("LocationSearch_input"); //search by country
    private By searchLocationListBox = By.xpath("//div[contains(@id, 'LocationSearch_listbox')]/button"); // dropdown menu after search
    private By tenDayInfoList = By.xpath("//div[contains(@class,'DailyForecast--DisclosureList')]//summary"); //frame of data return

    public TenDayPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchedCountry(String searchedCountry) {
        //enter search string
        WebElement searchField = driver.findElement(locationSearchField);
        searchField.clear();
        searchField.sendKeys(searchedCountry);

        //selick drop downlist
        WebElement buttonSearch = driver.findElements(searchLocationListBox).stream()
                .filter(btn -> btn.getText().contains("Singapore, ")).findFirst().orElse(null); // xử lý phàn này
        buttonSearch.click();
    }

}
