package com.weather.tests;

import com.weather.data.OneDayWeatherInfo;
import com.weather.helpers.JsonHelpers;
import org.testng.annotations.Test;

import java.util.List;

public class TenDayPageTest extends BaseTest {

    @Test
    public void testGet10DaysWeatherInfoOfSingapore(){
        String country = "Singapore";
        var tenDayPage = homePage.clickTenDayButton();
        tenDayPage.inputSearchedCountry(country);
        List<OneDayWeatherInfo> tendayPageInfoList = tenDayPage.getDailyForecastList(country);
        JsonHelpers.exportToJsonFile(tendayPageInfoList);

    }

}
