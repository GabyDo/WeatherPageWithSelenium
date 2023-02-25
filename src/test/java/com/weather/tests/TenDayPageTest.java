package com.weather.tests;

import com.weather.data.OneDayWeatherInfo;
import com.weather.data.WeatherInfo;
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
import java.util.ArrayList;
import java.util.List;

public class TenDayPageTest {
    WebDriver driver;
    String googleUrl = "https://weather.com";

    @Test
    public void testGet10days() {
        String country = "Singapore";
        By tenDayTab = By.xpath("//a[contains(@href, '/tenday/')][contains(@class, 'ListItem')]");

       By locationSearchField = By.id("LocationSearch_input");
       By searchLocationListBox = By.xpath("//div[contains(@id, 'LocationSearch_listbox')]/button");
       By tenDayInfoList = By.xpath("//div[contains(@class,'DailyForecast--DisclosureList')]//details");

       String rootPath = "//div[contains(@class,'DailyForecast--DisclosureList')]//";
       String dayPartNamePath = "//h3//span";
       String temperPath = "//div[@data-testid='DailyContent']//div/span[@data-testid='TemperatureValue']";
       String humidityPath = "//div[@class='DetailsTable--field--CPpc_']/span[@data-testid='PercentageValue']" ; //stored day and nigh


        ////div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex5')]//div[@data-testid='DailyContent']//div/span[@data-testid='TemperatureValue']

        //daypartName: //div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex0')]//h3[@data-testid="daypartName"]
        ////div[contains(@class,'DailyForecast--DisclosureList')]//details[@id='detailIndex2']//h3//span

        //DayTempValue: //div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex0')]//div[@data-testid='detailsTemperature']/span[contains(@class,'highTempValue')]
        //NighTempValue: ////div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex1')]//div[@data-testid='detailsTemperature']/span/span[contains(@class,'lowTempValue')]
        ////div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex5')]//div[@data-testid='DailyContent']//div/span[@data-testid='TemperatureValue']

        //hum2value://div[contains(@class,'DailyForecast--DisclosureList')]//details[contains(@id,'detailIndex0')]//div[@class='DetailsTable--field--CPpc_']/span[@data-testid='PercentageValue']



        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(googleUrl);

        //click 10 day tab:done
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement tendayTab = wait.until(ExpectedConditions.visibilityOfElementLocated(tenDayTab));
        tendayTab.click();

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(locationSearchField));
        searchField.clear();
        searchField.sendKeys("Singapore");

        /////handle info of 10 days

        WebElement buttonSearch = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchLocationListBox)).stream()
                .filter(btn -> btn.getText().contains("Singapore, ")).findFirst().orElse(null);
        buttonSearch.click();

        int elementSize =  driver.findElements(tenDayInfoList).size();
        List<OneDayWeatherInfo> dayWeatherInfoList = new ArrayList<>();

        for (int i=1; i< elementSize; i++) {
            String indexString = String.format("details[@id='detailIndex%s']", i);

            // day and  nigh info
            List<WebElement> temperList = getElementsByXpath( xpathBuilder( rootPath, indexString, temperPath));
            String dayTemper = temperList.get(0).getAttribute("innerHTML");
            String nighTemper = temperList.get(1).getAttribute("innerHTML");

            List<WebElement> humilityList = getElementsByXpath(xpathBuilder(rootPath, indexString, humidityPath));
            String dayHumility = humilityList.get(0).getAttribute("innerHTML");
            String nightHumility = humilityList.get(1).getAttribute("innerHTML");

            WeatherInfo dayInfo = new WeatherInfo().setHumidity(dayHumility).setTemperature(dayTemper);
            WeatherInfo nightInfo = new WeatherInfo().setHumidity(nightHumility).setTemperature(nighTemper);

            //Whole day info
            String namePart = getElementsByXpath( xpathBuilder( rootPath, indexString, dayPartNamePath)).get(0).getAttribute("innerHTML");
            OneDayWeatherInfo dayWeatherInfo = new OneDayWeatherInfo()
                    .setDate(namePart)
                    .setLocation(country)
                    .setDay(dayInfo)
                    .setNight(nightInfo);

            dayWeatherInfoList.add(dayWeatherInfo);
        }

    }

    private String xpathBuilder( String rootPart, String indexPart, String finalPart) {
        return String.format("%s%s%s",rootPart, indexPart, finalPart);
    }

    private String getValueXpath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    private List<WebElement> getElementsByXpath( String xpath){
        return driver.findElements(By.xpath(xpath));
    }


}
