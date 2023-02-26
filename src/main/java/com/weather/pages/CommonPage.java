package com.weather.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonPage {

     public CommonPage() { }

     protected void clickOnElement(WebDriver driver, By byElement) {
          new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(ExpectedConditions.visibilityOfElementLocated(byElement)).click();
     }

     protected void sendKeyToElement(WebDriver driver, By inputElement, String textValue) {
          WebElement searchField = new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(ExpectedConditions.elementToBeClickable(inputElement));
          searchField.clear();
          searchField.sendKeys(textValue);
     }

     public void selectItemFromParentDropdownList(WebDriver driver, By parentButtonList, String textSelected) {
          WebElement buttonSearch = new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(parentButtonList)).stream()
                  .filter(btn -> btn.getText().contains(textSelected)).findFirst().orElse(null);

          buttonSearch.click();
     }


     protected List<WebElement> getElementsByXpath(WebDriver driver, String xpath) {
          return driver.findElements(By.xpath(xpath));
     }
     protected String getAttributeOfElement(WebElement element) {
          return element.getAttribute("innerHTML");
     }

     protected String xpathBuilder( String rootPart, String indexPart, String finalPart) {
        return String.format("%s%s%s",rootPart, indexPart, finalPart);
    }
}
