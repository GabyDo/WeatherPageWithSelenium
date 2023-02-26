package com.weather.tests;

import com.weather.data.OneDayWeatherInfo;
import com.weather.dataproviders.TenDayPageDataProvider;
import com.weather.helpers.JsonHelpers;
import org.testng.annotations.Test;

import java.util.List;

public class TenDayPageTest extends BaseTest {

    @Test( dataProvider = "SearchedCountryVariations", dataProviderClass = TenDayPageDataProvider.class)
    public void testGet10DaysWeatherInfoOfSingapore( String scenario, String inputWord, String expectedCountry){
        getHomepage();
        var tenDayPage = homePage.clickTenDayButton();
        tenDayPage.inputSearchedCountry(inputWord, expectedCountry);
        List<OneDayWeatherInfo> tendayPageInfoList = tenDayPage.getDailyForecastList(expectedCountry);
        JsonHelpers.exportToJsonFile(tendayPageInfoList);

    }

}
