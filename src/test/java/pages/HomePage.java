package pages;

import config.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class HomePage extends Base {

    JavascriptExecutor js = ((JavascriptExecutor) driver);

    public HomePage() {

        PageFactory.initElements(driver, this);
    }
//
//    @FindBy(css = ".utility-nav__cart-icon")
//    public WebElement cartIcon;


    public void clickElementByJS(WebElement element) {

        js.executeScript("arguments[0].click();", element);
    }

    public void enterText(WebElement element, String txt) {
        js.executeScript("arguments[0].value='" + txt + "'", element);
    }

    public void verifyTitle(String Ac) {
        String Ex = driver.getTitle();
        Assert.assertEquals(Ex, Ac);
    }

    public void getInnerText(WebElement ele, String expValue) {
        String actual = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", ele);
        Assert.assertEquals(expValue, actual);
    }

    public void navigateToHomePage(String url) {

        try {
            driver.get(url);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}