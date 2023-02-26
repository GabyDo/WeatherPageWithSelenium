package com.weather.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.weather.data.OneDayWeatherInfo;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JsonHelpers {

    public static void exportToJsonFile(List<OneDayWeatherInfo> list) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();

        String filePath =String.format("target/OutputJsonAt%s.json",date) ;
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(list, writer);

            Assert.assertTrue(Files.exists(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
