package com.weather.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.weather.data.OneDayWeatherInfo;
import com.weather.data.WeatherInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TenDayPageTest extends BaseTest {

    @Test
    public void testGet10DaysWeatherInfoOfSingapore(){
        String country = "Singapore";
        var tenDayPage = homePage.clickTenDayButton();
        tenDayPage.inputSearchedCountry( country);
        List<OneDayWeatherInfo> tendayPageInfoList = tenDayPage.getDailyForecastList( country);
        System.out.println();

    }

    @Test
    public void exportToJson() {

        WeatherInfo a = new WeatherInfo().setTemperature("10").setHumidity("20");

        String filePath = "output.json";
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(a, writer);
            Assert.assertTrue(Files.exists(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//    @Test
//    public void testGet10days() {
//        WebDriver driver;
//        String googleUrl = "https://weather.com";
//        String country = "Singapore";
//        By tenDayTab = By.xpath("//a[contains(@href, '/tenday/')][contains(@class, 'ListItem')]");
//
//       By locationSearchField = By.id("LocationSearch_input");
//       By searchLocationListBox = By.xpath("//div[contains(@id, 'LocationSearch_listbox')]/button");
//       By tenDayInfoList = By.xpath("//div[contains(@class,'DailyForecast--DisclosureList')]//details");
//
//       String rootPath = "//div[contains(@class,'DailyForecast--DisclosureList')]//";
//       String dayPartNamePath = "//h3//span";
//       String temperPath = "//div[@data-testid='DailyContent']//div/span[@data-testid='TemperatureValue']";
//       String humidityPath = "//div[@class='DetailsTable--field--CPpc_']/span[@data-testid='PercentageValue']" ; //stored day and nigh
//
//
//
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(googleUrl);
//
//        //click 10 day tab:done
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement tendayTab = wait.until(ExpectedConditions.visibilityOfElementLocated(tenDayTab));
//        tendayTab.click();
//
//        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(locationSearchField));
//        searchField.clear();
//        searchField.sendKeys("Singapore");
//
//        /////handle info of 10 days
//
//        WebElement buttonSearch = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchLocationListBox)).stream()
//                .filter(btn -> btn.getText().contains("Singapore, ")).findFirst().orElse(null);
//        buttonSearch.click();
//
//        int elementSize =  driver.findElements(tenDayInfoList).size();
//        List<OneDayWeatherInfo> dayWeatherInfoList = new ArrayList<>();
//
//        for (int i=1; i< elementSize; i++) {
//            String indexString = String.format("details[@id='detailIndex%s']", i);
//
//            // day and  nigh info
//            List<WebElement> temperList = getElementsByXpath( xpathBuilder( rootPath, indexString, temperPath));
//            String dayTemper = temperList.get(0).getAttribute("innerHTML");
//            String nighTemper = temperList.get(1).getAttribute("innerHTML");
//
//            List<WebElement> humilityList = getElementsByXpath(xpathBuilder(rootPath, indexString, humidityPath));
//            String dayHumility = humilityList.get(0).getAttribute("innerHTML");
//            String nightHumility = humilityList.get(1).getAttribute("innerHTML");
//
//            WeatherInfo dayInfo = new WeatherInfo().setHumidity(dayHumility).setTemperature(dayTemper);
//            WeatherInfo nightInfo = new WeatherInfo().setHumidity(nightHumility).setTemperature(nighTemper);
//
//            //Whole day info
//            String namePart = getElementsByXpath( xpathBuilder( rootPath, indexString, dayPartNamePath)).get(0).getAttribute("innerHTML");
//            OneDayWeatherInfo dayWeatherInfo = new OneDayWeatherInfo()
//                    .setDate(namePart)
//                    .setLocation(country)
//                    .setDay(dayInfo)
//                    .setNight(nightInfo);
//
//            dayWeatherInfoList.add(dayWeatherInfo);
//        }
//
//    }

//    private String xpathBuilder( String rootPart, String indexPart, String finalPart) {
//        return String.format("%s%s%s",rootPart, indexPart, finalPart);
//    }
//
//    private String getValueXpath(String xpath) {
//        return driver.findElement(By.xpath(xpath)).getText();
//    }
//
//    private List<WebElement> getElementsByXpath( String xpath){
//        return driver.findElements(By.xpath(xpath));
//    }

}
