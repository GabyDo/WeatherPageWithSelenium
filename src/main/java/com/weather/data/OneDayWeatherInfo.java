package com.weather.data;

public class OneDayWeatherInfo {
    String date;
    String location;
    WeatherInfo day;
    WeatherInfo night;

    public String getDate() {
        return date;
    }

    public OneDayWeatherInfo setDate(String date) {
        this.date = date;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public OneDayWeatherInfo setLocation(String location) {
        this.location = location;
        return this;
    }

    public WeatherInfo getDay() {
        return day;
    }

    public OneDayWeatherInfo setDay(WeatherInfo day) {
        this.day = day;
        return this;
    }

    public WeatherInfo getNight() {
        return night;
    }

    public OneDayWeatherInfo setNight(WeatherInfo night) {
        this.night = night;
        return this;
    }
}
