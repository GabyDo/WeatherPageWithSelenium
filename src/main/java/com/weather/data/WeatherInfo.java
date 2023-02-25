package com.weather.data;

public class WeatherInfo {
    String temperature;
    String humidity;

    public String getTemperature() {
        return temperature;
    }

    public WeatherInfo setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    public String getHumidity() {
        return humidity;
    }

    public WeatherInfo setHumidity(String humidity) {
        this.humidity = humidity;
        return this;
    }
}
