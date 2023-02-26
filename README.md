# WeatherPageWithSelenium
By Gam Do

This project is a demo: use Selenium to solve below use case: 

Retrieve 10 days of weather (temperature, Humidity, ) of Singapore for Day and Night. Using weather.com 
All information needed to save in a file.
A summary report. 


### Test case
* Search country by word: Singapore
* Search country by word: singapore
* Search country by word: sing

Details step of test case:
1. Open web url
2. Click ten-day button
3. Search for country: Singapore
4. Get weather information to a tendayPageInfoList List
5. Export tendayPageInfoList List to a Json file

Test name inside project: TenDayPageTest.testGet10DaysWeatherInfoOfSingapore()

Note: The current implementation is only configure for the Google Chrome Browser. We can update to support other browser with the corresponding WebDriver


### How to run:
1. Prerequisites:  Installed IntelliJ IDE.

2. Run:  Run maven test

3. Report:

* A Summary report "index.html" file will be stored at target folder: For example: target/surefire-reports/index.html
* A Json "OutputJson"  is inside target folder: For example: target/OutputJsonAtSun Feb 26 10:22:57 ICT 2023.json

### Project Structure:
1. Data package: 	

* OneDayWeatherInfo class: will be carry information about all info of weather in one day including country, date, day and nigh humility and temperature.

2. Pages package:
  
* HomePage class: present homepage, which have button "ten day" which is redirect to TenDayPage

* TenDayPage: present ten day pages: with weather information of many days

3. Data provider

* TenDayPageDataProvider: store data provider use in test
4. Test
* TenDayPageTest: all test which will be performed on TenDayPage






