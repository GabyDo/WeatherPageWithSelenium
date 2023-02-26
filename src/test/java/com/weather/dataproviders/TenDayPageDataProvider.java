package com.weather.dataproviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class TenDayPageDataProvider {

    @DataProvider(name= "SearchedCountryVariations")
    public static Object[][] getSearchedCountryVariations() {
        List<Object[]> data = new ArrayList<>();
        String scenario;
        String inputWord;
        String searchedCountry;

        //--------------------------------------------------------------------------------
        scenario = "Search country by word: Singapore";
        //--------------------------------------------------------------------------------
        inputWord = "Singapore";
        searchedCountry = "Singapore";

        data.add(new Object[]{scenario, inputWord, searchedCountry});

        //--------------------------------------------------------------------------------
        scenario = "Search country by word: singapore";
        //--------------------------------------------------------------------------------
        inputWord = "singapore";
        searchedCountry = "Singapore";

        data.add(new Object[]{scenario, inputWord, searchedCountry});

        //--------------------------------------------------------------------------------
        scenario = "Search country by word: singapore";
        //--------------------------------------------------------------------------------
        inputWord = "sing";
        searchedCountry = "Singapore";

        data.add(new Object[]{scenario, inputWord, searchedCountry});

        return data.toArray(new Object[][]{});
    }

}
