package config;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public static Properties prop;
    public static String browserName;

    public Base() {
        try {
            prop = new Properties();
            FileInputStream data = new FileInputStream(
                    "src/main/java/config/testdata.properties");
            prop.load(data);
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void navigatTo() {
        driver.get(prop.getProperty("url"));
    }

    public void countElements(String id, int expectedCount) {
        List<WebElement> values = driver.findElements(By.xpath("//*[starts-with(@id, '" + id + "')]"));
        int count = values.size();
        Assert.assertEquals(count, expectedCount);
    }

    public static boolean isElementDisplayed(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public static void waitAndClick(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (StaleElementReferenceException e) {
            waitAndClick(element, timeout);
        }
    }

    public void click(WebElement ele) {
        ele.click();
    }

    public static void wait(int sec) {
        try {
            Thread.sleep(sec);
        } catch (Exception e) {
            wait(sec);
        }
    }
}