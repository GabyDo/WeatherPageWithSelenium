package com.weather.pages;

import com.weather.data.OneDayWeatherInfo;
import com.weather.data.WeatherInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TenDayPage extends CommonPage {
    WebDriver driver ;

    //search country textbox
    private By locationSearchField = By.id("LocationSearch_input"); //search by country
    private By searchLocationListBox = By.xpath("//div[contains(@id, 'LocationSearch_listbox')]/button"); // dropdown menu after search

    //detail daily forecast information
    private By tenDayInfoList = By.xpath("//div[contains(@class,'DailyForecast--DisclosureList')]//details");
    String rootPath = "//div[contains(@class,'DailyForecast--DisclosureList')]//";
    String dayPartNamePath = "//h3//span";
    String temperPath = "//div[@data-testid='DailyContent']//div/span[@data-testid='TemperatureValue']";
    String humidityPath = "//div[@class='DetailsTable--field--CPpc_']/span[@data-testid='PercentageValue']" ; //stored day and nigh

    /***
     *
     *         ////div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex5')]//div[@data-testid='DailyContent']//div/span[@data-testid='TemperatureValue']
     *
     *         //daypartName: //div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex0')]//h3[@data-testid="daypartName"]
     *         ////div[contains(@class,'DailyForecast--DisclosureList')]//details[@id='detailIndex2']//h3//span
     *
     *         //DayTempValue: //div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex0')]//div[@data-testid='detailsTemperature']/span[contains(@class,'highTempValue')]
     *         //NighTempValue: ////div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex1')]//div[@data-testid='detailsTemperature']/span/span[contains(@class,'lowTempValue')]
     *         ////div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex5')]//div[@data-testid='DailyContent']//div/span[@data-testid='TemperatureValue']
     *
     *         //hum2value://div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex0')]//div[@class='DetailsTable--field--CPpc_']/span[@data-testid='PercentageValue']
     */


    public TenDayPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputSearchedCountry( String inputCountry, String expectedCountry) {
        //enter search string
        sendKeyToElement(driver, locationSearchField, inputCountry);

        //select drop down list
        String countrySelected = String.format("%s, ",expectedCountry);
        selectItemFromParentDropdownList( driver, searchLocationListBox, countrySelected);

    }


    public List<OneDayWeatherInfo> getDailyForecastList( String country) {
        List<OneDayWeatherInfo> dayWeatherInfoList = new ArrayList<>();
        OneDayWeatherInfo dayWeatherInfo;
        int elementSize =  driver.findElements(tenDayInfoList).size();

        for (int i=1; i< elementSize; i++) {
            String indexString = String.format("details[@id='detailIndex%s']", i);

            // day and  nigh info
            List<WebElement> temperList = getElementsByXpath(driver, xpathBuilder( rootPath, indexString, temperPath));
            String dayTemper = getAttributeOfElement(temperList.get(0));
            String nighTemper = getAttributeOfElement(temperList.get(1));

            List<WebElement> humilityList = getElementsByXpath(driver, xpathBuilder(rootPath, indexString, humidityPath));
            String dayHumility = getAttributeOfElement(humilityList.get(0));
            String nightHumility = getAttributeOfElement(humilityList.get(1));

            WeatherInfo dayInfo = new WeatherInfo().setHumidity(dayHumility).setTemperature(dayTemper);
            WeatherInfo nightInfo = new WeatherInfo().setHumidity(nightHumility).setTemperature(nighTemper);

            //set value for a day
            String namePart = getAttributeOfElement( getElementsByXpath(driver, xpathBuilder( rootPath, indexString, dayPartNamePath)).get(0));
            dayWeatherInfo = new OneDayWeatherInfo()
                    .setDate(namePart)
                    .setLocation(country)
                    .setDay(dayInfo)
                    .setNight(nightInfo);

            dayWeatherInfoList.add(dayWeatherInfo);
        }

        return dayWeatherInfoList;
    }

}
